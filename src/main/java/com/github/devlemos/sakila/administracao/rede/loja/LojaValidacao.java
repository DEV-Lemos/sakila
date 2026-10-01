package com.github.devlemos.sakila.administracao.rede.loja;

import com.github.devlemos.sakila.dominio.DTO.LojaRequisicaoDTO;
import com.github.devlemos.sakila.dominio.modelos.Endereco;

import java.util.Locale;

public class LojaValidacao {

    public void validar(LojaRequisicaoDTO loja) {

        validarNome(loja);
        validarCodigo(loja);
        validarGerente(loja);
        validarAtiva(loja);
        validarEndereco(loja);
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

    private void validarEndereco(LojaRequisicaoDTO loja) {

        Endereco endereco = loja.getEndereco();

        if (endereco == null) {
            throw new IllegalArgumentException(
                    "Endereco da loja e obrigatorio."
            );
        }

        if (endereco.getLogradouro() == null) {
            throw new IllegalArgumentException(
                    "Logradouro da loja e obrigatorio."
            );
        }

        endereco.setLogradouro(
                endereco.getLogradouro().strip()
        );

        if (endereco.getLogradouro().isEmpty()) {
            throw new IllegalArgumentException(
                    "Logradouro da loja e obrigatorio."
            );
        }

        if (endereco.getBairro() == null) {
            throw new IllegalArgumentException(
                    "Bairro da loja e obrigatorio."
            );
        }

        endereco.setBairro(
                endereco.getBairro().strip()
        );

        if (endereco.getBairro().isEmpty()) {
            throw new IllegalArgumentException(
                    "Bairro da loja e obrigatorio."
            );
        }

        if (endereco.getComplemento() != null) {
            endereco.setComplemento(
                    endereco.getComplemento().strip()
            );
        }

        if (
                loja.getCidade() == null ||
                loja.getCidade().getId() == null ||
                loja.getCidade().getId() <= 0
        ) {
            throw new IllegalArgumentException(
                    "Cidade da loja e obrigatoria."
            );
        }

        if (loja.getCep() != null) {
            loja.setCep(
                    loja.getCep().strip()
            );
        }

        if (loja.getTelefone() == null) {
            throw new IllegalArgumentException(
                    "Telefone da loja e obrigatorio."
            );
        }

        loja.setTelefone(
                loja.getTelefone().strip()
        );

        if (loja.getTelefone().isEmpty()) {
            throw new IllegalArgumentException(
                    "Telefone da loja e obrigatorio."
            );
        }
    }
}
