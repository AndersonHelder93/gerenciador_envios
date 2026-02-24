package com.gerenciador.envios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter @Setter
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @Column(name = "peso_produto")
    private BigDecimal peso;

    public Produto(){
    }

    public Produto(Long id, String nome, String descricao, Integer altura, Integer largura, Integer profundidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }


    public Integer calcularVolume(){
        return this.altura * this.largura * this.profundidade;

    }

}
