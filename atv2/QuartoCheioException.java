package atv2;

// Exceção para indicar que o quarto está cheio
public class QuartoCheioException extends Exception {
    public QuartoCheioException(String message) {
        super(message);
    }
}
