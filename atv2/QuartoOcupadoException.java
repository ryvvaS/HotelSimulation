package atv2;

// Exceção para indicar que o quarto está ocupado e não pode ser limpo
public class QuartoOcupadoException extends Exception {
    public QuartoOcupadoException(String message) {
        super(message);
    }
}
