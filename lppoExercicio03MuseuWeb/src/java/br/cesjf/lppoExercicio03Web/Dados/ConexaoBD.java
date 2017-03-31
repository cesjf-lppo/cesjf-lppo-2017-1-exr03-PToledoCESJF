package br.cesjf.lppoExercicio03Web.Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Paulo
 */
public class ConexaoBD {
       
    public static Connection conexao;
    
    public static Connection getConectar() throws ClassNotFoundException, SQLException{
        
        if(conexao == null){
            String url = "jdbc:derby://localhost:1527/lppoEx03Museu";
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
        }
         
        return conexao;
    }
}
