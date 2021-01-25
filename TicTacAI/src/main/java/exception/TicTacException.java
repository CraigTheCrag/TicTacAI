package exception;

public class TicTacException extends RuntimeException {
    
    private static final String DEFAULT_MESSAGE = "INVALID DIMENSIONS";
    
    public TicTacException() {
	super(DEFAULT_MESSAGE);
    }
    
    public TicTacException(String s) {
	super(s);
    }
    
}
