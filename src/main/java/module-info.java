module com.example.pirristation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pirristation to javafx.fxml;
    exports com.example.pirristation;
}