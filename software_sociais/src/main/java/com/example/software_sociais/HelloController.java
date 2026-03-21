package com.example.software_sociais;

import com.example.software_sociais.database.Connection_database;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String sql = "INSERT INTO vendas(nome) VALUES(?)";
        try (Connection conn = Connection_database.conect()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "João");
            ps.execute();

            welcomeText.setText("Registrado no database.db");
        } catch (SQLException e) {
            welcomeText.setText("Erro ao salvar o banco");
        }

    }
}
