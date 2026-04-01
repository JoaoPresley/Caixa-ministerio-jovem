package com.example.software_sociais.controllers.Utilities;

import javafx.scene.control.Alert;

public class Alerta {
    public static void alerta(String titulo, String texto, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}
