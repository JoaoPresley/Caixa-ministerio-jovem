package com.example.software_sociais.database;

import java.sql.*;


public class Connection_database {
    private static Connection conection;

    public static Connection conect(){
        try {
            if(conection == null || conection.isClosed() ) {
                String url = "jdbc:sqlite:database.db";
                conection = DriverManager.getConnection(url);
                //Cria tabelas
                create_tables();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com banco de dados: "+e.getMessage());
        }
        return conection;
    }
    private static void create_tables(){
        //Criando tabela vendas
        String sql = "CREATE TABLE IF NOT EXISTS Eventos(\n" +
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tnome TEXT,\n" +
                "\tdata TEXT DEFAULT (date('now'))\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Vendas(\n" +
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tid_evento INTEGER,\n" +
                "\tproduto TEXT,\n" +
                "\tpreco REAL NOT NULL,\n" +
                "\t--Criação da chave estrangeira\n" +
                "\tFOREIGN KEY (id_evento) REFERENCES Eventos(id)\n" +
                ");";
        try (Statement stmt = conection.createStatement()){
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
