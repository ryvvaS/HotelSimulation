package atv2;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class HotelSimulation {
    public static void main(String[] args) {
        // Criação de quartos, fila de espera e listas de threads
        List<Quarto> quartos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            quartos.add(new Quarto(i));
        }

        Queue<Hospede> filaEspera = new LinkedList<>();

        List<Thread> threads = new ArrayList<>();

        // Criação e inicialização de hóspedes
        for (int i = 0; i < 50; i++) {
            threads.add(new Hospede(quartos));
        }

        // Criação e inicialização de camareiras
        for (int i = 0; i < 10; i++) {
            threads.add(new Camareira(quartos));
        }

        // Criação e inicialização de recepcionistas
        for (int i = 0; i < 5; i++) {
            threads.add(new Recepcionista(quartos, filaEspera));
        }

        // Inicialização de todas as threads
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
