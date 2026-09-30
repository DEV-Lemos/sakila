package com.github.devlemos.sakila.infraestrutura.persistencia.jdbc;

import com.github.devlemos.sakila.config.BancoDados;
import com.github.devlemos.sakila.dominio.modelos.Loja;
import com.github.devlemos.sakila.dominio.repositorios.LojaRepositorio;

import java.sql.*;
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
                Connection conexao =
                        bancoDados.abrirConexao();

                PreparedStatement comando =
                        conexao.prepareStatement(sql);

                ResultSet resultado =
                        comando.executeQuery();

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
                ativa
            )
            VALUES
            (
                ?,
                ?,
                ?
            )
            """;


        try (
                Connection conexao =
                        bancoDados.abrirConexao();

                PreparedStatement comando =
                        conexao.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        );

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


            comando.executeUpdate();


            ResultSet resultado =
                    comando.getGeneratedKeys();


            if(resultado.next()) {

                loja.setId(
                        resultado.getLong(1)
                );
            }


            return loja;


        } catch (SQLException e) {

            throw new RuntimeException(
                    "Erro ao salvar loja.",
                    e
            );
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
                Connection conexao =
                        bancoDados.abrirConexao();

                PreparedStatement comando =
                        conexao.prepareStatement(sql)
        ) {


            comando.setString(
                    1,
                    codigo
            );


            ResultSet resultado =
                    comando.executeQuery();


            if (resultado.next()) {

                int quantidade =
                        resultado.getInt(1);

                return quantidade > 0;
            }


            return false;


        } catch (SQLException e) {

            throw new RuntimeException(
                    "Erro ao verificar código da loja.",
                    e
            );
        }
    }
}