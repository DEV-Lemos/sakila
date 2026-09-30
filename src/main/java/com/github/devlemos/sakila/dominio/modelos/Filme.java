package com.github.devlemos.sakila.dominio.modelos;

import com.github.devlemos.sakila.dominio.enums.ClassificacaoFilme;
import com.github.devlemos.sakila.dominio.enums.RecursoEspecial;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Filme {

    private Long id;
    private String titulo;
    private String descricao;
    private Year anoLancamento;
    private Idioma idioma;
    private Idioma idiomaOriginal;
    private Integer duracaoAluguelDias;
    private BigDecimal valorAluguel;
    private Integer duracaoMinutos;
    private BigDecimal custoReposicao;
    private ClassificacaoFilme classificacao;
    private Set<RecursoEspecial> recursosEspeciais = new LinkedHashSet<>();
    private List<Categoria> categorias = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Year getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Year anoLancamento) {
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

    public Integer getDuracaoAluguelDias() {
        return duracaoAluguelDias;
    }

    public void setDuracaoAluguelDias(Integer duracaoAluguelDias) {
        this.duracaoAluguelDias = duracaoAluguelDias;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public BigDecimal getCustoReposicao() {
        return custoReposicao;
    }

    public void setCustoReposicao(BigDecimal custoReposicao) {
        this.custoReposicao = custoReposicao;
    }

    public ClassificacaoFilme getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoFilme classificacao) {
        this.classificacao = classificacao;
    }

    public Set<RecursoEspecial> getRecursosEspeciais() {
        return recursosEspeciais;
    }

    public void setRecursosEspeciais(Set<RecursoEspecial> recursosEspeciais) {
        this.recursosEspeciais = recursosEspeciais != null
                ? recursosEspeciais
                : new LinkedHashSet<>();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias != null
                ? categorias
                : new ArrayList<>();
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores != null
                ? atores
                : new ArrayList<>();
    }
}
