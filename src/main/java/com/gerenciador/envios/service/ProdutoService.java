package com.gerenciador.envios.service;

import com.gerenciador.envios.dto.ProdutoResponseDTO;
import com.gerenciador.envios.dto.ProdutoUpdateDTO;
import com.gerenciador.envios.entity.Produto;
import com.gerenciador.envios.mapper.ProdutoMapper;
import com.gerenciador.envios.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponseDTO salvar(Produto produto){
        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoMapper.toResponseDTO(produtoSalvo);
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrato"));
    }

    public ProdutoResponseDTO toResponse(Produto produto){
        return ProdutoMapper.toResponseDTO(produto);
    }


    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public void deletar(Long id){
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }

    public Produto atualizar(Long id, ProdutoUpdateDTO produtoUpdateDTO){
        Produto produto = buscarPorId(id);
        produto.setNome(produtoUpdateDTO.getNome());
        produto.setDescricao(produtoUpdateDTO.getDescricao());
        produto.setAltura(produtoUpdateDTO.getAltura());
        produto.setLargura(produtoUpdateDTO.getLargura());
        produto.setProfundidade(produtoUpdateDTO.getProfundidade());

        return produtoRepository.save(produto);
    }
}
