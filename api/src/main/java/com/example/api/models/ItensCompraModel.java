package com.example.api.models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ITENS_COMPRA")
public class ItensCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEC_ID")
    private Integer id;

    @Column(name = "ITEC_QNTD", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "ITEC_ID_COMPRA", referencedColumnName = "COM_ID", nullable = false)
    private ComprasModel compra;

    @ManyToOne
    @JoinColumn(name = "ITEC_ID_PRODUTO", referencedColumnName = "PROD_ID", nullable = false)
    private ProdutosModel produto;

    @ManyToOne
    @JoinColumn(name = "ITEC_ID_DESCONTO", referencedColumnName = "DESC_ID")
    private DescontosModel desconto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ComprasModel getCompra() {
        return compra;
    }

    public void setCompra(ComprasModel compra) {
        this.compra = compra;
    }

    public ProdutosModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutosModel produto) {
        this.produto = produto;
    }

    public DescontosModel getDesconto() {
        return desconto;
    }

    public void setDesconto(DescontosModel desconto) {
        this.desconto = desconto;
    }
}
