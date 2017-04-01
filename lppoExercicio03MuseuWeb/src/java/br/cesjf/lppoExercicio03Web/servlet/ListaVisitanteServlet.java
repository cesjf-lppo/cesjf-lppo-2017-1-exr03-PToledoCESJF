package br.cesjf.lppoExercicio03Web.servlet;

import br.cesjf.lppoExercicio03Web.Dados.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaVisitanteServlet", urlPatterns = {"/lista.html"})
public class ListaVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Visitante> lstVisitantes = new ArrayList<>();
        
        try {
            
            lstVisitantes = VisitanteDAO.listarVisitante();
            
        } catch (Exception ex) {
            Logger.getLogger(ListaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("lstVisitantes", lstVisitantes);
        request.getRequestDispatcher("WEB-INF/listaVisitantes.jsp").forward(request, response);
             
    }

}
