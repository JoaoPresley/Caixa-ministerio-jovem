public class Cliente {
    private String nome;
    private double divida;
    private String numero;

    public Cliente(String nome, String numero) {
        this.divida = 0;
        this.nome = nome;
        this.numero = numero;
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
