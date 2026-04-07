package com.example.software_sociais.database;

import com.example.software_sociais.objects.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class vendas_DAO implements DAO <Venda> {
    //Inserir dados na tabela vendas
    @Override
    public void insert(Venda venda){
        String sql = "INSERT INTO Vendas (id_evento, produto, valor)\n" +
                "VALUES (?, ?, ?)";
        try (Connection conn = Connection_database.conect()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, venda.getId_evento());
            ps.setString(2, venda.getProduto());
            ps.setDouble(3, venda.getValor());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void del(Venda venda) {

    }

    @Override
    public void update(Venda venda) {

    }

    @Override
    public List<Venda> listar() {
        List <Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vendas";
        try (Connection conn = Connection_database.conect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Venda v = new Venda();
                v.setValor(rs.getDouble("valor"));
                v.setProduto(rs.getString("produto"));
                v.setId_evento(rs.getInt("id_evento"));
                v.setId(rs.getInt("id"));

                lista.add(v);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar eventos");
            throw new RuntimeException(e);
        }
        return lista;
    }
}
