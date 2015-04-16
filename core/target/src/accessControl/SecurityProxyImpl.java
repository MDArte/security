package accessControl;

import java.lang.reflect.Method;

import javax.ejb.EJBContext;

import org.jboss.security.SecurityAssociation;
import org.jboss.security.SecurityProxy;

/**
 * Responsavel por interceptar chamadas de servicos EJB2.
 *
 */
public class SecurityProxyImpl extends SecurityBase implements SecurityProxy {

	public void init(Class beanHome, Class beanRemote, Object securityMgr)
		throws InstantiationException {
	}

	public void init(Class beanHome, Class beanRemote, Class beanLocalHome, Class beanLocal, Object securityMgr)
		throws InstantiationException {
	}

	public void setEJBContext(EJBContext ctx) {
		try {
			/* tentado usar o SecurityAssociation - casos em que o EJB é chamado externamente */
			if (ctx.getCallerPrincipal() != null) {
				Object principal = SecurityAssociation.getPrincipal();
				if (principal != null) {
					String[] params = principal.toString().split("@");

					if (params.length == 2) {
						Object credential = SecurityAssociation.getCredential();

						if (credential != null) {
							ejbUsername = params[0];
							ejbPassword = credential.toString();
							ejbProjectName = params[1];
						}
					}
				}
			}
		} catch (java.lang.IllegalStateException e) {
			// ignorado
		}
	}

	public void invokeHome(Method m, Object[] args)
		throws Exception {
	}

	public void invoke(Method m, Object[] args, Object bean) throws Exception {
		interceptServiceMethod(m, args, bean);
	}
}
