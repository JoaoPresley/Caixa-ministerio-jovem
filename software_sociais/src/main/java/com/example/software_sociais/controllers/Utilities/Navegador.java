package com.example.software_sociais.controllers.Utilities;

import com.example.software_sociais.objects.Evento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class Navegador {
    //Pilha das ultimas páginas
    private static final Stack <Parent> pilha = new Stack<>();
    //Varivel do evento
    public static Evento evento;

    //Função para ir para o FXML desejado
    public static void goToPage(Stage window, Parent pagina){
        //Pega a pagina atual e manda na pilha
        pilha.push(window.getScene().getRoot());
        //muda o conteudo da tela
        window.getScene().setRoot(pagina);
        window.show();
    }
    //Função para voltar a página
    public static void returnPage(Stage window) throws IOException {
        if(pilha.isEmpty()){
            //Pilha vazia vai para a tela inicial
            FXMLLoader fxmlLoader = new FXMLLoader(Navegador.class.getResource("/com/example/software_sociais/start_frame.fxml"));
            window.getScene().setRoot(fxmlLoader.load());
        }else{
            //Pilha com valores, volta para a ultima tela
            window.getScene().setRoot(pilha.pop());
        }
        //mostra a tela com a cena anterior
        window.show();
    }
}
