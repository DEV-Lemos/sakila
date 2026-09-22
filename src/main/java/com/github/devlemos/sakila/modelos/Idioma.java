package com.github.devlemos.sakila.modelos;

public class Idioma {
    private final Long idioma_id;
    private final String nome;


    public Idioma(Long idioma_id, String nome){
        this.idioma_id = idioma_id;
        this.nome = nome;
    }

    public String nome(){
        return this.nome;
    }

    public Long idioma_id(){
        return this.idioma_id;
    }


}
