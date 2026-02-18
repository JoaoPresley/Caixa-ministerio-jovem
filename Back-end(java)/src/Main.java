//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
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