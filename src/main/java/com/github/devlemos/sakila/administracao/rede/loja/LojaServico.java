package com.github.devlemos.sakila.administracao.rede.loja;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.dominio.enums.Perfil;
import com.github.devlemos.sakila.dominio.modelos.Endereco;
import com.github.devlemos.sakila.dominio.modelos.Funcionario;
import com.github.devlemos.sakila.dominio.modelos.Loja;
import com.github.devlemos.sakila.dominio.repositorios.FuncionarioRepositorio;
import com.github.devlemos.sakila.dominio.repositorios.LojaRepositorio;

public class LojaServico {

    private final LojaRepositorio lojaRepositorio;
    private final FuncionarioRepositorio funcionarioRepositorio;

    public LojaServico(
            LojaRepositorio lojaRepositorio,
            FuncionarioRepositorio funcionarioRepositorio
    ) {
        this.lojaRepositorio = lojaRepositorio;
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    public Loja criar(LojaRequisicaoDTO dados) {

        if (lojaRepositorio.existePorCodigo(dados.getCodigo())) {
            throw new IllegalArgumentException(
                    "Já existe uma loja com este código."
            );
        }

        Funcionario gerente = null;

        if (dados.getGerenteId() != null) {

            gerente = funcionarioRepositorio.buscarPorId(
                    dados.getGerenteId()
            );

            if (gerente == null) {
                throw new IllegalArgumentException(
                        "Gerente informado não existe."
                );
            }

            if (gerente.getPerfil() != Perfil.GERENTE) {
                throw new IllegalArgumentException(
                        "Funcionário informado não possui perfil de gerente."
                );
            }
        }

        Endereco endereco = dados.getEndereco();

        if (endereco != null) {
            endereco.setCidade(dados.getCidade());
            endereco.setCep(dados.getCep());
            endereco.setTelefone(dados.getTelefone());
        }



        Loja loja = new Loja();

        loja.setNome(dados.getNome());
        loja.setCodigo(dados.getCodigo());
        loja.setGerente(gerente);
        loja.setAtiva(dados.getAtiva());
        loja.setEndereco(endereco);

        return lojaRepositorio.cadastrar(loja);
    }
}
