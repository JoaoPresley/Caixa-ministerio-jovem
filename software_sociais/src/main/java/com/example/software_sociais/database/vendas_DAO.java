package com.example.software_sociais.database;

import com.example.software_sociais.objects.DTO.VendaEvento_DTO;
import com.example.software_sociais.objects.Evento;
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
            System.err.println("Erro ao inserir venda!!!!");
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

    public List<Venda> listar_toEvento(int id_evento) {
        List <Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vendas WHERE id_evento = ?";
        try (Connection conn = Connection_database.conect();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id_evento);
            ResultSet rs = ps.executeQuery();

            //Envia os dado para a lista
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

    public List<VendaEvento_DTO> listarVendasEvento(){
        //Lista de retorno
        List<VendaEvento_DTO> lista = new ArrayList<>();
        //Query SQL
        String sql = "SELECT v.id AS id_venda,\n" +
                "\t\tv.id_evento AS id_evento,\n" +
                "\t\tv.produto AS produto,\n" +
                "\t\tv.valor AS valor,\n" +
                "\t\te.data AS data,\n" +
                "\t\te.nome AS nome,\n" +
                "\t\te.responsavel AS responsavel\n" +
                "FROM Vendas v \n" +
                "LEFT JOIN Eventos e\n" +
                "ON v.id_evento = e.id ";

        //Acesso ao BD
        try(Connection conn = Connection_database.conect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            //lé o leftJoin
            while (rs.next()){
                //Preenche dados do evento
                Evento e = new Evento();
                e.setResponsavel(rs.getString("responsavel"));
                e.setData(rs.getString("data"));
                e.setId(rs.getInt("id_evento"));
                e.setNome("nome");
                //Preenche dados da venda
                Venda v = new Venda();
                v.setValor(rs.getDouble("valor"));
                v.setId_evento(rs.getInt("id_evento"));
                v.setId(rs.getInt("id_venda"));
                v.setProduto(rs.getString("produto"));

                //Coloca a venda e o evento no objeto DTO
                VendaEvento_DTO DTO = new VendaEvento_DTO(e, v);
                lista.add(DTO); //isere DTO na lista de retorno
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<VendaEvento_DTO> listarVendasEvento_toEvento(int id_evento){
        List<VendaEvento_DTO> lista = new ArrayList<>();

        //Query SQL
        String sql = "SELECT v.id AS id_venda,\n" +
                "\t\tv.id_evento AS id_evento,\n" +
                "\t\tv.produto AS produto,\n" +
                "\t\tv.valor AS valor,\n" +
                "\t\te.data AS data,\n" +
                "\t\te.nome AS nome,\n" +
                "\t\te.responsavel AS responsavel\n" +
                "FROM Vendas v \n" +
                "LEFT JOIN Eventos e\n" +
                "ON v.id_evento = e.id \n" +
                "WHERE id_evento = ?";
        try(Connection conn = Connection_database.conect();
        PreparedStatement ps = conn.prepareStatement(sql)){
            //Procura as vendas do com o id_evento
            ps.setInt(1, id_evento);
            ResultSet rs = ps.executeQuery();
            //Preenche a lista com os dados do BD
            while (rs.next()){
                //Preenche dados do evento
                Evento e = new Evento();
                e.setResponsavel(rs.getString("responsavel"));
                e.setData(rs.getString("data"));
                e.setId(rs.getInt("id_evento"));
                e.setNome("nome");
                //Preenche dados da venda
                Venda v = new Venda();
                v.setValor(rs.getDouble("valor"));
                v.setId_evento(rs.getInt("id_evento"));
                v.setId(rs.getInt("id_venda"));
                v.setProduto(rs.getString("produto"));

                //Coloca a venda e o evento no objeto DTO
                VendaEvento_DTO DTO = new VendaEvento_DTO(e, v);
                lista.add(DTO); //isere DTO na lista de retorno
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return lista;
    }
}
