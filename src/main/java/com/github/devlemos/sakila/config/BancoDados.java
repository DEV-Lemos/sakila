package com.github.devlemos.sakila.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    public Connection abrirConexao(
            String url,
            String usuario,
            String senha
    ) throws SQLException {

        return DriverManager.getConnection(
                url,
                usuario,
                senha
        );
    }
}