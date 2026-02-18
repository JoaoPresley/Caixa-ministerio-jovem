import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <Produto> Lista_produtos = new ArrayList<Produto>();
        int op = menu_inicial();

        switch (op){
            case 1 -> {
               Lista_produtos.add(Produto.cadastrar(Lista_produtos));
            }
        }
    }
    public static int menu_inicial(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        var opcoes = List.of(1, 2, 3, 4, 10);

        do{
            System.out.println("Escolha uma opção:");
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