package com.github.devlemos.sakila.aplicacao;

import com.github.devlemos.sakila.administracao.rede.loja.LojaControlador;
import com.github.devlemos.sakila.administracao.rede.loja.LojaRotas;
import com.github.devlemos.sakila.administracao.rede.loja.LojaServico;
import com.github.devlemos.sakila.administracao.rede.loja.LojaValidacao;
import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.dominio.repositorios.FuncionarioRepositorio;
import com.github.devlemos.sakila.dominio.repositorios.LojaRepositorio;
import com.github.devlemos.sakila.infraestrutura.http.ServidorHttp;
import com.github.devlemos.sakila.infraestrutura.persistencia.jdbc.FuncionarioRepositorioJdbc;
import com.github.devlemos.sakila.infraestrutura.persistencia.jdbc.LojaRepositorioJdbc;

public class Aplicacao {

    public void iniciar(
            String url,
            String usuario,
            String senha
    ) {

        try {

            BancoDados bancoDados = new BancoDados(
                    url,
                    usuario,
                    senha
            );

            if (!bancoDados.testarConexao()) {
                System.out.println(
                        "Sakila nao foi iniciado."
                );
                return;
            }

            System.out.println(
                    "Conexao com banco: true"
            );

            ServidorHttp servidor = new ServidorHttp(
                    8080
            );

            LojaRepositorio lojaRepositorio =
                    new LojaRepositorioJdbc(bancoDados);

            FuncionarioRepositorio funcionarioRepositorio =
                    new FuncionarioRepositorioJdbc(bancoDados);

            LojaServico lojaServico = new LojaServico(
                    lojaRepositorio,
                    funcionarioRepositorio
            );

            LojaValidacao lojaValidacao =
                    new LojaValidacao();

            LojaControlador lojaControlador =
                    new LojaControlador(
                            lojaServico,
                            lojaValidacao
                    );

            LojaRotas lojaRotas = new LojaRotas(
                    servidor,
                    lojaControlador
            );

            lojaRotas.registrar();
            servidor.iniciar();

            System.out.println(
                    "Sakila iniciado."
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao iniciar Sakila."
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }
}
