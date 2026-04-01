package com.example.software_sociais.controllers.Utilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

public class Atualizar {
    public static <T> void AtualizarTabela(TableView<T> tabela, List<T> lista){
        ObservableList<T> obslista = FXCollections.observableArrayList(lista);
        tabela.setItems(obslista);
    }
}
