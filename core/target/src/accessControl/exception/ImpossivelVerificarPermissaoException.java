package accessControl.exception;

public class ImpossivelVerificarPermissaoException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ImpossivelVerificarPermissaoException(String msg) {
        super(msg);
    }

    public ImpossivelVerificarPermissaoException(String msg, Exception e) {
        super(msg, e);
    }
}
