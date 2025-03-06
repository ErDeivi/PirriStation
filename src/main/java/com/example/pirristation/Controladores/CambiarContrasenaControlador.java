package com.example.pirristation.Controladores;

import com.example.pirristation.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CambiarContrasenaControlador {
    @FXML
    private PasswordField contrasenaVieja, contrasenaNueva, contrasenaNueva2;
    @FXML
    private Text contrasenaCoincidir,camposVacios,contrasenaAntigua;
    @FXML
    private Button enviar,volver;
    @FXML
    public void initialize() {
        contrasenaCoincidir.setVisible(false);
        camposVacios.setVisible(false);
        contrasenaAntigua.setVisible(false);
    }

    public void cambiarContrasenaOnAction(ActionEvent actionEvent) {
        contrasenaCoincidir.setVisible(false);
        camposVacios.setVisible(false);
        contrasenaAntigua.setVisible(false);

        if (contrasenaVieja.getText().isEmpty() || contrasenaNueva.getText().isEmpty() || contrasenaNueva2.getText().isEmpty()) {
            camposVacios.setVisible(true);
            return;
        }

        if (!contrasenaNueva.getText().equals(contrasenaNueva2.getText())) {
            contrasenaCoincidir.setVisible(true);
            return;
        }

        if (actualizarContrasena(contrasenaVieja.getText(), contrasenaNueva.getText())) {
            App.setRoot("menuAdmin");
        } else {
            contrasenaAntigua.setVisible(true);
        }
    }

    private boolean actualizarContrasena(String contrasenaVieja, String contrasenaNueva) {
        List<String> lineas = new ArrayList<>();
        boolean contrasenaActualizada = false;

        // Primero leemos todo el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("credenciales.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] credenciales = linea.split(",");
                if (credenciales.length == 2) {
                    if (credenciales[1].equals(contrasenaVieja)) {
                        lineas.add(credenciales[0] + "," + contrasenaNueva);
                        contrasenaActualizada = true;
                    } else {
                        lineas.add(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Si encontramos y actualizamos la contraseña, escribimos el archivo
        if (contrasenaActualizada) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("credenciales.txt"))) {
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        return false;
    }

    public void volverOnAction(ActionEvent actionEvent) {
        App.setRoot("menuAdmin");
    }
}
