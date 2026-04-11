package com.example.software_sociais.objects.DTO;

import com.example.software_sociais.objects.Evento;
import com.example.software_sociais.objects.Venda;

public class VendaEvento_DTO {
    private Venda venda;
    private Evento evento;

    public VendaEvento_DTO(Evento e, Venda v){
        this.venda = v;
        this.evento = e;
    }

    //Getters-> Envento, por enquanto apenas data
    public String getData(){
        return evento.getData();
    }
    //       -> Venda, Produto e valor, por enquanto
    public String getProduto(){
        return venda.getProduto();
    }
    public double getValor(){
        return venda.getValor();
    }
}
