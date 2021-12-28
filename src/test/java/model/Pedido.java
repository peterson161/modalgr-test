package model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pedido {

    private Cliente cliente;
    private String numero;
    private String formaPagamento;
}
