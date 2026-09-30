package com.github.devlemos.sakila.infraestrutura.http;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServidorHttp {

    private final HttpServer servidor;
    private final int porta;

    public ServidorHttp(
            int porta
    ) throws IOException {

        this.porta = porta;

        this.servidor =
                HttpServer.create(
                        new InetSocketAddress(porta),
                        0
                );
    }

    public void registrarRota(
            String caminho,
            HttpHandler handler
    ) {

        servidor.createContext(
                caminho,
                handler
        );
    }

    public void iniciar() {

        servidor.start();

        System.out.println(
                "Servidor HTTP iniciado na porta " +
                        porta +
                        "."
        );
    }
}