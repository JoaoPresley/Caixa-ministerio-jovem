package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Atualizar;
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
            colData.setCellValueFactory(new PropertyValueFactory<>("data"));
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colResponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));

            eventos_DAO DAO = new eventos_DAO();
            List <Evento> lista = DAO.listar();
            Atualizar <Evento> up = new Atualizar<>();
            up.AtualizarTabela(tabelaEventos,lista);
    }

    @FXML
    void clickVoltar(ActionEvent event) {
        //essa janela

    }

    /*


    private void atualizartabela(){
        eventos_DAO dao = new eventos_DAO();
        List<Evento> lista = dao.listar();
        ObservableList <Evento> obsList = FXCollections.observableArrayList(lista);

        tabelaEventos.setItems(obsList);
    } */
}
