package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Atualizar;
import com.example.software_sociais.controllers.Utilities.Navegador;
import com.example.software_sociais.database.eventos_DAO;
import com.example.software_sociais.objects.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

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
        //Coloca os dados dos eventos na tabela
        eventos_DAO DAO = new eventos_DAO();//Manipulador de eventos do DB
        Atualizar.AtualizarTabela(tabelaEventos, DAO.listar());//Atualiza a tabela com os eventos

        //------------------
        //Configuração de click na tabela
        //Menu do botão direito
        ContextMenu menu = new ContextMenu();
        MenuItem delete = new MenuItem("deletar evento");
        menu.getItems().add(delete); //Adiciona item de delete no menu
        //  clicando no item de deletar
        delete.setOnAction(event -> {
            Evento selected =  tabelaEventos.getSelectionModel().getSelectedItem();
            if(selected != null){
                DAO.del(selected);
                Atualizar.AtualizarTabela(tabelaEventos, DAO.listar());
            }
        });

        //Quando clica em algum campo da tabela
        tabelaEventos.setOnMouseClicked(event -> {
            //se clicar com o botão esquerdo 2 vezes abre as vendas
            //se clicar com o botão esquerdo 1 vez fez o menu
            if (event.getButton() == MouseButton.PRIMARY){
                menu.hide();
                if(event.getClickCount() > 1){
                    //Abre vendas do evento
                }
            }

            //se clicar com o botão direito abre o menu para deletar evento
            if (event.getButton().name().equals("SECONDARY")){
                menu.show(tabelaEventos, event.getScreenX(), event.getScreenY());
            }
        });
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
