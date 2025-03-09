package com.example.pirristation.Controladores;

import com.example.pirristation.App;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginControlador {
    @FXML
    private TextField usuario;
    
    @FXML
    private PasswordField contrasena;
    
    @FXML
    private Text error;
    
    @FXML
    private void iniciarSesion() {
        String user = usuario.getText();
        String pass = contrasena.getText();
        
        // Por ahora hardcodeamos las credenciales
        if (user.equals("admin") && pass.equals("admin")) {
            error.setVisible(false);
            App.setRoot("menuAdmin");
        } else {
            error.setVisible(true);
        }
    }
} 