package br.com.metaindustria.spi.service;

import br.com.metaindustria.spi.model.Ocorrencia;
import br.com.metaindustria.spi.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    // Criar nova ocorrência
    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    // Listar todas as ocorrências
    public List<Ocorrencia> listarTodas() {
        return ocorrenciaRepository.findAll();
    }

    // Buscar ocorrência por ID
    public Optional<Ocorrencia> buscarPorId(Long id) {
        return ocorrenciaRepository.findById(id);
    }

    // Atualizar uma ocorrência existente
    public Optional<Ocorrencia> atualizar(Long id, Ocorrencia dadosAtualizados) {
        return ocorrenciaRepository.findById(id).map(ocorrenciaExistente -> {
            ocorrenciaExistente.setDescricao(dadosAtualizados.getDescricao());
            ocorrenciaExistente.setTipoDefeito(dadosAtualizados.getTipoDefeito());
            ocorrenciaExistente.setLocalizacao(dadosAtualizados.getLocalizacao());
            ocorrenciaExistente.setGravidadeNivel(dadosAtualizados.getGravidadeNivel());
            ocorrenciaExistente.setStatus(dadosAtualizados.getStatus());
            ocorrenciaExistente.setDataHoraDeteccao(dadosAtualizados.getDataHoraDeteccao());
            ocorrenciaExistente.setImagemReferencia(dadosAtualizados.getImagemReferencia());
            ocorrenciaExistente.setObservacoes(dadosAtualizados.getObservacoes());
            return ocorrenciaRepository.save(ocorrenciaExistente);
        });
    }

    // Remover ocorrência por ID
    public boolean remover(Long id) {
        if (ocorrenciaRepository.existsById(id)) {
            ocorrenciaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
