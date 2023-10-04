package com.example.api.models;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private int prodId;

    @Column(name = "PROD_NOME")
    private String prodNome;

    @Column(name = "PROD_PRECO")
    private Double prodPreco;

    public ProdutosModel() {

    }
    public ProdutosModel(String prodNome, Double prodPreco) {
        this.prodNome = prodNome;
        this.prodPreco = prodPreco;
    }

    // Getters e setters

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public Double getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(Double prodPreco) {
        this.prodPreco = prodPreco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "prodId=" + prodId +
                ", prodNome='" + prodNome + '\'' +
                ", prodPreco=" + prodPreco +
                '}';
    }
}