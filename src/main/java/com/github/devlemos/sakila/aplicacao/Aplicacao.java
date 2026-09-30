package com.github.devlemos.sakila.aplicacao;

import com.github.devlemos.sakila.administracao.rede.loja.LojaRotas;
import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.infraestrutura.http.ServidorHttp;

public class Aplicacao {

    public void iniciar(
            String url,
            String usuario,
            String senha
    ) {

        try {

            BancoDados bancoDados =
                    new BancoDados(
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


            ServidorHttp servidor =
                    new ServidorHttp(
                            8080
                    );


            LojaRotas lojaRotas =
                    new LojaRotas(servidor);

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