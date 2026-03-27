package com.example.software_sociais.objects;

public class Evento {
    private int id;
    private String nome;
    private String data;
    private String Responsavel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setResponsavel(String responsavel){
        this.Responsavel = responsavel;
    }

    public String geteResponsavel(){
        return this.Responsavel;
    }
}
