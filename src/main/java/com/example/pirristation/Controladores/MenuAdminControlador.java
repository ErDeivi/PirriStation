package com.example.pirristation.Controladores;

import com.example.pirristation.App;
import com.example.pirristation.Util.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuAdminControlador {
    private final DatabaseConnection conexion = new DatabaseConnection();

    public void gestionarVideojuegoOnAction(ActionEvent actionEvent) {
        App.setRoot("listadoVideojuegos");
    }

    public void gestionarProgramadorOnAction(ActionEvent actionEvent) {
        App.setRoot("listadoProgramadores");
    }

    public void gestionarBandaSonoraOnAction(ActionEvent actionEvent) {
        App.setRoot("crearBandaSonora");
    }

    public void exportarBD(ActionEvent actionEvent) {
        try {
            // Generar nombre del archivo con fecha y hora
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = now.format(formatter);
            String nombreArchivo = "backup_pirristation_" + timestamp + ".sql";
            
            // Crear el archivo en la carpeta backups
            File backupDir = new File("backups");
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }
            
            File backupFile = new File(backupDir, nombreArchivo);
            
            // Ejecutar el backup
            boolean success = DatabaseConnection.exportarBaseDatos(backupFile.getAbsolutePath());
            
            if (success) {
                App.mostrarMensaje("Éxito", "Base de datos exportada correctamente", "El archivo se ha guardado en: " + backupFile.getAbsolutePath());
            } else {
                App.mostrarError("Error", "Error al exportar la base de datos", "No se pudo completar la exportación.");
            }
        } catch (Exception e) {
            App.mostrarError("Error", "Error al exportar la base de datos", e.getMessage());
        }
    }

    public void importarBD(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar archivo de backup");
            fileChooser.setInitialDirectory(new File("backups"));
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos SQL", "*.sql")
            );
            
            File selectedFile = fileChooser.showOpenDialog(null);
            
            if (selectedFile != null) {
                boolean success = DatabaseConnection.importarBaseDatos(selectedFile.getAbsolutePath());
                
                if (success) {
                    App.mostrarMensaje("Éxito", "Base de datos importada correctamente", "La base de datos se ha restaurado desde: " + selectedFile.getAbsolutePath());
                } else {
                    App.mostrarError("Error", "Error al importar la base de datos", "No se pudo completar la importación.");
                }
            }
        } catch (Exception e) {
            App.mostrarError("Error", "Error al importar la base de datos", e.getMessage());
        }
    }

    public void cambiarContrasenaOnAction(ActionEvent actionEvent) {
        App.setRoot("cambiarContrasena");
    }

    public void cerrarSesionOnAction(ActionEvent actionEvent) {
        App.setRoot("inicio");
    }
}
