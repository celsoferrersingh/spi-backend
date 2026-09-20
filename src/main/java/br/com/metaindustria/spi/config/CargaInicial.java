package br.com.metaindustria.spi.config;

import br.com.metaindustria.spi.model.Ocorrencia;
import br.com.metaindustria.spi.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * SPRINT 3 - Carga inicial.
 *
 * Insere no banco as mesmas quatro ocorrencias que ficavam no mockData.ts
 * do app na Sprint 2. Agora elas nascem no backend: o app so as ve porque
 * fez GET /ocorrencias.
 *
 * Como o H2 e em arquivo, isso so roda quando a tabela esta vazia.
 */
@Component
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Override
    public void run(String... args) {
        if (ocorrenciaRepository.count() > 0) {
            return;
        }

        ocorrenciaRepository.save(new Ocorrencia(
                "Trinca superficial detectada na peca #4471",
                "TRINCA",
                "Linha A - Estacao 3",
                4,
                "ABERTA",
                LocalDateTime.now().minusHours(3),
                "imagens/captura_4471.jpg",
                "Detectado pelo sensor de camera S-03"));

        ocorrenciaRepository.save(new Ocorrencia(
                "Corrosao na tubulacao principal da linha B",
                "CORROSAO",
                "Linha B - Estacao 1",
                3,
                "EM_ANALISE",
                LocalDateTime.now().minusDays(1),
                null,
                "Area afetada de aproximadamente 15cm2"));

        ocorrenciaRepository.save(new Ocorrencia(
                "Defeito dimensional na peca #3892 fora do toleravel",
                "DEFEITO_DIMENSIONAL",
                "Linha C - Estacao 2",
                2,
                "RESOLVIDA",
                LocalDateTime.now().minusDays(2),
                null,
                "Peca descartada e processo ajustado"));

        ocorrenciaRepository.save(new Ocorrencia(
                "Contaminacao detectada no setor de embalagem",
                "CONTAMINACAO",
                "Linha D - Estacao 5",
                5,
                "ABERTA",
                LocalDateTime.now().minusHours(1),
                null,
                "Linha interrompida para inspecao imediata"));
    }
}
