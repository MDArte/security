// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: PrincipalImpl.vsl in andromda-ejb-cartridge.
//
package accessControl;

import org.jboss.security.SimplePrincipal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class PrincipalImpl extends SimplePrincipal {
    private static final long serialVersionUID = 4459608890290012645L;
    private Collection<Perfil> perfis = new ArrayList<Perfil>();
    private Operador operador;
    private HashMap<String, Collection<Restricao>> restricoes;
    private HashMap parametrosRestricoesDinamicas;
    private String nomeProjeto;
    private boolean valido;    

    public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public HashMap getParametrosRestricoesDinamicas() {
		return parametrosRestricoesDinamicas;
	}

	public void setParametrosRestricoesDinamicas(
			HashMap parametrosRestricoesDinamicas) {
		this.parametrosRestricoesDinamicas = parametrosRestricoesDinamicas;
	}

	public PrincipalImpl(String arg0) {
        super(arg0);
    }

    public void setPerfis(Collection<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Operador getOperador() {
        return operador;
    }

    public HashMap<String, Collection<Restricao>> getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(HashMap<String, Collection<Restricao>> restricoes) {
        this.restricoes = restricoes;
    }

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
}
