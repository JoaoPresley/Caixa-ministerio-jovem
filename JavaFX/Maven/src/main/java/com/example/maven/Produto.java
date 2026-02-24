package com.example.maven;

public class Produto {
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void add_quantidade(int n) { this.quantidade += n; }
    public void sub_quantidade(int n) { this.quantidade -= n; }

    // Getters e Setters
    public String get_nome() { return nome; }
    public double get_valor() { return valor; }
    public int get_quantidade() { return quantidade; }
    public void set_valor(double valor) { this.valor = valor; }
}
