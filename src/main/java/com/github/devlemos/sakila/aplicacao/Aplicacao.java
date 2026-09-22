package com.github.devlemos.sakila.aplicacao;

import com.github.devlemos.sakila.config.BancoDados;

import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacao {

    public void iniciar(
            String url,
            String usuario,
            String senha
    ) {

        BancoDados bancoDados = new BancoDados();

        try (Connection conexao =
                     bancoDados.abrirConexao(
                             url,
                             usuario,
                             senha
                     )) {

            System.out.println("Sakila iniciado.");
            System.out.println(
                    "Conexão com banco: " +
                            conexao.isValid(2)
            );

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao conectar ao banco."
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }
}