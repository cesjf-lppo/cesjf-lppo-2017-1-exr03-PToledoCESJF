package br.cesjf.lppoExercicio03Web.servlet;

import br.cesjf.lppoExercicio03Web.Dados.Visitante;
import br.cesjf.lppoExercicio03Web.Dados.VisitanteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "NovoVisitanteServlet", urlPatterns = {"/novo.html"})
public class NovoVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/novoVisitante.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Visitante novoVisitante = new Visitante();
        
        novoVisitante.setNome(request.getParameter("txtNome"));
        novoVisitante.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
        
        try {
            VisitanteDAO.novoVisitante(novoVisitante);
        } catch (Exception ex) {
            Logger.getLogger(NovoVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }

}
