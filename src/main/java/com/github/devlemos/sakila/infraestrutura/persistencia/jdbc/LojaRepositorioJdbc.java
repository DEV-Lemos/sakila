package com.github.devlemos.sakila.infraestrutura.persistencia.jdbc;

import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.dominio.modelos.Endereco;
import com.github.devlemos.sakila.dominio.modelos.Loja;
import com.github.devlemos.sakila.dominio.repositorios.LojaRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LojaRepositorioJdbc implements LojaRepositorio {

    private final BancoDados bancoDados;

    public LojaRepositorioJdbc(
            BancoDados bancoDados
    ) {
        this.bancoDados = bancoDados;
    }

    @Override
    public List<Loja> listar() {

        List<Loja> lojas = new ArrayList<>();

        String sql = """
                SELECT
                    id_loja,
                    nome,
                    codigo,
                    ativa
                FROM loja
                """;

        try (
                Connection conexao = bancoDados.abrirConexao();
                PreparedStatement comando = conexao.prepareStatement(sql);
                ResultSet resultado = comando.executeQuery()
        ) {

            while (resultado.next()) {

                Loja loja = new Loja();

                loja.setId(
                        resultado.getLong("id_loja")
                );

                loja.setNome(
                        resultado.getString("nome")
                );

                loja.setCodigo(
                        resultado.getString("codigo")
                );

                loja.setAtiva(
                        resultado.getBoolean("ativa")
                );

                lojas.add(loja);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao buscar lojas.",
                    e
            );
        }

        return lojas;
    }

    @Override
    public Loja cadastrar(Loja loja) {

        String sql = """
                INSERT INTO loja
                (
                    nome,
                    codigo,
                    ativa,
                    id_gerente,
                    id_endereco
                )
                VALUES
                (
                    ?,
                    ?,
                    ?,
                    ?,
                    ?
                )
                """;

        try (Connection conexao = bancoDados.abrirConexao()) {

            conexao.setAutoCommit(false);

            try {

                Long enderecoId = cadastrarEndereco(
                        conexao,
                        loja.getEndereco()
                );

                try (
                        PreparedStatement comando = conexao.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
                ) {

                    comando.setString(
                            1,
                            loja.getNome()
                    );

                    comando.setString(
                            2,
                            loja.getCodigo()
                    );

                    comando.setBoolean(
                            3,
                            loja.isAtiva()
                    );

                    if (loja.getGerente() == null) {
                        comando.setNull(
                                4,
                                Types.TINYINT
                        );
                    } else {
                        comando.setLong(
                                4,
                                loja.getGerente().getId()
                        );
                    }

                    comando.setLong(
                            5,
                            enderecoId
                    );

                    comando.executeUpdate();

                    try (
                            ResultSet resultado =
                                    comando.getGeneratedKeys()
                    ) {

                        if (resultado.next()) {
                            loja.setId(
                                    resultado.getLong(1)
                            );
                        }
                    }
                }

                conexao.commit();

                return loja;

            } catch (SQLException e) {

                conexao.rollback();

                throw new RuntimeException(
                        "Erro ao salvar loja.",
                        e
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao abrir conexao para salvar loja.",
                    e
            );
        }
    }

    private Long cadastrarEndereco(
            Connection conexao,
            Endereco endereco
    ) throws SQLException {

        String sql = """
                INSERT INTO endereco
                (
                    logradouro,
                    complemento,
                    bairro,
                    id_cidade,
                    cep,
                    telefone
                )
                VALUES
                (
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?
                )
                """;

        try (
                PreparedStatement comando = conexao.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {

            comando.setString(
                    1,
                    endereco.getLogradouro()
            );

            comando.setString(
                    2,
                    endereco.getComplemento()
            );

            comando.setString(
                    3,
                    endereco.getBairro()
            );

            comando.setLong(
                    4,
                    endereco.getCidade().getId()
            );

            if (endereco.getCep() == null) {
                comando.setNull(
                        5,
                        Types.VARCHAR
                );
            } else {
                comando.setString(
                        5,
                        endereco.getCep()
                );
            }

            comando.setString(
                    6,
                    endereco.getTelefone()
            );

            comando.executeUpdate();

            try (
                    ResultSet resultado =
                            comando.getGeneratedKeys()
            ) {

                if (!resultado.next()) {
                    throw new SQLException(
                            "Banco nao retornou o ID do endereco cadastrado."
                    );
                }

                Long id = resultado.getLong(1);
                endereco.setId(id);

                return id;
            }
        }
    }

    @Override
    public boolean existePorCodigo(String codigo) {

        String sql = """
                SELECT COUNT(*)
                FROM loja
                WHERE codigo = ?
                """;

        try (
                Connection conexao = bancoDados.abrirConexao();
                PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setString(
                    1,
                    codigo
            );

            try (
                    ResultSet resultado =
                            comando.executeQuery()
            ) {

                if (resultado.next()) {

                    int quantidade =
                            resultado.getInt(1);

                    return quantidade > 0;
                }

                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao verificar codigo da loja.",
                    e
            );
        }
    }
}
