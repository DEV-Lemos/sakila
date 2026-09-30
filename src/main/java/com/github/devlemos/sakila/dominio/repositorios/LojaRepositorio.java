package com.github.devlemos.sakila.dominio.repositorios;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.dominio.modelos.Loja;

import java.util.List;

public interface LojaRepositorio {

     List<Loja> listar();
     Loja cadastrar(Loja loja);

    boolean existePorCodigo(String codigo);
}