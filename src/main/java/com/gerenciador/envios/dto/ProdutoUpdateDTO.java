package com.gerenciador.envios.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoUpdateDTO {

    @NotBlank
    @Column(name = "nome_produto")
    private String nome;

    @NotBlank
    @Column(name = "descricao_produto")
    private String descricao;

    @NotNull
    @Column(name = "altura_produto")
    private Integer altura;

    @NotNull
    @Column(name = "largura_produto")
    private Integer largura;

    @NotNull
    @Column(name = "profundidade_produto")
    private Integer profundidade;
}
