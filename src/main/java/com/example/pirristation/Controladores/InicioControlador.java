package com.example.pirristation.Controladores;

import com.example.pirristation.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InicioControlador {
    @FXML
    private TextField usuario;
    
    @FXML
    private PasswordField contrasena;
    
    @FXML
    private Text textoUsuario,textoContrasena,errorInicio;

    @FXML
    public void initialize() {
        // Ocultar los mensajes de error al inicio
        textoUsuario.setVisible(false);
        textoContrasena.setVisible(false);
        errorInicio.setVisible(false);
    }

    @FXML
    public void iniciarSesion() {
        // Reiniciar mensajes de error
        textoUsuario.setVisible(false);
        textoContrasena.setVisible(false);
        errorInicio.setVisible(false);

        String usuarioText = usuario.getText();
        String contrasenaText = contrasena.getText();

        // Validar campos vacíos
        boolean hayError = false;
        if (usuarioText.isEmpty()) {
            textoUsuario.setVisible(true);
            hayError = true;
        }
        if (contrasenaText.isEmpty()) {
            textoContrasena.setVisible(true);
            hayError = true;
        }

        if (hayError) {
            return;
        }

        try {
            if (validarCredenciales(usuarioText, contrasenaText)) {
                App.setRoot("menuAdmin");
            } else {
                errorInicio.setVisible(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
            errorInicio.setText("Error del sistema: No se pudo verificar las credenciales");
            errorInicio.setVisible(true);
        }
    }

    private boolean validarCredenciales(String usuario, String password) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("credenciales.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] credenciales = linea.split(",");
                if (credenciales.length == 2 && 
                    credenciales[0].equals(usuario) && 
                    credenciales[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
