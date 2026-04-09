package com.example.software_sociais.controllers;

import com.example.software_sociais.objects.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class view_vendasController implements Initializable {

    @FXML
    private TableView<Venda> tabelaVenda;

    @FXML
    private Label tituloVenda;

    @FXML
    private TableColumn<Venda, String> vendaData;

    @FXML
    private TableColumn<Venda, String> vendaProduto;

    @FXML
    private TableColumn<Venda, Double> vendaValor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void clickVerEventos(ActionEvent event) {

    }

    @FXML
    void clickVoltar(ActionEvent event) {

    }

}
