public class Produto {
    String nome;
    double valor; //Valor de venda
    int quantidade;

    public Produto(String nome, double valor, int quantidade){
        if (valor < 0) throw new IllegalArgumentException("Preço inválido");
        if (quantidade < 0) throw  new IllegalArgumentException("Quantidade Invalida");

        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    public Produto(String nome){
        this(nome, 0, 0);
    }
}
