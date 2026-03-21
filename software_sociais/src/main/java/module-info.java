module com.example.software_sociais {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.software_sociais to javafx.fxml;
    exports com.example.software_sociais;
}