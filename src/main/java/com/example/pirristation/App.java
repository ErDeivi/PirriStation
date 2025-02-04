package com.example.pirristation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static Stage primaryStage; // Almacenar el escenario principal
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage; // Inicializar el escenario principal

        // Cargar la primera escena
        setRoot("modificarVideojuego"); // Cambiar a la vista de listados
        stage.setTitle("App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setRoot(String fxml) {
        try {
            Parent root = loadFXML(fxml); // Cargar el nuevo FXML
            Scene scene = new Scene(root);
            primaryStage.setScene(scene); // Cambiar la escena del escenario principal
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}