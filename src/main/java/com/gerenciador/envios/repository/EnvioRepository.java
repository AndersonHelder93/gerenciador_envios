package com.gerenciador.envios.repository;

import com.gerenciador.envios.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvioRepository extends JpaRepository<Envio, Long> {

    Optional<Envio> findByCodRastreio(String codRastreio);
}
