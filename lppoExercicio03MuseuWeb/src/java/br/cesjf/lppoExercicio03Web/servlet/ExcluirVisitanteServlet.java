package br.cesjf.lppoExercicio03Web.servlet;

import br.cesjf.lppoExercicio03Web.Dados.VisitanteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
@WebServlet(name = "ExcluirVisitanteServlet", urlPatterns = {"/excluir.html"})
public class ExcluirVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long idExcluir = Long.parseLong(request.getParameter("id"));
        
        try{
            
            VisitanteDAO.excluirVisitante(idExcluir);
            
        } catch(Exception e){
               
        }
        
        response.sendRedirect("lista.html");
        
    }

}
