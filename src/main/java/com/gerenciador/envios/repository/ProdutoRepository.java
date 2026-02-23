package com.gerenciador.envios.repository;

import com.gerenciador.envios.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
