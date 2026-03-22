package com.example.software_sociais.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class start_frameController {

    @FXML
    private VBox vboxMenuPrincipal;

    @FXML
    private VBox vboxMenuVendas;

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
