package com.github.devlemos.sakila.administracao.rede.loja;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.infraestrutura.http.ServidorHttp;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LojaRotas {

    private final ServidorHttp servidor;
    private final ObjectMapper objectMapper;
    private final LojaControlador controlador;

    public LojaRotas(
            ServidorHttp servidor,
            LojaControlador controlador
    ) {
        this.servidor = servidor;
        this.controlador = controlador;
        this.objectMapper = new ObjectMapper();
    }

    public void registrar() {

        servidor.registrarRota(
                "/lojas",
                exchange -> {

                    String metodo = exchange.getRequestMethod();

                    if ("GET".equals(metodo)) {
                        get(exchange);
                        return;
                    }

                    if ("POST".equals(metodo)) {
                        post(exchange);
                        return;
                    }

                    responder(
                            exchange,
                            405,
                            "Metodo nao permitido."
                    );
                }
        );
    }

    private void get(HttpExchange exchange) throws IOException {
        responder(
                exchange,
                501,
                "Listagem de lojas ainda nao implementada."
        );
    }

    private void post(HttpExchange exchange) throws IOException {

        LojaRequisicaoDTO requisicao;

        try {
            requisicao = objectMapper.readValue(
                    exchange.getRequestBody(),
                    LojaRequisicaoDTO.class
            );
        } catch (IOException e) {
            responder(
                    exchange,
                    400,
                    "JSON da requisicao invalido."
            );
            return;
        }

        try {
            controlador.criar(requisicao);

            responder(
                    exchange,
                    201,
                    "Loja cadastrada com sucesso."
            );

        } catch (IllegalArgumentException e) {
            responder(
                    exchange,
                    400,
                    e.getMessage()
            );

        } catch (RuntimeException e) {
            responder(
                    exchange,
                    500,
                    "Erro interno ao cadastrar loja."
            );
        }
    }

    private void responder(
            HttpExchange exchange,
            int status,
            String mensagem
    ) throws IOException {

        byte[] resposta = mensagem.getBytes(
                StandardCharsets.UTF_8
        );

        exchange.getResponseHeaders().set(
                "Content-Type",
                "text/plain; charset=UTF-8"
        );

        exchange.sendResponseHeaders(
                status,
                resposta.length
        );

        exchange.getResponseBody().write(resposta);
        exchange.close();
    }
}
