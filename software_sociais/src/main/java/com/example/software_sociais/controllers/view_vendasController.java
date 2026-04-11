package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Atualizar;
import com.example.software_sociais.controllers.Utilities.Navegador;
import com.example.software_sociais.database.vendas_DAO;
import com.example.software_sociais.objects.DTO.VendaEvento_DTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class view_vendasController implements Initializable {

    @FXML
    private TableView<VendaEvento_DTO> tabelaVenda;

    @FXML
    private Label tituloVenda;

    @FXML
    private TableColumn<VendaEvento_DTO, String> vendaData;

    @FXML
    private TableColumn<VendaEvento_DTO, String> vendaProduto;

    @FXML
    private TableColumn<VendaEvento_DTO, Double> vendaValor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // INICIALIZAÇÃO DA TABLE VIEW
        //Inicia as colunas
        vendaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        vendaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        vendaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        //verifica se foi selecionado um evento para vizualizar
        if (Navegador.evento == null){
            //Preenche a tabela com os dados do VendaEvento_DTO
            vendas_DAO DAO = new vendas_DAO();
            Atualizar.AtualizarTabela(tabelaVenda, DAO.listarVendasEvento());
        }else {
            //Prenche a tabela com as vendas do evento em especifico
            vendas_DAO DAO = new vendas_DAO();
            Atualizar.AtualizarTabela(tabelaVenda,
                    DAO.listarVendasEvento_toEvento(Navegador.evento.getId())); //buca as vendas desse evento
        }

    }

    @FXML
    void clickVerEventos(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/view_eventos.fxml"));
        try {
            Navegador.goToPage((Stage) ((Node) event.getSource()).getScene().getWindow(), fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickVoltar(ActionEvent event) {
        try {
            Navegador.returnPage((Stage) ((Node) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
