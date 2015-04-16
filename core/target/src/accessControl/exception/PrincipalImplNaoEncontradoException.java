package accessControl.exception;

public class PrincipalImplNaoEncontradoException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PrincipalImplNaoEncontradoException() {
        super();

        // TODO Auto-generated constructor stub
    }

    public PrincipalImplNaoEncontradoException(String msg) {
        super(msg);
    }

    public PrincipalImplNaoEncontradoException(String msg,
        ImpossivelObterOperadorException e) {
        super(msg, e);
    }
}
