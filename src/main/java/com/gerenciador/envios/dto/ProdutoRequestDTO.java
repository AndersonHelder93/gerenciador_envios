package com.gerenciador.envios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Altura é obrigatória")
    private Integer altura;

    @NotNull(message = "Largura é obrigatória")
    private Integer largura;

    @NotNull(message = "Profundidade é obrigatória")
    private Integer profundidade;

}
