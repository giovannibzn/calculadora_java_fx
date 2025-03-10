# Calculadora em JavaFX

Este projeto é uma calculadora simples desenvolvida em **Java** utilizando a biblioteca **JavaFX** para a interface gráfica. A calculadora realiza operações básicas como adição, subtração, multiplicação e divisão.

## Funcionalidades

- **Operações básicas:**
  - Adição (+)
  - Subtração (-)
  - Multiplicação (×)
  - Divisão (÷)
- **Limpar tela:** Botão "C" para limpar a tela e reiniciar os cálculos.
- **Resultado:** Botão "=" para exibir o resultado da operação.
- **Interface amigável:** Design simples e intuitivo.

## Pré-requisitos

Para executar este projeto, você precisará de:

- **Java Development Kit (JDK) 11 ou superior.**
- **JavaFX SDK** (se não estiver usando um JDK que já inclui o JavaFX).
- **IDE** (recomendado: IntelliJ IDEA, Eclipse ou VS Code).

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/calculadora-javafx.git
   ```

2. **Importe o projeto na sua IDE:**
   - Abra a IDE e importe o projeto como um projeto Maven ou Gradle (dependendo da configuração do projeto).

3. **Configure o JavaFX:**
   - Se o JavaFX não estiver incluído no seu JDK, adicione o JavaFX SDK ao classpath do projeto.
   - Configure os módulos do JavaFX nas opções de execução da sua IDE:
     ```bash
     --module-path /caminho/para/javafx-sdk-XX/lib --add-modules javafx.controls,javafx.fxml
     ```

4. **Execute o projeto:**
   - Execute a classe `Main.java` para iniciar a calculadora.

## Estrutura do Projeto

- **`src/main/java/`:** Contém o código-fonte Java.
  - **`Main.java`:** Classe principal que inicia a aplicação JavaFX.
  - **`CalculadoraController.java`:** Controlador da interface gráfica, responsável pela lógica da calculadora.
  - **`Calculadora.fxml`:** Arquivo FXML que define a interface gráfica da calculadora.
- **`src/main/resources/`:** Contém recursos como arquivos FXML e CSS (se houver).

## Capturas de Tela

![Calculadora em JavaFX](screenshots/calculadora.png)

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal.
- **JavaFX:** Biblioteca para criação de interfaces gráficas.
- **FXML:** Para definir a interface gráfica de forma declarativa.
- **CSS:** Para estilização da interface (opcional).

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adicionando nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

