package accessControl;

import java.util.HashMap;

public class AplicacoesSingleton {
	private static AplicacoesSingleton instance;
	
	private HashMap<String, HashMap<String, Aplicacao>> aplicacoes;
	
	private AplicacoesSingleton(){}


	public HashMap<String, HashMap<String, Aplicacao>> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(HashMap<String, HashMap<String, Aplicacao>> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}	

	public synchronized static final AplicacoesSingleton instance() {
        if (instance == null) {
            instance = new AplicacoesSingleton();
        }

        return instance;
    }
	
	
}
