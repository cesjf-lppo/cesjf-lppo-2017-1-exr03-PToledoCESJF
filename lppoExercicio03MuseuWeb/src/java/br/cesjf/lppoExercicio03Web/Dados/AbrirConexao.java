package br.cesjf.lppoExercicio03Web.Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class AbrirConexao {

    Connection conexao = null;
    Statement operacao = null;
    ResultSet resultado = null;
    String url = "jdbc:derby://localhost:1527/lppoEx03Museu";

    public boolean abrirConexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conexao = DriverManager.getConnection(url, "usuario", "senha");
        operacao = conexao.createStatement();

        return true;
    }

    public ResultSet listarVisitante(String instrucaoSQL) throws SQLException, ClassNotFoundException{
        if(abrirConexao()){
            resultado = operacao.executeQuery(instrucaoSQL);
            return resultado;
        } 
        else{
            return null;
        }
    }
    
    public void novoVisitante(String instrucaoSQL) throws ClassNotFoundException, SQLException{
        if(abrirConexao()){
            operacao.executeUpdate(instrucaoSQL);
        }
    }
    
    public void editarVisitante(String instrucaoBuscaSQL, String instrucaoSalvaSQL) throws ClassNotFoundException, SQLException{
        if(abrirConexao()){
            resultado = operacao.executeQuery(instrucaoBuscaSQL);
            operacao.executeUpdate(instrucaoSalvaSQL);
            
        }
    }
    
    public void excluirVisitante(String instrucaoSQL) throws ClassNotFoundException, SQLException{
        if(abrirConexao()){
            operacao.executeLargeUpdate(instrucaoSQL);
        }
    }
    
}
