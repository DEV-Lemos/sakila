package com.github.devlemos.sakila.dominio.enums;

public enum RecursoEspecial {
    TRAILERS("Trailers"),
    COMENTARIOS("Comentarios"),
    CENAS_EXCLUIDAS("Cenas Excluidas"),
    BASTIDORES("Bastidores");

    private final String descricao;

    RecursoEspecial(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static RecursoEspecial fromDescricao(String descricao) {
        for (RecursoEspecial recurso : values()) {
            if (recurso.descricao.equals(descricao)) {
                return recurso;
            }
        }

        throw new IllegalArgumentException("Recurso especial invalido: " + descricao);
    }
}
