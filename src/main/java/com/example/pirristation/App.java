package com.example.pirristation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import com.example.pirristation.Modelo.Videojuego;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.pirristation.Modelo.BandaSonora;
import com.example.pirristation.Modelo.Programador;

public class App extends Application {

    private static Stage primaryStage; // Almacenar el escenario principal
    private static Videojuego videojuegoModificar;
    private static Programador programadorModificar;
    private static BandaSonora bandaSonoraModificar;
    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"));
        stage.setTitle("PirriStation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setVideojuegoModificar(Videojuego videojuego) {
        videojuegoModificar = videojuego;
    }

    public static Videojuego getVideojuegoModificar() {
        return videojuegoModificar;
    }

    public static void setProgramadorModificar(Programador programador) {
        programadorModificar = programador;
    }

    public static Programador getProgramadorModificar() {
        return programadorModificar;
    }

    public static void setBandaSonoraModificar(BandaSonora bandaSonora) {
        bandaSonoraModificar = bandaSonora;
    }

    public static BandaSonora getBandaSonoraModificar() {
        return bandaSonoraModificar;
    }

    public static void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}