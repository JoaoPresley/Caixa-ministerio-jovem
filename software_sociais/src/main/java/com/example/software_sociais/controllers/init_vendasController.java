package com.example.software_sociais.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class init_vendasController {

    @FXML
    private TableColumn<?, ?> colProduto;

    @FXML
    private TableColumn<?, ?> colValor;

    @FXML
    private Label lbl_titulo;

    @FXML
    private TableView<?> tabelaVendas;

    @FXML
    private TextField txt_vendaProduto;

    @FXML
    private TextField txt_vendaValor;

    @FXML
    void clickRealizarVenda(ActionEvent event) {

    }

    @FXML
    void clickVoltar(ActionEvent event) {

    }

}
