package com.example.software_sociais.database;

import com.example.software_sociais.objects.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eventos_DAO implements DAO <Evento>{
    @Override
    public void insert(Evento evento) {
        String sql = "INSERT INTO eventos(nome) VALUES (?)";
        try (Connection conn = Connection_database.conect() ){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getNome());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void del(Evento evento) {
        String sql = "DELETE FROM eventos " +
                "WHERE id = (?)";
        try (Connection conn = Connection_database.conect()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, evento.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Evento evento) {
        String sql = "UPDATE eventos " +
                "SET nome = (?), data = (?) " +
                "WHERE id = (?)";
        try (Connection conn = Connection_database.conect()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getData());
            ps.setInt(3, evento.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
