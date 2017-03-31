package br.cesjf.lppoExercicio03Web.Dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */

public class VisitanteDAO {

    private Connection conexao = null;
    private Statement operacao = null;
    private ResultSet resultado = null;

    public VisitanteDAO() throws ClassNotFoundException, SQLException {

        conexao = ConexaoBD.getConectar();   // usa o metodo getConectar() da classe ConexaoBD para conectar o banco de dados
        operacao = conexao.createStatement();
    }

    public boolean excluirVisitante(int idVisitante) throws SQLException {

        operacao.executeUpdate("DELETE FROM visitante WHERE id" + idVisitante);
        return true;
    }

    public boolean novoVisitante(Visitante visitante) throws ClassNotFoundException, SQLException {

        String nome = visitante.getNome();
        int idade = visitante.getIdade();
        Timestamp entrada = visitante.getEntrada();
        Timestamp saida = visitante.getSaida();

        try {
            operacao.executeUpdate("INSERT INTO visitante(nome, idade, entrada, saida) VALUES('"
                    + nome + "', " + idade + ", '" + entrada + "', '" + saida + "') ");
            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    public Visitante pesquisarVisitante(int idVisitante) throws ClassNotFoundException, SQLException {

        resultado = operacao.executeQuery("SELECT * FROM visitante WHERE id=" + idVisitante);
        Visitante visitante = new Visitante();
        visitante.setId(resultado.getLong("id"));
        visitante.setNome(resultado.getString("nome"));
        visitante.setIdade(resultado.getInt("idade"));
        visitante.setEntrada(resultado.getTimestamp("entrada"));
        visitante.setSaida(resultado.getTimestamp("saida"));

        return visitante;
    }

    public boolean editarVisitante(int idVisitante) throws ClassNotFoundException, SQLException {

        Visitante visitante = pesquisarVisitante(idVisitante);

        operacao.executeUpdate("UPDATE visitante SET nome= '"
                + visitante.getNome() + "', "
                + visitante.getIdade() + ", '"
                + visitante.getEntrada() + "', '"
                + visitante.getSaida() + "'");

        return true;
    }

    public boolean listarVisitante() throws SQLException, ClassNotFoundException {

        List<Visitante> visitantes = new ArrayList<>();

        resultado = operacao.executeQuery("SELECT *FROM visitante");

        while (resultado.next()) {
            Visitante visitanteAtual = new Visitante();
            visitanteAtual.setId(resultado.getLong("id"));
            visitanteAtual.setNome(resultado.getString("nome"));
            visitanteAtual.setIdade(resultado.getInt("idade"));
            visitanteAtual.setEntrada(resultado.getTimestamp("entrada"));
            visitanteAtual.setSaida(resultado.getTimestamp("saida"));
            visitantes.add(visitanteAtual);
        }

        return true;

    }
}
