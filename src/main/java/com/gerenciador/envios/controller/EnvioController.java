package com.gerenciador.envios.controller;

import com.gerenciador.envios.dto.EnvioRequestDTO;
import com.gerenciador.envios.dto.EnvioResponseDTO;
import com.gerenciador.envios.entity.Envio;
import com.gerenciador.envios.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping
    public ResponseEntity<EnvioResponseDTO> criarEnvio(@RequestBody @Valid EnvioRequestDTO dto){
        EnvioResponseDTO responseDTO = envioService.criarEnvio(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/rastreio/{codigo}")
    public ResponseEntity<EnvioResponseDTO> buscarPorCodigo(@PathVariable String codigo){
        return ResponseEntity.ok(envioService.buscarPorCodigo(codigo));
    }
}
