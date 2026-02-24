package com.gerenciador.envios.service;

import com.gerenciador.envios.dto.EnvioRequestDTO;
import com.gerenciador.envios.dto.EnvioResponseDTO;
import com.gerenciador.envios.dto.ProdutoResponseDTO;
import com.gerenciador.envios.entity.Envio;
import com.gerenciador.envios.entity.Produto;
import com.gerenciador.envios.enums.StatusEnvio;
import com.gerenciador.envios.mapper.ProdutoMapper;
import com.gerenciador.envios.repository.EnvioRepository;
import com.gerenciador.envios.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final ProdutoRepository produtoRepository;

    public EnvioService(EnvioRepository envioRepository, ProdutoRepository produtoRepository) {
        this.envioRepository = envioRepository;
        this.produtoRepository = produtoRepository;
    }

    public EnvioResponseDTO buscarPorCodigo(String codigo) {
        Envio envio = envioRepository.findByCodRastreio(codigo)
                .orElseThrow(() -> new RuntimeException("Envio não encontrado"));

        return EnvioResponseDTO.from(envio);
    }


    public EnvioResponseDTO criarEnvio(EnvioRequestDTO dto) {
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // 1️⃣ calcular volume
        int volume = produto.calcularVolume();

        // 2️⃣ valor base
        BigDecimal valorBase = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(0.05));

        // 3️⃣ aplicar tipo de frete
        BigDecimal valorFinal = dto.getTipoFrete().aplicar(valorBase);

        // 4️⃣ montar envio
        Envio envio = new Envio();
        envio.setRemetente(dto.getRemetente());
        envio.setDestinatario(dto.getDestinatario());
        envio.setProduto(produto);
        envio.setTipoFrete(dto.getTipoFrete());
        envio.setStatus(StatusEnvio.EM_PREPARACAO);
        envio.setDataEntrada(LocalDateTime.now());
        envio.setValorEnvio(valorFinal);
        envio.setCodRastreio(UUID.randomUUID().toString());

        Envio salvo = envioRepository.save(envio);

        return EnvioResponseDTO.from(salvo);
    }



}

