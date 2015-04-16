package accessControl;

public class OperadorRestricao {
    public final static String IN = "IN";
    public final static String NOT_IN = "NOTIN";
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        OperadorRestricao operadorRestricao = (OperadorRestricao) obj;

        if (this.codigo.equals(operadorRestricao.getCodigo())) {
            equal = true;
        }

        return equal;
    }
}
