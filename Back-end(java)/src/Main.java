import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <Produto> Lista_produtos = new ArrayList<Produto>();
        ArrayList <Cliente> Lista_clientes = new ArrayList<Cliente>();
        while (true){
            int op = menu_inicial();

            switch (op){
                case 1 -> {
                    Produto p = Produto.cadastrar(Lista_produtos);
                    if (p != null){
                        Lista_produtos.add(p);
                    }
                }
                case 2-> {
                    Cliente c = Cliente.cadastrar(Lista_clientes);
                    if (c != null) {
                        Lista_clientes.add(c);
                    }
                }
                case 4->{
                    Cliente.showORedit(Cliente.consultar(Lista_clientes));
                }
                case 10-> {
                    return;
                }
            }
        }
    }
    public static int menu_inicial(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        var opcoes = List.of(1, 2, 3, 4, 10);

        do{
            System.out.println("---------- Menu Inicial ----------");
            System.out.print("""
                    ----------------------------------------
                    1 - Cadastrar produto
                    2 - Cadastrar cliente
                    3 - Acessar produto
                    4 - Acessar cliente
                    10 - SAIR                
                    ---------------------------------------
                    Digite uma das opções: """);
            op = sc.nextInt();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (!opcoes.contains(op)) {
                System.out.println("!!!!!! Opção inválida! Tente novamente !!!!!!!!!!");
            }

        }while (!opcoes.contains(op));
        return op;
    }
}