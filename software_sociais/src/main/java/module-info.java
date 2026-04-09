module com.example.software_sociais {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.software_sociais to javafx.fxml;
    exports com.example.software_sociais;
    opens com.example.software_sociais.controllers to javafx.fxml;
    exports com.example.software_sociais.controllers;

    opens com.example.software_sociais.objects to javafx.fxml, javafx.base;
    exports com.example.software_sociais.objects;
    exports com.example.software_sociais.objects.DTO;
    opens com.example.software_sociais.objects.DTO to javafx.base, javafx.fxml;
}