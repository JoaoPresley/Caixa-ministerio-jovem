package com.example.software_sociais.controllers;

import com.example.software_sociais.HelloApplication;
import com.example.software_sociais.controllers.Utilities.Navegador;
import com.example.software_sociais.database.eventos_DAO;
import com.example.software_sociais.objects.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
            //Vai para nova pagina
            Navegador.goToPage(window, fxmlLoader.load());
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
            //mostra a tela
            Navegador.goToPage(window, fxmlLoader.load());
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

    @FXML
    void clickIniciarVendasSemEvento(ActionEvent event) {
        //Cria um evento com a data no lugar do nome
        Evento evento = new Evento();
        //Sem responsavel
        evento.setResponsavel(null);
        //Data é o Dia atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hoje = LocalDate.now().format(formatter);
        evento.setData(hoje);
        //Nome do evento é "Evento sem nome: data do evento"
        evento.setNome("evento sem nome");

        //Coloca evento no banco
        eventos_DAO DAO = new eventos_DAO();
        DAO.insert(evento);
        //Depois que foi inserido no banco obtemos o id desse evento e colocamos no navegador
        Navegador.evento = DAO.listar().getLast();

        //Abre a pagina de vendas
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/init_vendas.fxml"));
        try {
            Navegador.goToPage((Stage) ((Node) event.getSource()).getScene().getWindow(), fxmlLoader.load() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void clickConsultarVendas(ActionEvent event) {
        //Na pagina inicial não foi selecionado evento algum logo:
        Navegador.evento = null;
        //Navega para a pagina de vendas
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/view_vendas.fxml"));
        try {
            Navegador.goToPage((Stage) ((Node) event.getSource()).getScene().getWindow(), fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
