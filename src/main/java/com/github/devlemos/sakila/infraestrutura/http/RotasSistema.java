package com.github.devlemos.sakila.infraestrutura.http;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RotasSistema {

    public void registrar(
            ServidorHttp servidor
    ) {

        servidor.registrarRota(
                "/status",
                this::status
        );
    }

    private void status(
            HttpExchange exchange
    ) throws IOException {

        String resposta =
                "Sakila ativo.";

        byte[] corpo =
                resposta.getBytes(
                        StandardCharsets.UTF_8
                );

        exchange
                .getResponseHeaders()
                .set(
                        "Content-Type",
                        "text/plain; charset=UTF-8"
                );

        exchange.sendResponseHeaders(
                200,
                corpo.length
        );

        exchange
                .getResponseBody()
                .write(corpo);

        exchange.close();
    }
}