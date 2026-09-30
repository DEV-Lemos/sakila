package com.github.devlemos.sakila.administracao.rede.loja;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.dominio.modelos.Loja;

public class LojaControlador {
    LojaServico service;
    LojaValidacao validacao;

    public LojaControlador(LojaServico service, LojaValidacao validacao){
        this.service = service;
        this.validacao = validacao;
    }

    public void criar(LojaRequisicaoDTO loja) throws Exception {
        validacao.validar(loja);

        service.criar(loja);

    }

}
