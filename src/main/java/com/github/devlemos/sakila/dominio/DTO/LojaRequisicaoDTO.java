package com.github.devlemos.sakila.dominio.DTO;

import com.github.devlemos.sakila.dominio.modelos.Cidade;
import com.github.devlemos.sakila.dominio.modelos.Endereco;

public class LojaRequisicaoDTO {

    private String nome;
    private String codigo;
    private Long gerenteId;
    private Boolean ativa;
    private Endereco endereco;
    private Cidade cidade;
    private String cep;
    private String telefone;

    public LojaRequisicaoDTO() {
    }

    public LojaRequisicaoDTO(
            String nome,
            String codigo,
            Long gerenteId,
            Boolean ativa,
            Endereco endereco,
            Cidade cidade,
            String cep,
            String telefone
    ) {
        this.nome = nome;
        this.codigo = codigo;
        this.gerenteId = gerenteId;
        this.ativa = ativa;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(Long gerenteId) {
        this.gerenteId = gerenteId;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
