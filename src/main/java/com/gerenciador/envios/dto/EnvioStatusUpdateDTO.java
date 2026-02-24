package com.gerenciador.envios.dto;

import com.gerenciador.envios.enums.StatusEnvio;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioStatusUpdateDTO {

    @NotNull
    private StatusEnvio status;
}
