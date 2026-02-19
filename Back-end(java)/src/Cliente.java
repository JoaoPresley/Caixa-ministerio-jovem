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

    /***
     * Método da classe para cadastrar qualquer cliente
     * @param lista -> Lista de clientes já cadastrados (Sem null)
     * @return Cliente
     */
    public static Cliente cadastrar(ArrayList <Cliente> lista){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        for(Cliente x: lista){
            if (x.get_nome() == nome){
                System.out.println("Nome de cliente já existente.");
                return null;
            }
        }
        System.out.print("Digite o numero do cliente: ");
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

    public static Cliente consultar(ArrayList <Cliente> lista ){
        Scanner sc = new Scanner(System.in);

        System.out.println("------- Consulta de clientes -------");
        System.out.println("Digite o nome do cliente (digite um nome inexistente para voltar): ");
        String nome = sc.nextLine();

        for(Cliente c: lista){
            if(c.get_nome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        System.out.println("!!Nome não encontrado!!");
        return null;
    }

    public static void showORedit (Cliente c){
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Informações do "+c.get_nome()+" ------");
        System.out.println("Dívida: " + c.get_divida());
        System.out.println("Numero: " + c.get_numero());
        System.out.println("------------------------------");
        System.out.println("1 - Aumentar divida");
        System.out.println("2 - Debitar divida");
        System.out.println("3 - Alterar numero");
        System.out.println("4 - Voltar");
        System.out.print("Digite opção escolhida: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> {
                //Aumentar divida
                System.out.print("Digite o aumento da divida: ");
                double aumento = sc.nextDouble();
                sc.nextLine();

                c.add_divida(aumento);
            }
            case 2 -> {
                //Diminuir divida
                System.out.print("Digite o debito da divida: ");
                double debito = sc.nextDouble();
                sc.nextLine();

                c.sub_divida(debito);
            }
            case 3 -> {
                //Alterar numero
                System.out.print("Novo numero: ");
                c.set_numero(sc.nextLine());
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
        Cliente.showORedit(c);
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
