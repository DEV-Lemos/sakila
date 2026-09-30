package com.github.devlemos.sakila.administracao.rede.loja;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.infraestrutura.http.ServidorHttp;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;


public class LojaRotas {

    private final ServidorHttp servidor;
    private final ObjectMapper  objectMapper;

    public LojaRotas(ServidorHttp servidor) {
        this.servidor = servidor;
        this.objectMapper = new ObjectMapper();
    }

    public void registrar() {

        servidor.registrarRota(
                "/lojas",
                exchange -> {

                    String metodo =
                            exchange.getRequestMethod();

                    if ("GET".equals(metodo)) {
                        get(exchange);
                        return;
                    }

                    if ("POST".equals(metodo)) {
                        post(exchange);
                        return;
                    }
                }
        );
    }

    private void get(HttpExchange exchange) {
    }

    private void post(HttpExchange exchange) throws IOException {
        LojaRequisicaoDTO requisicao = objectMapper.readValue(exchange.getRequestBody(),LojaRequisicaoDTO.class);
    }
}
