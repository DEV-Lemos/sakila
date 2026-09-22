package com.github.devlemos.sakila.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Filme {

    private Integer id;

    private String titulo;
    private String descricao;
    private Integer anoLancamento;

    private Idioma idioma;
    private Idioma idiomaOriginal;

    private Integer duracaoAluguel;
    private BigDecimal valorAluguel;
    private Integer duracao;
    private BigDecimal custoReposicao;
    private String classificacao;
    private String recursosEspeciais;

    private List<Categoria> categorias;
    private List<Ator> atores;
    private List<Inventario> inventarios;

    public Filme() {
        this.categorias = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.inventarios = new ArrayList<>();
    }

    public Filme(
            Integer id,
            String titulo,
            String descricao,
            Integer anoLancamento,
            Idioma idioma,
            Idioma idiomaOriginal,
            Integer duracaoAluguel,
            BigDecimal valorAluguel,
            Integer duracao,
            BigDecimal custoReposicao,
            String classificacao,
            String recursosEspeciais,
            List<Categoria> categorias,
            List<Ator> atores,
            List<Inventario> inventarios
    ) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.idioma = idioma;
        this.idiomaOriginal = idiomaOriginal;
        this.duracaoAluguel = duracaoAluguel;
        this.valorAluguel = valorAluguel;
        this.duracao = duracao;
        this.custoReposicao = custoReposicao;
        this.classificacao = classificacao;
        this.recursosEspeciais = recursosEspeciais;
        this.categorias = categorias;
        this.atores = atores;
        this.inventarios = inventarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Idioma getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(Idioma idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public Integer getDuracaoAluguel() {
        return duracaoAluguel;
    }

    public void setDuracaoAluguel(Integer duracaoAluguel) {
        this.duracaoAluguel = duracaoAluguel;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getCustoReposicao() {
        return custoReposicao;
    }

    public void setCustoReposicao(BigDecimal custoReposicao) {
        this.custoReposicao = custoReposicao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getRecursosEspeciais() {
        return recursosEspeciais;
    }

    public void setRecursosEspeciais(String recursosEspeciais) {
        this.recursosEspeciais = recursosEspeciais;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }
}