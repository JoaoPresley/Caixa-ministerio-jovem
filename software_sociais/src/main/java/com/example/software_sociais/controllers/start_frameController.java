package com.example.software_sociais.controllers;

import com.example.software_sociais.HelloApplication;
import com.example.software_sociais.controllers.Utilities.Navegador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class start_frameController {

    @FXML
    private VBox vboxMenuPrincipal;

    @FXML
    private VBox vboxMenuVendas;

    @FXML
    void clickCriarEvento(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/create_evento.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Navegador.goToPage(window, scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void clickConsultarEventos(ActionEvent event) {
        //A janela atual será usada
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Tela de consulta de eventos
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/view_eventos.fxml"));
        try {
            //Carrega fxml na tela
            Scene tela = new Scene(fxmlLoader.load());
            //mostra a tela
            Navegador.goToPage(window, tela);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clicouIniciarVendas(ActionEvent event) {
        // Esconde o principal
        vboxMenuPrincipal.setVisible(false);
        vboxMenuPrincipal.setManaged(false);

        // Mostra o de vendas
        vboxMenuVendas.setVisible(true);
        vboxMenuVendas.setManaged(true);
    }

    @FXML
    void clicouVoltar(ActionEvent event) {
        // Esconde o principal
        vboxMenuPrincipal.setVisible(true);
        vboxMenuPrincipal.setManaged(true);

        // Mostra o de vendas
        vboxMenuVendas.setVisible(false);
        vboxMenuVendas.setManaged(false);
    }

}
