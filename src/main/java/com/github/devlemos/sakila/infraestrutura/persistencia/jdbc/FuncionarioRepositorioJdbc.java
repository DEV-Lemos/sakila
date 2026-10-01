package com.github.devlemos.sakila.infraestrutura.persistencia.jdbc;

import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.dominio.enums.Perfil;
import com.github.devlemos.sakila.dominio.modelos.Funcionario;
import com.github.devlemos.sakila.dominio.repositorios.FuncionarioRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioRepositorioJdbc implements FuncionarioRepositorio {

    private final BancoDados bancoDados;

    public FuncionarioRepositorioJdbc(BancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }

    @Override
    public Funcionario buscarPorId(Long id) {

        String sql = """
                SELECT
                    id_funcionario,
                    nome,
                    sobrenome,
                    perfil
                FROM funcionario
                WHERE id_funcionario = ?
                """;

        try (
                Connection conexao = bancoDados.abrirConexao();
                PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setLong(1, id);

            try (ResultSet resultado = comando.executeQuery()) {

                if (!resultado.next()) {
                    return null;
                }

                Funcionario funcionario = new Funcionario();

                funcionario.setId(resultado.getLong("id_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setSobrenome(resultado.getString("sobrenome"));
                funcionario.setPerfil(
                        Perfil.valueOf(resultado.getString("perfil"))
                );

                return funcionario;
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao buscar funcionário por ID.",
                    e
            );
        }
    }
}
