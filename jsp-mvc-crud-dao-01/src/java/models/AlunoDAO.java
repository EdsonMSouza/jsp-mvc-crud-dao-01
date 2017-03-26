/**
 * Arquivo: AlunoDAO.java
 *
 */
package models;

import beans.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.ConnectionFactory;

/**
 * Author : Edson Melo de Souza, Me. <prof.edson.melo@gmail.com>
 * Since : 10/03/2016, 15:24:44
 */
public class AlunoDAO {

    // Declaração das variáveis globais
    private Connection conexao = null;
    private String status;

    /**
     * Método construtor da classe
     *
     * @throws SQLException
     */
    public AlunoDAO() throws SQLException {
        // Retorna a conexao no momento da chamada da classe
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    /**
     * Realiza a inclusão de um novo registro no banco de dados
     *
     * @param aluno
     */
    @SuppressWarnings("empty-statement")
    public void inserir(Aluno aluno) {
        try {
            // Declaração da variável para a instrução SQL
            String sql = "insert INTO aluno (ra, nome, curso, disciplina, email) "
                    + "VALUES (?,?,?,?,?)";

            // Atribui os valores ao objeto ps
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                // seta os valores
                ps.setString(1, aluno.getRa());
                ps.setString(2, aluno.getNome());
                ps.setString(3, aluno.getCurso());
                ps.setString(4, aluno.getDisciplina());
                ps.setString(5, aluno.getEmail());

                // Executa o sql (execute)
                ps.execute();

                // Fecha o ps
                ps.close();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna o status da inserção
            status = "Inserido com Sucesso!";

        } catch (SQLException ex) {
            // Lança um erro novo personalizado 
            throw new RuntimeException("Erro ao inserir aluno", ex);
        }
    }

    /**
     * Realiza a atualização de um registro específico
     *
     * @param aluno
     */
    public void atualizar(Aluno aluno) {
        // Não implementado
    }

    /**
     * Realiza a exclusão de um registro específico
     *
     * @param aluno
     */
    public void excluir(Aluno aluno) {
        // Não implementado
    }

    /**
     * Realiza a pesquisa no banco de dados e retorna um ou mais registros
     *
     * @param aluno
     * @return Aluno
     */
    public List<Aluno> pesquisar(Aluno aluno) {
        // Não implementado
        return null;
    }

    /**
     * realiza a listagem de TODOS os registros existentes no banco de dados
     *
     * @return Aluno
     */
    public List<Aluno> listar() {
        // Não implementado
        return null;
    }

    /**
     * Método que retorna o status da operação realizada
     *
     * @return String
     */
    @Override
    public String toString() {
        return status;
    }

}
