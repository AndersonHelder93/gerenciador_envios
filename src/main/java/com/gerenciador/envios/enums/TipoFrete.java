package com.gerenciador.envios.enums;

import com.gerenciador.envios.entity.Produto;

import java.math.BigDecimal;


public enum TipoFrete {

    NORMAL(0.10),
    SEDEX(0.20),
    RAPIDAO(0.30),
    COMETA(0.40);

    private final double percentual;

    TipoFrete(double taxaFixa) {
        this.percentual = taxaFixa;

    }

    public BigDecimal aplicar(BigDecimal valorBase) {
        return valorBase.add(valorBase.multiply(BigDecimal.valueOf(percentual)));
    }

}
