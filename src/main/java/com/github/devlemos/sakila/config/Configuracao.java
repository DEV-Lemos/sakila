package com.github.devlemos.sakila.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configuracao {

    private final Map<String, String> valores = new HashMap<>();

    public Configuracao(String arquivo) throws IOException {

        List<String> linhas = Files.readAllLines(Path.of(arquivo));

        for (String linha : linhas) {

            linha = linha.trim();

            if (linha.isEmpty() || linha.startsWith("#")) {
                continue;
            }

            String[] partes = linha.split("=", 2);

            if (partes.length != 2) {
                continue;
            }

            String chave = partes[0].trim();
            String valor = partes[1].trim();

            valores.put(chave, valor);
        }
    }

    public String obter(String chave) {

        String valor = valores.get(chave);

        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuração não encontrada: " + chave
            );
        }

        return valor;
    }
}