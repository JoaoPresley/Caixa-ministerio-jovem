package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Navegador;
import com.example.software_sociais.objects.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class init_vendasController implements Initializable {

    @FXML
    private TableColumn<Venda, String> colProduto;

    @FXML
    private TableColumn<Venda, Double> colValor;

    @FXML
    private Label lbl_titulo;

    @FXML
    private TableView<Venda> tabelaVendas;

    @FXML
    private TextField txt_vendaProduto;

    @FXML
    private TextField txt_vendaValor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Coloca nome do evento no titulo
        lbl_titulo.setText("Evento - " + Navegador.evento.getNome());

        //Inicializa as colunas
        colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        //atualiza as colunas
    }

    @FXML
    void clickRealizarVenda(ActionEvent event) {

    }

    @FXML
    void clickVoltar(ActionEvent event) {

    }
}
