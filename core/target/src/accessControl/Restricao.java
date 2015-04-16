package accessControl;

import java.util.ArrayList;
import java.util.Collection;


public class Restricao {
    private MoldeRestricao moldeRestricao;
    private OperadorRestricao operadorRestricao;
    private Collection<ValorRestricao> valoresRestricao;

    public MoldeRestricao getMoldeRestricao() {
        return moldeRestricao;
    }

    public void setMoldeRestricao(MoldeRestricao moldeRestricao) {
        this.moldeRestricao = moldeRestricao;
    }

    public OperadorRestricao getOperadorRestricao() {
        return operadorRestricao;
    }

    public void setOperadorRestricao(OperadorRestricao operadorRestricao) {
        this.operadorRestricao = operadorRestricao;
    }

    public java.util.Collection<ValorRestricao> getValoresRestricao() {
        return valoresRestricao;
    }

    public void setValoresRestricao(
        java.util.Collection<ValorRestricao> valoresRestricao) {
        this.valoresRestricao = valoresRestricao;
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        Restricao restricao = (Restricao) obj;

        if (this.moldeRestricao.equals(restricao.getMoldeRestricao()) &&
                this.operadorRestricao.equals(restricao.getOperadorRestricao()) &&
                this.valoresRestricao.equals(restricao.getValoresRestricao())) {
            equal = true;
        }

        return equal;
    }
}
