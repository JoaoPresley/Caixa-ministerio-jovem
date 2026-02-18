import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private double divida;
    private String numero;

    public Cliente(String nome, String numero) {
        this.divida = 0;
        this.nome = nome;
        this.numero = numero;
    }

    public static Cliente cadastrar(ArrayList <Cliente> lista){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        for(Cliente x: lista){
            if (x.get_nome() == nome){
                System.out.println("Nome de cliente já existente.");
                return null;
            }
        }
        System.out.println("Digite o numero do cliente: ");
        String numero = sc.nextLine();
        for(Cliente x: lista){
            if (x.get_numero() == numero){
                System.out.println("Numero de cliente já existente.");
                return null;
            }
        }


        Cliente c = new Cliente(nome, numero);
        return c;
    }

    //Setters
    /***
     *Aumenta o valor da divida
     * @param valor -> divida que será aumentada
     */
    public void add_divida(double valor){
        this.divida = this.divida + valor;
    }
    /***
     * Diminui o valor da divida
     * @param valor -> Valor da divida que foi quitado
     */
    public void sub_divida(double valor){
        this.divida = this.divida - valor;
    }
    public void set_nome(String nome){
        this.nome = nome;
    }
    public void set_numero(String numero){
        this.numero = numero;
    }

    //Getters
    public String get_nome(){
        return this.nome;
    }
    public String get_numero(){
        return this.numero;
    }
    public double get_divida(){
        return this.divida;
    }
}
