public class Produto {
    String nome;
    double valor; //Valor de venda
    int quantidade;

    //Construtor
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

    //getters
    public String get_nome(){
        return this.nome;
    }
    public double get_valor(){
        return  this.valor;
    }
    public int get_quatidade(){
        return  this.quantidade;
    }

    //Setters
    public void set_nome(String nome){
        this.nome = nome;
    }
    public void set_valor(double valor){
        this.valor = valor;
    }
    public void add_quantidade(int n){
        this.quantidade += n;
    }
    public void sub_quantidade(int n){
        this.quantidade -= n;
    }
}
