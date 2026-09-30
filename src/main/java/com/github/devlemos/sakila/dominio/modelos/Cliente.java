package com.github.devlemos.sakila.dominio.modelos;

import java.time.LocalDateTime;

public class Cliente {

    private Long id;
    private Loja lojaOrigem;
    private String nome;
    private String sobrenome;
    private String email;
    private Endereco endereco;
    private boolean ativo;
    private LocalDateTime cadastradoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja getLojaOrigem() {
        return lojaOrigem;
    }

    public void setLojaOrigem(Loja lojaOrigem) {
        this.lojaOrigem = lojaOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public void setCadastradoEm(LocalDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
    }
}
