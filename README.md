# Calculador-de-IMC
## Calculadora para o IMC (Índice de Massa Corporal) feita em Java utilizando a Biblioteca Swing

### ⚙️ Funcionalidades:
* **Cálculo:** Calculo automático do IMC, informando ao usuário seu valor e sua faixa atual.
* **Conversão de Altura:** Cálculo pode ser realizado independente do valor de altura ser inserido em cm ou m.
* **Interface Gráfica:** Tela visual, botões interativos (com suporte ao uso de teclado) construídos com a biblioteca Swing.

### 💻 Tecnologias: 
* **Java:** Linguagem de programação principal;
* **Swing:** Biblioteca utilizada para construir a interface gráfica;
* **Maven:** Ferramenta de Construção e Automação, responsável por estruturar o projeto e gerar o arquivo `.jar` executável.
* **Git e GitHub:** Controle de versão da linha do tempo e hospedagem do código-fonte.

### Como Executar:
> Requerimentos: Java 8.0+ & Maven instalado

1. Clone o repositório ou baixe o código fonte;
2. Abra o terminal e navegue até a pasta raiz do projeto e construa o aplicativo com o comando:
```bash
mvn clean package
```
3. Navegue até a nova pasta `target` e execute o programa com o comando:
```bash
java -jar CalculadoraDeIMC-1.0-SNAPSHOT.jar
```