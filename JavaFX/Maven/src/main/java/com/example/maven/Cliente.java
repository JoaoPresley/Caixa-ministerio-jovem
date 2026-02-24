package com.example.maven;

public class Cliente {
    private String nome;
    private double divida;
    private String numero;

    public Cliente(String nome, String numero) {
        this.divida = 0;
        this.nome = nome;
        this.numero = numero;
    }

    public void add_divida(double valor) { this.divida += valor; }
    public void sub_divida(double valor) { this.divida -= valor; }

    // Getters e Setters
    public String get_nome() { return this.nome; }
    public String get_numero() { return this.numero; }
    public double get_divida() { return this.divida; }
    public void set_numero(String numero) { this.numero = numero; }
}
