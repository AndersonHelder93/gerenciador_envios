package com.gerenciador.envios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer altura;
    private Integer largura;
    private Integer profundidade;
    private Integer volume;

    public ProdutoResponseDTO() {
    }
}
