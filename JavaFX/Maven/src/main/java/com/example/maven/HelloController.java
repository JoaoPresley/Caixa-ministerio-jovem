package com.example.maven;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    // Campos de Clientes
    @FXML private TextField txtNomeCliente;
    @FXML private TextField txtNumeroCliente;
    @FXML private ListView<String> listClientes;
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    // Campos de Produtos
    @FXML private TextField txtNomeProduto;
    @FXML private TextField txtPrecoProduto;
    @FXML private TextField txtQtdProduto;
    @FXML private ListView<String> listProdutos;
    private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @FXML
    protected void onCadastrarCliente() {
        String nome = txtNomeCliente.getText();
        String numero = txtNumeroCliente.getText();

        if (!nome.isEmpty() && !numero.isEmpty()) {
            Cliente novo = new Cliente(nome, numero);
            clientes.add(novo);
            atualizarListaClientes();
            txtNomeCliente.clear();
            txtNumeroCliente.clear();
        }
    }

    @FXML
    protected void onCadastrarProduto() {
        try {
            String nome = txtNomeProduto.getText();
            double preco = Double.parseDouble(txtPrecoProduto.getText());
            int qtd = Integer.parseInt(txtQtdProduto.getText());

            Produto novo = new Produto(nome, preco, qtd);
            produtos.add(novo);
            atualizarListaProdutos();

            txtNomeProduto.clear();
            txtPrecoProduto.clear();
            txtQtdProduto.clear();
        } catch (NumberFormatException e) {
            System.out.println("Erro: Preço ou Quantidade inválidos");
        }
    }

    private void atualizarListaClientes() {
        ObservableList<String> nomes = FXCollections.observableArrayList();
        for (Cliente c : clientes) {
            nomes.add(c.get_nome() + " - Tel: " + c.get_numero());
        }
        listClientes.setItems(nomes);
    }

    private void atualizarListaProdutos() {
        ObservableList<String> nomes = FXCollections.observableArrayList();
        for (Produto p : produtos) {
            nomes.add(p.get_nome() + " - R$ " + p.get_valor() + " (" + p.get_quantidade() + " un)");
        }
        listProdutos.setItems(nomes);
    }
}