package br.com.metaindustria.spi.repository;

import br.com.metaindustria.spi.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    // O JpaRepository já fornece todos os métodos CRUD automaticamente:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.

    // SPRINT 3: consulta derivada usada pelos contadores da tela de lista
    List<Ocorrencia> findByStatusOrderByDataHoraDeteccaoDesc(String status);
}
