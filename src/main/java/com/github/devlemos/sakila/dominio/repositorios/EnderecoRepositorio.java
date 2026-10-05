package com.github.devlemos.sakila.dominio.repositorios;

import com.github.devlemos.sakila.dominio.modelos.Endereco;

import java.util.List;

public interface EnderecoRepositorio {

    List<Endereco> listar();
    Endereco cadastrar(Endereco endereco);

}
