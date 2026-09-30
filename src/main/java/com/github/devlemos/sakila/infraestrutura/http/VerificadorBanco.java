package com.github.devlemos.sakila.infraestrutura.http;

import com.github.devlemos.sakila.config.BancoDados;

import java.sql.Connection;
import java.sql.SQLException;

public class VerificadorBanco {

    private final BancoDados bancoDados;

    public VerificadorBanco(
            BancoDados bancoDados
    ) {
        this.bancoDados = bancoDados;
    }

    public boolean verificar() {

        try (
                Connection conexao =
                        bancoDados.abrirConexao()
        ) {

            return conexao.isValid(2);

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao conectar ao banco."
            );

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }
}