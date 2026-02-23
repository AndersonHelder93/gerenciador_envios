package com.gerenciador.envios.controller;

import com.gerenciador.envios.dto.ProdutoResponseDTO;
import com.gerenciador.envios.dto.ProdutoUpdateDTO;
import com.gerenciador.envios.entity.Produto;
import com.gerenciador.envios.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDTO salvar(@RequestBody @Valid Produto produto){
        return produtoService.salvar(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id){
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produtoService.toResponse(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar(){

        List<ProdutoResponseDTO> resposta = produtoService.listar()
                .stream()
                .map(produtoService::toResponse)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoUpdateDTO dto) {
        Produto produtoAtualizado = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(produtoService.toResponse(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
