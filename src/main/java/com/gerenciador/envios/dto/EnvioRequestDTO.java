package com.gerenciador.envios.dto;

import com.gerenciador.envios.enums.TipoFrete;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioRequestDTO {

    @NotBlank
    private String remetente;

    @NotBlank
    private String destinatario;

    @NotNull
    private Long produtoId;

    @NotNull
    private TipoFrete tipoFrete;

}
