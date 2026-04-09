package com.example.software_sociais.controllers.Utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerta {
    public static void alerta(String titulo, String texto, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }

    public static boolean sim_nao(String titulo, String mensagem){
        //Cria os botões
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");

        //Configura o alerta
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.getButtonTypes().setAll(sim, nao); //coloca os botoes

        Optional<ButtonType> choice = alert.showAndWait();
        //Se apertou em sim
        if(choice.isPresent() && choice.get() == sim){
            return true;
        }
        //se não apertou em sim
        return false;
    }
}
