package com.example.software_sociais.controllers;

import com.example.software_sociais.objects.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class create_eventoController {

    @FXML
    private TextField txt_data;

    @FXML
    private TextField txt_nomeEvento;

    @FXML
    private TextField txt_nomeResponsavel;

    @FXML
    void clickRegistrarEvento(ActionEvent event) {
        if (txt_nomeEvento.getText().isBlank())//exige o preenchimento do nome do evento
        {
            alerta("Campos sem preenchimento", "Digite um nome para o evento", Alert.AlertType.ERROR);
            return;
        }
        if (txt_data.getText().isBlank() ||
        txt_nomeResponsavel.getText().isBlank()){
            alerta("Campos sem preenchimento", "Campos de data ou responsável sem preencher. \n Registrado evento sem esses campos", Alert.AlertType.WARNING);
        }
        //Cria objeto para capturar dados
        Evento evento = new Evento();
        evento.setData(txt_data.getText());


    }

    @FXML
    void clickVoltar(ActionEvent event) {
        //Volta para Start
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/start_frame.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            Scene scene = new Scene(fxmlLoader.load());
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void alerta(String titulo, String texto, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}


