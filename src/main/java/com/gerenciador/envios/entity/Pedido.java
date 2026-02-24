package com.gerenciador.envios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade_pedido")
    private Integer quantidade;

    @Column(name = "cepDestino_pedido")
    private String cepDestino;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

}

