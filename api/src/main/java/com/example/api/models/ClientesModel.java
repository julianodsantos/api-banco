package com.example.api.models;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;


@Entity
@Table(name = "clientes")
public class ClientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private int cliId;

    @Column(name = "CLI_NOME")
    private String cliNome;

    @Column(name = "CLI_SOBRENOME")
    private String cliSobrenome;

    @Column(name = "CLI_CPF", unique = true)
    private String cliCpf;

    @Column(name = "CLI_CELULAR")
    private String cliCelular;

    @Column(name = "CLI_TELEFONE")
    private String cliTelefone;

    @Column(name = "CLI_DATA_ATUALIZACAO")
    private Date cliDataAtualizacao;

    public ClientesModel(int cliId, String cliNome, String cliSobrenome, String cliCpf, String cliCelular, String cliTelefone) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliSobrenome = cliSobrenome;
        this.cliCpf = cliCpf;
        this.cliCelular = cliCelular;
        this.cliTelefone = cliTelefone;
    }

    public ClientesModel() {

    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliSobrenome() {
        return cliSobrenome;
    }

    public void setCliSobrenome(String cliSobrenome) {
        this.cliSobrenome = cliSobrenome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public Date getCliDataAtualizacao() {
        return cliDataAtualizacao;
    }

    public void setCliDataAtualizacao(Date cliDataAtualizacao) {
        this.cliDataAtualizacao = cliDataAtualizacao;
    }
}
