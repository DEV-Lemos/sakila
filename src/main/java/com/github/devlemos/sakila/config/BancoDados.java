package com.github.devlemos.sakila.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    private final String url;
    private final String usuario;
    private final String senha;

    public BancoDados(
            String url,
            String usuario,
            String senha
    ) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection abrirConexao() throws SQLException {

        return DriverManager.getConnection(
                url,
                usuario,
                senha
        );
    }

    public boolean testarConexao() {

        try (
                Connection conexao = abrirConexao()
        ) {

            return conexao.isValid(2);

        } catch (SQLException e) {

            System.out.println("Erro ao conectar ao banco.");
            System.out.println(e.getMessage());

            return false;
        }
    }
}