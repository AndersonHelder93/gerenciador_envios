package com.gerenciador.envios.repository;

import com.gerenciador.envios.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
