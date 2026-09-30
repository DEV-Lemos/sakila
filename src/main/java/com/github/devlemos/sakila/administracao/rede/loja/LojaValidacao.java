package com.github.devlemos.sakila.administracao.rede.loja;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;

import java.util.Locale;

public class LojaValidacao {

    public void validar(LojaRequisicaoDTO loja)  {

        validarNome(loja);

        validarCodigo(loja);

        validarGerente(loja);

        validarAtiva(loja);
    }

    private void validarNome(LojaRequisicaoDTO loja) {

        if (loja.getNome() == null) {
            throw new IllegalArgumentException(
                    "Nome da loja e obrigatorio."
            );
        }

        loja.setNome(
                loja.getNome().strip()
        );

        if (loja.getNome().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nome da loja e obrigatorio."
            );
        }
    }

    private void validarCodigo(LojaRequisicaoDTO loja) {

        if (loja.getCodigo() == null) {
            throw new IllegalArgumentException(
                    "Codigo da loja e obrigatorio."
            );
        }

        loja.setCodigo(
                loja.getCodigo()
                        .strip()
                        .toUpperCase(Locale.ROOT)
        );

        if (loja.getCodigo().isEmpty()) {
            throw new IllegalArgumentException(
                    "Codigo da loja e obrigatorio."
            );
        }
    }

    private void validarGerente(LojaRequisicaoDTO loja) {

        if (loja.getGerenteId() == null) {
            return;
        }

        if (loja.getGerenteId() <= 0) {
            throw new IllegalArgumentException(
                    "Gerente invalido."
            );
        }
    }

    private void validarAtiva(LojaRequisicaoDTO loja) {

        if (loja.getAtiva() == null) {
            throw new IllegalArgumentException(
                    "Situacao da loja e obrigatoria."
            );
        }
    }
}