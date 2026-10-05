package com.github.devlemos.sakila.infraestrutura.persistencia.jdbc;


import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.dominio.modelos.Endereco;
import com.github.devlemos.sakila.dominio.repositorios.EnderecoRepositorio;

import java.util.List;

public class EnderecoRepositorioJdbc implements EnderecoRepositorio {
    private final BancoDados bancoDados;

    public EnderecoRepositorioJdbc(BancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }


    @Override
    public List<Endereco> listar() {
        return List.of();
    }

    @Override
    public Endereco cadastrar(Endereco endereco) {
        return endereco.
    }
}
