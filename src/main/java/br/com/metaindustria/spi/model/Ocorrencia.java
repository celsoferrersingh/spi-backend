package br.com.metaindustria.spi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    // Tipo de defeito detectado pela visão computacional
    // Exemplos: TRINCA, CORROSAO, DEFEITO_DIMENSIONAL, CONTAMINACAO, OUTRO
    @Column(nullable = false)
    private String tipoDefeito;

    // Localização na linha de produção (ex: "Linha A - Estação 3")
    @Column(nullable = false)
    private String localizacao;

    // Nível de gravidade de 1 (baixo) a 5 (crítico)
    @Column(nullable = false)
    private Integer gravidadeNivel;

    // Status da ocorrência no fluxo de resolução
    // Valores: ABERTA, EM_ANALISE, RESOLVIDA
    @Column(nullable = false)
    private String status;

    // Data e hora em que a visão computacional detectou a ocorrência
    @Column(nullable = false)
    private LocalDateTime dataHoraDeteccao;

    // Caminho ou referência da imagem que gerou o alerta
    private String imagemReferencia;

    // Observações adicionais do operador
    private String observacoes;

    // ==================== Construtores ====================

    public Ocorrencia() {
    }

    public Ocorrencia(String descricao, String tipoDefeito, String localizacao,
                      Integer gravidadeNivel, String status,
                      LocalDateTime dataHoraDeteccao, String imagemReferencia,
                      String observacoes) {
        this.descricao = descricao;
        this.tipoDefeito = tipoDefeito;
        this.localizacao = localizacao;
        this.gravidadeNivel = gravidadeNivel;
        this.status = status;
        this.dataHoraDeteccao = dataHoraDeteccao;
        this.imagemReferencia = imagemReferencia;
        this.observacoes = observacoes;
    }

    // ==================== Getters e Setters ====================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoDefeito() {
        return tipoDefeito;
    }

    public void setTipoDefeito(String tipoDefeito) {
        this.tipoDefeito = tipoDefeito;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getGravidadeNivel() {
        return gravidadeNivel;
    }

    public void setGravidadeNivel(Integer gravidadeNivel) {
        this.gravidadeNivel = gravidadeNivel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraDeteccao() {
        return dataHoraDeteccao;
    }

    public void setDataHoraDeteccao(LocalDateTime dataHoraDeteccao) {
        this.dataHoraDeteccao = dataHoraDeteccao;
    }

    public String getImagemReferencia() {
        return imagemReferencia;
    }

    public void setImagemReferencia(String imagemReferencia) {
        this.imagemReferencia = imagemReferencia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
