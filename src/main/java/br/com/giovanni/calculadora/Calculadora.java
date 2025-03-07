package br.com.giovanni.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

import static org.w3c.dom.events.MouseEvent.*;

public class Calculadora extends Application {

    private Label display = new Label("");
    private String currentInput = "";
    private String operador = "";
    private double previousValue = 0;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Calculadora simples");

        //Layout principal
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);

        //Display
        display.setId("display");
        display.setMinSize(200, 50);
        display.setMaxSize(200, 50);
        display.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(display, Priority.NEVER);
        root.getChildren().add(display);

        //Layout dos botoes
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        String[] buttons = {
          "7", "8", "9", "/",
          "4", "5", "6", "*",
          "1", "2", "3", "-",
          "0", "C", "=", "+"
        };

        int row = 0;
        int col = 0;
        for(String text : buttons){
            Button button = new Button(text);
            button.setMinSize(50, 50);
            //evento
            button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> handleButtonPress(text));
            button.addEventHandler(KeyEvent.KEY_PRESSED, e -> handleButtonPress(e.getText().toUpperCase()));
            button.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ENTER){
                    handleButtonPress("=");
                }
                if(e.getCode() == KeyCode.DELETE){
                    handleButtonPress("C");
                }
                if(e.getCode() == KeyCode.BACK_SPACE){
                    handleButtonPress("C");
                }
                if(e.getCode() == KeyCode.ESCAPE){
                    handleButtonPress("C");
                }
            });

            grid.add(button, col, row);
            col++;
            if(col > 3){
                col = 0;
                row++;
            }
        }

        root.getChildren().add(grid);

        //Configurar cena
        Scene scene = new Scene(root, 300, 350);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Lógica calculadora
    private void handleButtonPress(String value){
        switch (value){
            case "C":
                currentInput = "";
                operador = "";
                previousValue = 0;
                display.setText("");
                break;
            case "=":
                if(!currentInput.isEmpty() && !operador.isEmpty()){
                    double currentValue = Double.parseDouble(currentInput);
                    double result = calculate(previousValue, currentValue, operador);
                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    operador = "";
                }
                break;
            case "+": case "-": case"*": case"/":
                if(!currentInput.isEmpty()){
                    operador = value;
                    previousValue = Double.parseDouble(currentInput);
                    currentInput = "";
                }
                break;
            default:
                currentInput += value;
                display.setText(currentInput);
                break;
        }
    }

    //realizar calculo
    private double calculate(double a, double b, String op){
     switch (op){
         case "+":
             return  a + b;
         case "-":
             return  a - b;
         case "*":
             return  a * b;
         case "/":
             return  a / b;
         default:
             return 0;
     }
    }

    public static void main(String[] args) {
        launch();
    }
}