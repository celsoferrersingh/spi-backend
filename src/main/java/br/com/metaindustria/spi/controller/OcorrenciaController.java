package br.com.metaindustria.spi.controller;

import br.com.metaindustria.spi.model.Ocorrencia;
import br.com.metaindustria.spi.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    // POST /ocorrencias - Criar nova ocorrência
    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia salva = ocorrenciaService.salvar(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // GET /ocorrencias - Listar todas as ocorrências
    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listarTodas() {
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarTodas();
        return ResponseEntity.ok(ocorrencias);
    }

    // GET /ocorrencias/{id} - Buscar ocorrência por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        return ocorrenciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /ocorrencias/{id} - Atualizar ocorrência existente
    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Long id,
                                                 @RequestBody Ocorrencia dadosAtualizados) {
        return ocorrenciaService.atualizar(id, dadosAtualizados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /ocorrencias/{id} - Remover ocorrência
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (ocorrenciaService.remover(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
