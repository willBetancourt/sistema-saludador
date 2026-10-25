package co.edu.laboratorio.saludador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SistemaSaludador extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Sistema Saludador");
        titulo.setFont(Font.font("Arial", 26));
        titulo.setTextFill(Color.web("#153e75"));

        Label subtitulo = new Label("Completa tus datos para recibir un saludo personalizado.");

        TextField nombre = new TextField();
        nombre.setPromptText("Ej. Andrea");
        TextField edad = new TextField();
        edad.setPromptText("Ej. 20");
        TextField hora = new TextField();
        hora.setPromptText("Ej. 8:30");
        ComboBox<String> periodo = new ComboBox<>();
        periodo.getItems().addAll("AM", "PM");
        periodo.setValue("AM");
        periodo.setMaxWidth(Double.MAX_VALUE);

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(14);
        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(nombre, 1, 0);
        formulario.add(new Label("Edad:"), 0, 1);
        formulario.add(edad, 1, 1);
        formulario.add(new Label("Hora:"), 0, 2);
        HBox horaBox = new HBox(8, hora, periodo);
        HBox.setHgrow(hora, Priority.ALWAYS);
        formulario.add(horaBox, 1, 2);
        nombre.setMaxWidth(Double.MAX_VALUE);
        edad.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(nombre, Priority.ALWAYS);
        GridPane.setHgrow(edad, Priority.ALWAYS);
        GridPane.setHgrow(horaBox, Priority.ALWAYS);

        Button saludar = new Button("Saludar");
        saludar.setDefaultButton(true);
        saludar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 24;");
        Label resultado = new Label("Tu saludo aparecerá aquí.");
        resultado.setWrapText(true);
        resultado.setFont(Font.font("Arial", 16));
        resultado.setTextFill(Color.web("#166534"));

        saludar.setOnAction(event -> {
            String nombreIngresado = nombre.getText().trim();
            String edadTexto = edad.getText().trim();
            String horaTexto = hora.getText().trim();

            if (nombreIngresado.isEmpty() || edadTexto.isEmpty() || horaTexto.isEmpty()) {
                mostrarError(resultado, "Por favor, completa nombre, edad y hora.");
                return;
            }

            int edadIngresada;
            try {
                edadIngresada = Integer.parseInt(edadTexto);
                if (edadIngresada < 0 || edadIngresada > 120) {
                    mostrarError(resultado, "Ingresa una edad válida entre 0 y 120.");
                    return;
                }
            } catch (NumberFormatException ex) {
                mostrarError(resultado, "La edad debe ser un número entero.");
                return;
            }

            int horaNumerica;
            int minutos = 0;
            try {
                String[] partes = horaTexto.split(":");
                if (partes.length > 2 || partes.length == 0) throw new NumberFormatException();
                horaNumerica = Integer.parseInt(partes[0]);
                if (partes.length == 2) minutos = Integer.parseInt(partes[1]);
                if (horaNumerica < 1 || horaNumerica > 12 || minutos < 0 || minutos > 59) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                mostrarError(resultado, "La hora debe tener formato de 1 a 12, por ejemplo 8:30.");
                return;
            }

            String saludo;
            if (periodo.getValue().equals("AM")) {
                saludo = (horaNumerica == 12) ? "¡Buenas noches" : "¡Buenos días";
            } else {
                saludo = (horaNumerica >= 1 && horaNumerica < 6) ? "¡Buenas tardes" : "¡Buenas noches";
            }

            resultado.setText(String.format("%s, %s! Nos alegra saludarte. Tienes %d años. Hora registrada: %s %s.",
                    saludo, nombreIngresado, edadIngresada, horaTexto, periodo.getValue()));
            resultado.setTextFill(Color.web("#166534"));
        });

        VBox contenido = new VBox(18, titulo, subtitulo, formulario, saludar, resultado);
        contenido.setPadding(new Insets(28));
        contenido.setAlignment(Pos.CENTER_LEFT);
        contenido.setMaxWidth(540);
        contenido.setStyle("-fx-background-color: white; -fx-background-radius: 16;");

        StackPane raiz = new StackPane(contenido);
        raiz.setPadding(new Insets(24));
        raiz.setStyle("-fx-background-color: linear-gradient(to bottom right, #dbeafe, #f8fafc);");

        stage.setTitle("Sistema Saludador");
        stage.setScene(new Scene(raiz, 650, 440));
        stage.setMinWidth(580);
        stage.setMinHeight(400);
        stage.show();
    }

    private void mostrarError(Label resultado, String mensaje) {
        resultado.setText(mensaje);
        resultado.setTextFill(Color.web("#b91c1c"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
