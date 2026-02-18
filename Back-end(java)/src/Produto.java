import java.util.ArrayList;
import java.util.Scanner;

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

    public static Produto cadastrar(ArrayList <Produto> lista){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();
        //valida se o produto já não foi cadastrado
        for (Produto p: lista){
            if(p.get_nome().equalsIgnoreCase(nome)){
                System.out.println("!!!Produto já cadastrado!!!");
                return null;
            }
        }

        System.out.print("Digite o valor do produto (0 caso não tenha): ");
        double valor = sc.nextDouble();
        System.out.print("Digite a quantidade do produto (0 caso não tenha): ");
        int quantidade = sc.nextInt();

        Produto p = new Produto(nome, valor, quantidade);
        return p;
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
