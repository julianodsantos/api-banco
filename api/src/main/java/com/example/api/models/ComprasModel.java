package com.example.api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class ComprasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COM_ID")
    private int comId;

    @Column(name = "COM_ID_CLIENTE")
    private int comIdCliente;

    @Column(name = "COM_DATA", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime comData;

    @Column(name = "COM_PRECO_TOTAL")
    private Double comPrecoTotal;

    public ComprasModel() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getComIdCliente() {
        return comIdCliente;
    }

    public void setComIdCliente(int comIdCliente) {
        this.comIdCliente = comIdCliente;
    }

    public LocalDateTime getComData() {
        return comData;
    }

    public void setComData(LocalDateTime comData) {
        this.comData = comData;
    }

    public Double getComPrecoTotal() {
        return comPrecoTotal;
    }

    public void setComPrecoTotal(Double comPrecoTotal) {
        this.comPrecoTotal = comPrecoTotal;
    }
}

