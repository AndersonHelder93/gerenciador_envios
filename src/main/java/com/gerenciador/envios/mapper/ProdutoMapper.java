package com.gerenciador.envios.mapper;

import com.gerenciador.envios.dto.ProdutoResponseDTO;
import com.gerenciador.envios.entity.Produto;

public class ProdutoMapper {

    public static ProdutoResponseDTO toResponseDTO(Produto produto){
        if(produto == null){
            throw new IllegalArgumentException("Produto não pode ser null");
        }
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setAltura(produto.getAltura());
        dto.setLargura(produto.getLargura());
        dto.setProfundidade(produto.getProfundidade());
        dto.setVolume(produto.calcularVolume());
        return dto;
    }
}
