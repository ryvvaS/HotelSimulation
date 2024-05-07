
package atv2;

class Quarto {
    private int numero;
    private boolean ocupado;
    private boolean limpo;
    private Hospede[] hospedes;
    private int numHospedes;

    public Quarto(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.limpo = true;
        this.hospedes = new Hospede[4]; // Capacidade máxima de 4 hóspedes
        this.numHospedes = 0;
    }

    public synchronized void reservar(Hospede hospede) throws InterruptedException, QuartoCheioException {
        // Se o quarto estiver cheio ou estiver sendo limpo, coloque o hóspede na fila de espera
        while (ocupado || (limpo && numHospedes >= 4)) {
            if (!limpo) {
                System.out.println("Quarto " + numero + " está sendo limpo. " + hospede.getName() + " está aguardando.");
            } else {
                System.out.println("Quarto " + numero + " está cheio. " + hospede.getName() + " está aguardando.");
            }
            wait();
        }
        
        // Se o quarto não estiver cheio, reserve o quarto para o hóspede
        if (!ocupado) {
            hospedes[numHospedes++] = hospede;
            System.out.println(hospede.getName() + " reservou o Quarto " + numero + ".");
            if (numHospedes == 4) {
                ocupado = true;
                limpo = false;
                System.out.println("Quarto " + numero + " está cheio. Limpeza será realizada após a saída dos hóspedes.");
            }
            return;
        }

        // Se o quarto estiver ocupado, lance uma exceção de quarto cheio
        throw new QuartoCheioException("Quarto " + numero + " está cheio.");
    }

    public synchronized void desocupar() {
        for (int i = 0; i < 4; i++) {
            if (hospedes[i] != null) {
                System.out.println("Hóspede " + hospedes[i].getName() + " deixou o Quarto " + numero + ".");
                hospedes[i] = null;
            }
        }
        numHospedes = 0;
        ocupado = false;
        limpo = false; // O quarto não está limpo até que seja limpo novamente
        System.out.println("Quarto " + numero + " desocupado. Limpeza em andamento.");
        notifyAll();
    }

    public synchronized void limpar() throws QuartoOcupadoException {
        // Se o quarto estiver ocupado, lance uma exceção
        if (ocupado) {
            throw new QuartoOcupadoException("Quarto " + numero + " está ocupado e não pode ser limpo.");
        }
        
        // Limpe o quarto
        limpo = true;
        System.out.println("Quarto " + numero + " limpo e pronto para ocupação.");
        notifyAll();
    }

    public boolean isLimpo() {
        return limpo;
    }

    public boolean isOcupado() {
        return ocupado;
    }
}