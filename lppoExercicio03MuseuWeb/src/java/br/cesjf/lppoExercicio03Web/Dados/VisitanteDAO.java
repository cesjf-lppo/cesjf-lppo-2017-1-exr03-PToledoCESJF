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

    private static Connection conexao = null;
    private static Statement operacao = null;
    private static ResultSet resultado = null;

    public static boolean abrirConexao() throws ClassNotFoundException, SQLException {

        conexao = ConexaoBD.getConectar();   // usa o metodo getConectar() da classe ConexaoBD para conectar o banco de dados
        operacao = conexao.createStatement();

        return true;
    }

    public static void excluirVisitante(Long idVisitante) throws SQLException, ClassNotFoundException {

        if(abrirConexao()){
            
            operacao.executeUpdate("DELETE FROM visitante WHERE id=" + idVisitante);
        }
    }

    public static void novoVisitante(Visitante visitante) throws ClassNotFoundException, SQLException {
        
        if (abrirConexao()) {

            String nome = visitante.getNome();
            int idade = visitante.getIdade();

            operacao.executeUpdate("INSERT INTO visitante(nome, idade) VALUES('"
                    + nome + "', " + idade + ") ");

        }

    }

    public static Visitante pesquisarVisitante(Long idVisitante) throws ClassNotFoundException, SQLException {

        if(abrirConexao()){
            
            resultado = operacao.executeQuery("SELECT * FROM visitante WHERE id=" + idVisitante);
            
            if(resultado.next()){
                
                Visitante visitante = new Visitante();
                visitante.setId(resultado.getLong("id"));
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("saida"));

                return visitante;
            }
        }
        
        return null;
    }

    public static void editarVisitante(Visitante visitante) throws ClassNotFoundException, SQLException {

        if(abrirConexao()){

            operacao.executeUpdate("UPDATE visitante SET nome= '"
                    + visitante.getNome() + "', idade= "
                    + visitante.getIdade() + ", entrada= '"
                    + visitante.getEntrada() + "', saida='"
                    + visitante.getSaida() + "' WHERE id=" + visitante.getId());

        }
    }

    public static List<Visitante> listarVisitante() throws SQLException, ClassNotFoundException {

        List<Visitante> visitantes = new ArrayList<>();

        if (abrirConexao()) {

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

        }
        return visitantes;
    }
    
    public static void saidaVisitante(Long idVisitante) throws ClassNotFoundException, SQLException{
        
        if(abrirConexao()){
            
            operacao.executeUpdate("UPDATE visitante SET saida = CURRENT_TIMESTAMP WHERE id=" + idVisitante);
        }
    }
}
