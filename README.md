# Projeto em grupo Programação Concorrente e distributíva

Repositório para entrega da atividade em grupo de concorrente e distribuída 

# Sobre o projeto

Este projeto consiste em uma simulação de um sistema de reserva e controle de quartos em um hotel, utilizando threads em Java. Ele aborda a interação entre diferentes entidades, como hóspedes, camareiras e recepcionistas, seguindo um conjunto de regras específicas.

# Como executar

Para executar este projeto, siga os passos abaixo:

1. Certifique-se de ter o Java 17 instalado em seu ambiente de desenvolvimento.
2. Utilize uma IDE como o VSCode com as seguintes extensões instaladas:
   - [Extension Pack for Java]([link1](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack))
   - [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug)
   - [Test Runner for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test)
   - [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
   - [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency)
3. Clone este repositório em sua máquina local.
4. Abra o projeto em sua IDE.
5. Execute o arquivo `HotelSimulation.java`.
6. Observe a saída no console para acompanhar a simulação do sistema.

# Explicação do código 
1. Quarto: Representa um quarto do hotel, com métodos para reservar, desocupar e limpar o quarto. Ele possui um número, estado de ocupação, estado de limpeza, uma fila de espera (caso o quarto esteja cheio) e uma lista de hóspedes. ![Classe Quarto](URL_da_Imagem)
2. Hospede:
   - A classe Hospede representa um hóspede que reserva e desocupa quartos em um hotel, executando em uma thread separada. Seu construtor inicializa atributos como o identificador único do hóspede e a lista de quartos disponíveis. O método run() é sobrescrito da classe Thread e controla o comportamento do hóspede enquanto estiver ativo, escolhendo aleatoriamente um quarto, reservando-o por um período de tempo, desocupando-o e aguardando antes de reservar novamente. Exceções do tipo InterruptedException e QuartoCheioException são tratadas durante a execução, com a pilha de chamadas sendo impressa no console para depuração. O método parar() permite interromper a execução do hóspede.
3. Camareira: Representa uma camareira do hotel, também implementada como uma thread. Ela verifica se os quartos estão ocupados ou não e realiza a limpeza dos quartos.
   - Atributos<br>
         count: Um contador estático para atribuir um número único a cada camareira criada.<br>
         quartos: Uma lista de quartos que a camareira deve limpar.<br>
         ativo: Um booleano volátil que indica se a camareira está ativa ou não. 
   - Construtor <br>
         Camareira(List<Quarto> quartos): O construtor da classe recebe uma lista de quartos que a camareira será responsável por limpar. Ele inicializa o nome da           thread da camareira com um número único e define a camareira como ativa. 
   - Métodos<br>
         parar(): Método para parar a execução da camareira. Define o atributo ativo como falso, indicando que a camareira deve parar de limpar os quartos. <br>
         run(): Sobrescreve o método run() da classe Thread. Este é o método principal que é executado quando a camareira é iniciada. Ele percorre a lista de                quartos, tentando limpá-los.<br> Se um quarto estiver ocupado, ele continua para o próximo quarto. Após limpar todos os quartos, a camareira aguarda um             período de 10 segundos antes de começar novamente o processo de limpeza. A execução continua até que a camareira seja explicitamente parada através do              método parar(). 
   - Exceção<br>
         QuartoOcupadoException: Exceção que é lançada quando a camareira tenta limpar um quarto que está ocupado. Neste caso, a camareira continua para o próximo           quarto. 
   - Sincronização
         O acesso aos quartos é sincronizado utilizando um bloco synchronized (quarto) para garantir que apenas uma camareira limpe um quarto por vez. 
4. Recepcionista: Representa um recepcionista do hotel, também implementado como uma thread. Ele recebe os hóspedes, tenta reservar quartos para eles e os adiciona à fila de espera, caso não haja quartos disponíveis. ![Classe Recepcionista](URL_da_Imagem)
# Integrantes do grupo
1.Guilherme dos Santos Mota (UC22101328) <br>
2.Matheus Da Cruz Santos (UC21200334) <br>
3.Ryann Vitório Vasconcelos (UC21200006) <br>
4.Gabriel Felipe Rezende de Jesus (UC22101458) <br>

## 🎁 Créditos

Créditos pelo template de [READEME](https://gist.github.com/lohhans/f8da0b147550df3f96914d3797e9fb89#-implanta%C3%A7%C3%A3o) utilizado neste projeto.


---
⌨️ com ❤️ pela equipe 😊
