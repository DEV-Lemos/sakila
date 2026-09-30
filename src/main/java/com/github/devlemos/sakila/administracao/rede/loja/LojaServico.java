package com.github.devlemos.sakila.administracao.rede.loja;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.dominio.modelos.Funcionario;
import com.github.devlemos.sakila.dominio.modelos.Loja;
import com.github.devlemos.sakila.dominio.enums.Perfil;
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


        // =====================================
        // REGRA 1
        // Código da loja não pode duplicar
        // =====================================

        if (lojaRepositorio.existePorCodigo(dados.getCodigo())) {

            throw new IllegalArgumentException(
                    "Já existe uma loja com este código."
            );
        }


        // =====================================
        // REGRA 2
        // Se informou gerente,
        // ele precisa existir
        // =====================================

        Long gerente = null;


        if (dados.getGerente() != null) {


            if (dados.getGerenteId() != null) {

                gerente =
                        funcionarioRepositorio.buscarPorId(
                                dados.getGerenteId()
                        );

                if (gerente == null) {

                    throw new IllegalArgumentException(
                            "Gerente informado não existe."
                    );
                }
            }


            // =====================================
            // REGRA 3
            // Funcionário precisa ser GERENTE
            // =====================================

            if (gerente.getPerfil() != Perfil.GERENTE) {

                throw new IllegalArgumentException(
                        "Funcionário informado não possui perfil de gerente."
                );
            }
        }



        // =====================================
        // NASCE O DOMÍNIO
        // Aqui nasce a Model Loja
        // =====================================

        Loja loja = new Loja();


        loja.setNome(
                dados.getNome()
        );

        loja.setCodigo(
                dados.getCodigo()
        );

        loja.setGerente(
                gerente
        );

        loja.setAtiva(
                dados.getAtiva()
        );

        loja.setEndereco(
                dados.getEndereco()
        );

        loja.setCidade(
                dados.getCidade()
        );

        loja.setCep(
                dados.getCep()
        );

        loja.setTelefone(
                dados.getTelefone()
        );


        // =====================================
        // PERSISTÊNCIA
        // =====================================

        return lojaRepositorio.cadastrar(loja);
    }
}