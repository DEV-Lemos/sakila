package com.github.devlemos.sakila.dominio.repositorios;

import com.github.devlemos.sakila.dominio.modelos.Funcionario;

public interface FuncionarioRepositorio {

    Funcionario buscarPorId(Long id);
}
