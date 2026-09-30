package com.github.devlemos.sakila.dominio.enums;

public enum ClassificacaoFilme {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private final String codigo;

    ClassificacaoFilme(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static ClassificacaoFilme fromCodigo(String codigo) {
        for (ClassificacaoFilme classificacao : values()) {
            if (classificacao.codigo.equals(codigo)) {
                return classificacao;
            }
        }

        throw new IllegalArgumentException("Classificacao de filme invalida: " + codigo);
    }
}
