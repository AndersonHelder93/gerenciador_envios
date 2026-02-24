package com.gerenciador.envios.service;

import com.gerenciador.envios.dto.EnvioRequestDTO;
import com.gerenciador.envios.dto.EnvioResponseDTO;
import com.gerenciador.envios.entity.Envio;
import com.gerenciador.envios.entity.Produto;
import com.gerenciador.envios.enums.StatusEnvio;
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

        //  calcular volume
        int volume = produto.calcularVolume();

        //  valor base
        BigDecimal valorBase = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(0.05));

        // tipo de frete
        BigDecimal valorFinal = dto.getTipoFrete().aplicar(valorBase);

        // montar envio
        Envio envio = new Envio();
        envio.setRemetente(dto.getRemetente());
        envio.setDestinatario(dto.getDestinatario());
        envio.setProduto(produto);
        envio.setTipoFrete(dto.getTipoFrete());
        envio.setStatus(StatusEnvio.EM_PREPARACAO);
        envio.setDataEntrada(LocalDateTime.now());
        envio.setValorEnvio(valorFinal);
        envio.setCodRastreio(UUID.randomUUID().toString());
        envio.setCodRastreio(gerarCodigoRastreioUnico());

        Envio salvo = envioRepository.save(envio);

        return EnvioResponseDTO.from(salvo);
    }

    private String gerarCodigoRastreioUnico() {
        String codigo;
        do {
            codigo = UUID.randomUUID().toString();
        } while (envioRepository.existsByCodRastreio(codigo));
        return codigo;
    }


    public EnvioResponseDTO atualizarStatus(String codigo, StatusEnvio novoStatus) {
        Envio envio = envioRepository.findByCodRastreio(codigo)
                .orElseThrow(() -> new RuntimeException("Envio não encontrado"));

        envio.setStatus(novoStatus);

        Envio atualizado = envioRepository.save(envio);

        return EnvioResponseDTO.from(atualizado);
    }


}

