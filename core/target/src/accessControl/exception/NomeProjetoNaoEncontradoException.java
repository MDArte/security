package accessControl.exception;

public class NomeProjetoNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NomeProjetoNaoEncontradoException(Exception e) {
        super(e);
    }

    public NomeProjetoNaoEncontradoException(String message) {
        super(message);
    }

}
