package com.gerenciador.envios.entity;

import com.gerenciador.envios.enums.StatusEnvio;
import com.gerenciador.envios.enums.TipoFrete;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_envio")
@Getter
@Setter
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "remetente_envio")
    private String remetente;

    @NotBlank
    @Column(name = "destinatario_envio")
    private String destinatario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @NotNull
    @Column(name = "status_envio")
    @Enumerated(EnumType.STRING)
    private StatusEnvio status;


    @Column(name = "dataEntrada_envio")
    private LocalDateTime dataEntrada;


    @Column(name = "dataEnvio_envio")
    private LocalDateTime dataEnvio;


    @Column(name = "dataEntrega_envio")
    private LocalDateTime dataEntrega;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoFrete_envio")
    private TipoFrete tipoFrete;

    @NotNull
    @Column(name = "valorEnvio_envio")
    private BigDecimal valorEnvio;

    @NotNull
    @Column(unique = true, nullable = false, name = "codRastreio_envio")
    private String codRastreio;






}
