package com.example.software_sociais.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class view_vendasController {

    @FXML
    private TableView<?> tabelaVenda;

    @FXML
    private Label tituloVenda;

    @FXML
    private TableColumn<?, ?> vendaData;

    @FXML
    private TableColumn<?, ?> vendaProduto;

    @FXML
    private TableColumn<?, ?> vendaValor;

    @FXML
    void clickIniciar_vendas(ActionEvent event) {

    }

    @FXML
    void clickVoltar(ActionEvent event) {

    }

}
