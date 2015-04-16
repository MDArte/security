package accessControl;

public class MoldeRestricao {
    private String entidadeOrigem;
    private String expressao;
    private String tipoAtributoDestino;
    private String alias;

    public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEntidadeOrigem() {
        return entidadeOrigem;
    }

    public void setEntidadeOrigem(String entidadeOrigem) {
        this.entidadeOrigem = entidadeOrigem;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

  
    
    public boolean equals(Object obj) {
        boolean equal = false;
        MoldeRestricao moldeRestricao = (MoldeRestricao) obj;

        if (this.entidadeOrigem.equals(moldeRestricao.getEntidadeOrigem()) &&
                this.expressao.equals(moldeRestricao.getExpressao()) &&
                this.tipoAtributoDestino.equals(
                    moldeRestricao.getTipoAtributoDestino()) &&
                    this.alias != null && this.alias.equals(moldeRestricao.getAlias())) {
            equal = true;
        }

        return equal;
    }
    

    public String getTipoAtributoDestino() {
        return tipoAtributoDestino;
    }

    public void setTipoAtributoDestino(String tipoAtributoDestino) {
        this.tipoAtributoDestino = tipoAtributoDestino;
    }
}
