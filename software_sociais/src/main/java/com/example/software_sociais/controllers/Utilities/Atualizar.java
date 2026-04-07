package com.example.software_sociais.controllers.Utilities;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.util.List;

public class Atualizar {
    public static <T> void AtualizarTabela(TableView<T> tabela, List<T> lista){
        ObservableList<T> obslista = FXCollections.observableArrayList(lista);
        tabela.setItems(obslista);
        tabela.refresh();
        //Joga para o ultimo item da lista
        tabela.scrollTo(lista.size() - 1);
    }
    public static void piscaBotao (Button bt){
        //transição de 100 milisegundos no botão
        FadeTransition fade = new FadeTransition(Duration.millis(100), bt);
        fade.setFromValue(1.0); //opaco
        fade.setToValue(0.5); //quase transparente
        fade.setCycleCount(2); //vai e volta
        fade.setAutoReverse(true);

        fade.play();
    }
}
