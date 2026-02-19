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
        sc.nextLine();//limpa buffer
        System.out.print("Digite a quantidade do produto (0 caso não tenha): ");
        int quantidade = sc.nextInt();
        sc.nextLine();//limpa buffer

        Produto p = new Produto(nome, valor, quantidade);
        return p;
    }

    public static Produto consultar(ArrayList <Produto> lista){
        Scanner sc = new Scanner(System.in);

        System.out.println("------- Consulta de produtos -------");
        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

        for(Produto p: lista){
            if(p.get_nome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        System.out.println("!!Nome não encontrado!!");
        return null;
    }

    public static void showORedit (Produto p){
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Informações do "+p.get_nome()+" ------");
        System.out.println("Quantidade: " + p.get_quatidade());
        System.out.println("Preço: " + p.get_valor());
        System.out.println("------------------------------");
        System.out.println("1 - Aumentar quantidade");
        System.out.println("2 - Diminuir quantidade");
        System.out.println("3 - Alterar valor");
        System.out.println("4 - Voltar");
        System.out.print("Digite opção escolhida: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> {
                //Aumentar quantidade
                System.out.print("Digite a quantidade a aumentar: ");
                int aumento = sc.nextInt();
                sc.nextLine();

                p.add_quantidade(aumento);
            }
            case 2 -> {
                //Diminuir quantidade
                System.out.print("Digite a quantidade a diminuir: ");
                int diminui = sc.nextInt();
                sc.nextLine();

                p.sub_quantidade(diminui);
            }
            case 3 -> {
                //Alterar valor
                System.out.print("Novo valor: ");
                p.set_valor(sc.nextDouble());
                sc.nextLine();
            }
            case 4 -> {
                //voltar
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return;
            }
        }
        //Recursiva da edição de cliente
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Produto.showORedit(p);
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
