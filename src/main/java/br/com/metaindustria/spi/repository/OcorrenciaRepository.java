package br.com.metaindustria.spi.repository;

import br.com.metaindustria.spi.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    // O JpaRepository já fornece todos os métodos CRUD automaticamente:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.
}
