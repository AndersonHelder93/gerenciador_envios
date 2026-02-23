package com.gerenciador.envios.enums;

import com.gerenciador.envios.entity.Produto;


public enum TipoFrete {

    NORMAL(10.0),
    SEDEX(20.0),
    RAPIDAO(30.0),
    COMETA(40.0);

    private final double taxaFixa;

    TipoFrete(double taxaFixa) {
        this.taxaFixa = taxaFixa;

    }


    public double calcularFrete(Produto produto) {
        return this.taxaFixa + (produto.calcularVolume() * 0.5);
    }

}
