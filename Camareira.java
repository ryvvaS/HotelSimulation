package atv2;
import java.util.List;

class Camareira extends Thread {
    private static int count = 0;
    private List<Quarto> quartos;
    private volatile boolean ativo;

    public Camareira(List<Quarto> quartos) {
        super("Camareira " + ++count);
        this.quartos = quartos;
        this.ativo = true;
    }

    public void parar() {
        this.ativo = false; // Método para parar a execução
    }

    @Override
    public void run() {
        while (this.ativo) {
            boolean todosLimpos = true;
            for (Quarto quarto : quartos) {
                synchronized (quarto) {
                    try {
                        quarto.limpar();
                    } catch (QuartoOcupadoException e) {
                        // O quarto está ocupado, continue para o próximo quarto
                        todosLimpos = false;
                        continue;
                    }
                }
            }
            if (todosLimpos) {
                this.parar();
            }
            try {
                Thread.sleep(10000); // Camareira leva algum tempo para limpar os quartos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
