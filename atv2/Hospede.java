package atv2;
import java.util.List;
import java.util.Random;

class Hospede extends Thread {
    private static int count = 0;
    private int id;
    private List<Quarto> quartos;
    private Random random = new Random();
    private volatile boolean ativo;


    public Hospede(List<Quarto> quartos) {
        this.id = ++count;
        this.quartos = quartos;
        this.ativo = true;
    }

    public void parar() {
        this.ativo = false; // Método para parar a execução
    }

    @Override
    public void run() {
        while (this.ativo) {
            int quartoIndex = random.nextInt(quartos.size());
            Quarto quarto = quartos.get(quartoIndex);
            try {
                quarto.reservar(this);
                Thread.sleep(random.nextInt(5000)); // Hóspede permanece no quarto por um tempo
                quarto.desocupar();
                Thread.sleep(random.nextInt(10000)); // Hóspede realiza outras atividades antes de reservar novamente
                this.parar();
            } catch (InterruptedException | QuartoCheioException e) {
                e.printStackTrace();
            }
        }
    }
}