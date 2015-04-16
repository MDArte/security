package accessControl;

public class ValorRestricao {
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        ValorRestricao valorRestricao = (ValorRestricao) obj;

        if (this.valor.equals(valorRestricao.getValor())) {
            equal = true;
        }

        return equal;
    }
}
