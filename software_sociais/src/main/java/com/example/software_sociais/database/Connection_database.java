package com.example.software_sociais.database;

import java.sql.*;


public class Connection_database {
    private static Connection conection;

    public static Connection conect(){
        try {
            if(conection == null || conection.isClosed() ) {
                String url = "jdbc:sqlite:database.db";
                conection = DriverManager.getConnection(url);
                //Ativa as chaves estrangeiras
                conection.createStatement().execute("PRAGMA foreignkey = ON");

                //Cria tabelas
                createTables();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com banco de dados: "+e.getMessage());
        }
        return conection;
    }
    private static void createTables(){
        //Criando tabela vendas
        String tbEventos_sql = "CREATE TABLE IF NOT EXISTS Eventos(\n" +
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tnome TEXT,\n" +
                "\tdata TEXT DEFAULT (date('now')),\n" +
                "\tresponsavel TEXT" +
                ");";

        String tbVendas_sql = "CREATE TABLE IF NOT EXISTS Vendas(\n" +
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tid_evento INTEGER,\n" +
                "\tproduto TEXT,\n" +
                "\tvalor NUMERIC NOT NULL,\n" +
                "\t--Criação da chave estrangeira\n" +
                "\tFOREIGN KEY (id_evento) REFERENCES Eventos(id) ON DELETE CASCADE\n" +
                ");";
        try (Statement stmt = conection.createStatement()){
            stmt.execute(tbEventos_sql);
            stmt.execute(tbVendas_sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
