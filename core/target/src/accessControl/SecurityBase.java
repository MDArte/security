package accessControl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;

import accessControl.exception.AcessoNegadoException;
import accessControl.exception.NomeProjetoNaoEncontradoException;
import accessControl.exception.SubjectNaoIdentificadoException;

public class SecurityBase {
	protected String ejbUsername = null;
	protected String ejbPassword = null;
	protected String ejbProjectName = null;

	protected void interceptServiceMethod(Method m, Object[] args, Object bean) throws Exception {
		Subject subject = SecurityHolder.getSubject();
		Servico servico = new Servico(toString(m, args));
		boolean possuiPermissao = false;

		if (subject == null && ejbUsername != null && ejbPassword != null && ejbProjectName != null) {
			CallbackHandler handler = new LoginCallbackHandler(ejbUsername, ejbPassword);
			LoginContext loginContext = new LoginContext(ejbProjectName, handler);
			loginContext.login();

			subject = loginContext.getSubject();
			SecurityHolder.setSubject(subject);
		}

		if (subject == null) {
			throw new SubjectNaoIdentificadoException("subject.null");
		} else {
			PrincipalImpl principal = ControleAcesso.getCallerPrincipal(subject);

			if (ejbProjectName != null) {
				principal.setNomeProjeto(ejbProjectName);
			}
			else if (principal.getNomeProjeto() == null) {
				throw new NomeProjetoNaoEncontradoException("nome.projeto.null");
			}

			HashMap<String, HashMap<String, Collection<Perfil>>> servicos = ServicosSingleton.instance().getServicos();
			HashMap<String, Collection<accessControl.Perfil>> mapServicos;
			if (servicos == null) {
				mapServicos = new HashMap<String, Collection<accessControl.Perfil>>();
			} else {
				mapServicos = servicos.get(principal.getNomeProjeto());
			}

			if (principal.isValido()) {
				possuiPermissao = true;
			} else {
				possuiPermissao = ControleAcesso.verificaPermissao(subject, mapServicos, servico, false);
			}
			if (!possuiPermissao) {
				throw new AcessoNegadoException("acesso.negado  - " + servico.getNome());
			}
		}
	}

	private String toString(Method m, Object[] args) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(m.getDeclaringClass().getName() + ".");
			sb.append(m.getName() + "(");
			Class[] params = m.getParameterTypes(); 
			for (int j = 0; j < params.length; j++) {
				String nomeParam = params[j].getName();
				String simpleNomeParam = params[j].getSimpleName();
				if (nomeParam.startsWith("[")) {
					nomeParam = nomeParam.substring(2);
					nomeParam = nomeParam.replace(";", "");
					String teste = simpleNomeParam.replace("[]", "");
					nomeParam = nomeParam.replace(teste, "");
					nomeParam = nomeParam + simpleNomeParam;
				}
				sb.append(nomeParam);

				if (j < (params.length - 1)) {
					sb.append(", ");
				}
			}
			sb.append(")");

			String str = sb.toString();

			if (str.matches(".*Bean\\.\\w*\\(.*\\)"))
				str = str.replaceAll("(.*)Bean(\\.\\w*\\(.*\\))", "$1BI$2");

			if (!str.matches(".*BI\\.\\w*\\(.*\\)"))
				str = str.replaceAll("(.*)(\\.\\w*\\(.*\\))", "$1BI$2");

			return str;
		} catch (Exception e) {
			return "<" + e + ">";
		}
	}
}
