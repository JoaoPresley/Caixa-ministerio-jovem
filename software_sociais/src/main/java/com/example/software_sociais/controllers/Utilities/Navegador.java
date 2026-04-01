package com.example.software_sociais.controllers.Utilities;

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

    //Função para ir para o FXML desejado
    public static void goToPage(Stage window, Scene pagina){
        //Pega a pagina atual e manda na pilha
        pilha.push(window.getScene().getRoot());
        //muda a scene
        window.setScene(pagina);
        window.show();
    }
    //Função para voltar a página
    public static void returnPage(Stage window) throws IOException {
        if(pilha.isEmpty()){
            //Pilha vazia vai para a tela inicial
            FXMLLoader fxmlLoader = new FXMLLoader(Navegador.class.getResource("com/example/software_sociais/start_frame.fxml"));
            Scene c = new Scene(fxmlLoader.load());
            window.setScene(c);
        }else{
            //Pilha com valores, volta para a ultima tela
            Scene c = new Scene(pilha.pop());
            window.setScene(c);
        }
        //mostra a tela com a cena anterior
        window.show();
    }
}
