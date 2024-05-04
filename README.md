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
2. Hospede: Representa um hóspede do hotel, implementado como uma thread. Ele escolhe um quarto aleatório, tenta reservá-lo, permanece por um tempo no quarto, desocupa-o e depois realiza outras atividades. ![Classe Hospede](URL_da_Imagem)
3. Camareira: Representa uma camareira do hotel, também implementada como uma thread. Ela verifica se os quartos estão ocupados ou não e realiza a limpeza dos quartos. ![Classe Camareira](URL_da_Imagem)
4. Recepcionista: Representa um recepcionista do hotel, também implementado como uma thread. Ele recebe os hóspedes, tenta reservar quartos para eles e os adiciona à fila de espera, caso não haja quartos disponíveis. ![Classe Recepcionista](URL_da_Imagem)

## 🎁 Créditos

Créditos pelo template de [READEME](https://gist.github.com/lohhans/f8da0b147550df3f96914d3797e9fb89#-implanta%C3%A7%C3%A3o) utilizado neste projeto.


---
⌨️ com ❤️ pela equipe 😊
