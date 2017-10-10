package MultiGraph;

/**
 * Exception class
 */
public class BadFileException extends Exception {

    /**
     * Prints an error message when file has incorrect formatting
     */
    public BadFileException(String message) {
        super(message);
    }
}
