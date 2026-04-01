package com.example.software_sociais.controllers;

import com.example.software_sociais.controllers.Utilities.Alerta;
import com.example.software_sociais.database.eventos_DAO;
import com.example.software_sociais.objects.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.software_sociais.controllers.Utilities.Alerta.alerta;

public class create_eventoController {

    @FXML
    private TextField txt_data;

    @FXML
    private TextField txt_nomeEvento;

    @FXML
    private TextField txt_nomeResponsavel;

    @FXML
    void clickRegistrarEvento(ActionEvent event) {
        if (txt_nomeEvento.getText().isBlank())//exige o preenchimento do nome do evento
        {
            alerta("Campos sem preenchimento", "Digite um nome para o evento", Alert.AlertType.ERROR);
            return;
        }
        //---------Campos estão validos para preencher--------
        //VARIAVEIS LOCAIS
        //Objeto para capturar dados
        Evento evento = new Evento();
        //Objeto para registar evento no BD
        eventos_DAO eventosDao = new eventos_DAO();


        //INSERINDO NOME DO EVENTO
        evento.setNome(txt_nomeEvento.getText());
        //INSERINDO DATA DO EVENTO
        if (txt_data.getText().isBlank()){
            //Caso esteja com a data em branco
            // Formata data para dd/MM/aaaa
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String hoje = LocalDate.now().format(formatter);
            //EXIBE O ALERTA
            alerta("Campos sem preenchimento",
                    "Campo de data sem preencher." +
                            "\n Registrado evento com a data: " + hoje, Alert.AlertType.WARNING);
            //set a data do evento
            evento.setData(hoje);
        }else{
            //Caso tenha data do evento
            evento.setData(txt_data.getText());
        }
        //INSIRINDO NOME DO RESPONSAVEL
        if (txt_nomeResponsavel.getText().isBlank()){
            //caso não tenha responsavel
            alerta("Campos sem preenchimento",
                    "Campo de responsavel sem preencher" +
                            "\n Registrado Responsavel com nullo.",
                    Alert.AlertType.WARNING);
            evento.setResponsavel(null);
        }else{
            //caso tenha responsavel
            evento.setResponsavel(txt_nomeResponsavel.getText());
        }

        //Insere evento no BD
        eventosDao.insert(evento);

        //Limpa todos os campos
        txt_nomeResponsavel.clear();
        txt_nomeEvento.clear();
        txt_data.clear();

    }

    @FXML
    void clickVoltar(ActionEvent event) {
        //Volta para Start
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/software_sociais/start_frame.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            Scene scene = new Scene(fxmlLoader.load());
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}


