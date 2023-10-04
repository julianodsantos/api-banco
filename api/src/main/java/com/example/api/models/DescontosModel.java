package com.example.api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "descontos")
public class DescontosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESC_ID")
    private int descId;

    @Column(name = "DESC_DATA_INICIAL")
    private LocalDateTime descDataInicial;

    @Column(name = "DESC_DATA_FINAL")
    private LocalDateTime descDataFinal;

    @Column(name = "DESC_PERCENTUAL")
    private int descPercentual;

    @Column(name = "DESC_DATA_CRIACAO", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime descDataCriacao;

    @Column(name = "DESC_SITUACAO")
    private String descSituacao;

    @ManyToOne
    @JoinColumn(name = "DESC_ID_PROD", referencedColumnName = "PROD_ID", insertable = false, updatable = false)
    private ProdutosModel produto;

    public DescontosModel() {
    }

    public int getDescId() {
        return descId;
    }

    public void setDescId(int descId) {
        this.descId = descId;
    }

    public LocalDateTime getDescDataInicial() {
        return descDataInicial;
    }

    public void setDescDataInicial(LocalDateTime descDataInicial) {
        this.descDataInicial = descDataInicial;
    }

    public LocalDateTime getDescDataFinal() {
        return descDataFinal;
    }

    public void setDescDataFinal(LocalDateTime descDataFinal) {
        this.descDataFinal = descDataFinal;
    }

    public int getDescPercentual() {
        return descPercentual;
    }

    public void setDescPercentual(int descPercentual) {
        this.descPercentual = descPercentual;
    }

    public LocalDateTime getDescDataCriacao() {
        return descDataCriacao;
    }

    public void setDescDataCriacao(LocalDateTime descDataCriacao) {
        this.descDataCriacao = descDataCriacao;
    }

    public String getDescSituacao() {
        return descSituacao;
    }

    public void setDescSituacao(String descSituacao) {
        this.descSituacao = descSituacao;
    }
}
