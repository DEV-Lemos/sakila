package com.github.devlemos.sakila;

import com.github.devlemos.sakila.application.Application;
import com.github.devlemos.sakila.config.Configuracao;

public class Main {

    public static void main(String[] args) {

        try {

            Configuracao configuracao =
                    new Configuracao(".env");

            String url =
                    configuracao.obter("DB_URL");

            String usuario =
                    configuracao.obter("DB_USUARIO");

            String senha =
                    configuracao.obter("DB_SENHA");

            Application application =
                    new Application();

            application.iniciar(
                    url,
                    usuario,
                    senha
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao iniciar aplicação."
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }
}