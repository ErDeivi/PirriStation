module com.example.pirristation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.pirristation to javafx.fxml;
    opens com.example.pirristation.Controladores to javafx.fxml;
    opens com.example.pirristation.Modelo to javafx.base;
    
    exports com.example.pirristation;
    exports com.example.pirristation.Controladores;
    exports com.example.pirristation.Modelo;
}