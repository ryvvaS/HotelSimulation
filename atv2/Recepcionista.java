package atv2;
import java.util.List;
import java.util.Queue;

class Recepcionista extends Thread {
    private static int count = 0;
    private List<Quarto> quartos;
    private Queue<Hospede> filaEspera;
    private volatile boolean ativo;

    public Recepcionista(List<Quarto> quartos, Queue<Hospede> filaEspera) {
        super("Recepcionista " + ++count);
        this.quartos = quartos;
        this.filaEspera = filaEspera;
        this.ativo = true;
    }

    public void parar() {
        this.ativo = false; // Método para parar a execução
    }

    public synchronized void reservarQuarto(Hospede hospede) throws QuartoCheioException {
        for (Quarto quarto : quartos) {
            synchronized (quarto) {
                try {
                    quarto.reservar(hospede);
                    return;
                } catch (QuartoCheioException e) {
                    // O quarto está cheio, continue para o próximo quarto
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // Todos os quartos estão cheios, adicione o hóspede à fila de espera
        filaEspera.offer(hospede);
        System.out.println("Hóspede " + hospede.getName() + " adicionado à fila de espera.");
    }

    @Override
    public void run() {
        while (this.ativo) {
            synchronized (filaEspera) {
                while (!filaEspera.isEmpty()) {
                    Hospede hospede = filaEspera.poll();
                    try {
                        reservarQuarto(hospede);
                    } catch (QuartoCheioException e) {
                        // Hóspede tentou reservar um quarto duas vezes sem sucesso, deixe uma reclamação e vá embora
                        System.out.println("Hóspede " + hospede.getName() + " deixou uma reclamação e foi embora.");
                    }
                }
            }
            if (filaEspera.isEmpty()) {
                this.parar();
            }
            try {
                Thread.sleep(5000); // Recepcionista leva algum tempo para atender os hóspedes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}