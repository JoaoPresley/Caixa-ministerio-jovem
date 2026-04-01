package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Atualizar;
import com.example.software_sociais.controllers.Utilities.Navegador;
import com.example.software_sociais.database.eventos_DAO;
import com.example.software_sociais.objects.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class view_eventosController implements Initializable {

    @FXML
    private TableColumn<Evento, String> colData;
    @FXML
    private TableColumn<Evento, String> colNome;
    @FXML
    private TableColumn<Evento, String> colResponsavel;
    @FXML
    private TableView<Evento> tabelaEventos;

    @Override
    public void initialize(URL location, ResourceBundle resources){
            //Inicializa as colunas das tabelas
            colData.setCellValueFactory(new PropertyValueFactory<>("data"));
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colResponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));

            //
            eventos_DAO DAO = new eventos_DAO();//Manipulador de eventos do DB
            List <Evento> lista = DAO.listar(); //Lista de eventos do DB
            Atualizar.AtualizarTabela(tabelaEventos,lista);
    }

    @FXML
    void clickVoltar(ActionEvent event) {
        try {
            //Volta para ultima tela
            Navegador.returnPage((Stage) ((Node) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
