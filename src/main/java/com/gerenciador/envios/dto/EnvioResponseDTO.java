package com.gerenciador.envios.dto;

import com.gerenciador.envios.entity.Envio;
import com.gerenciador.envios.entity.Produto;
import com.gerenciador.envios.enums.StatusEnvio;
import com.gerenciador.envios.enums.TipoFrete;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EnvioResponseDTO {

    private Long produtoId;
    private String produtoNome;
    private String remetente;
    private String destinatario;
    private StatusEnvio status;
    private LocalDateTime dataEntrada;
    private TipoFrete tipoFrete;
    private BigDecimal valorEnvio;
    private String codRastreio;

    public EnvioResponseDTO(){
    }

    public static EnvioResponseDTO from(Envio envio) {
        EnvioResponseDTO dto = new EnvioResponseDTO();

        dto.setProdutoId(envio.getProduto().getId());
        dto.setProdutoNome(envio.getProduto().getNome());
        dto.setRemetente(envio.getRemetente());
        dto.setDestinatario(envio.getDestinatario());
        dto.setStatus(envio.getStatus());
        dto.setDataEntrada(envio.getDataEntrada());
        dto.setTipoFrete(envio.getTipoFrete());
        dto.setValorEnvio(envio.getValorEnvio());
        dto.setCodRastreio(envio.getCodRastreio());

        return dto;
    }


}

