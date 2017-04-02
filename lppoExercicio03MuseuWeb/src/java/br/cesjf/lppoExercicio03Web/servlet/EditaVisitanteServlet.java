package br.cesjf.lppoExercicio03Web.servlet;

import br.cesjf.lppoExercicio03Web.Dados.Visitante;
import br.cesjf.lppoExercicio03Web.Dados.VisitanteDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
@WebServlet(name = "EditaVisitanteServlet", urlPatterns = {"/edita.html"})
public class EditaVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long idEditar = Long.parseLong(request.getParameter("id"));
        Visitante visitanteEditar = new Visitante();

        try {

            visitanteEditar = VisitanteDAO.pesquisarVisitante(idEditar);

        } catch (Exception ex) {
            Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("edtVisitante", visitanteEditar);
        request.getRequestDispatcher("WEB-INF/editaVisitante.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Visitante visitanteEditado = new Visitante();
        
        try {
            
            visitanteEditado.setId(Long.parseLong(request.getParameter("txtId")));
            visitanteEditado.setNome(request.getParameter("txtNome"));
            visitanteEditado.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            visitanteEditado.setEntrada((Timestamp) formataData.parse(request.getParameter("txtEntrada")));
            visitanteEditado.setSaida((Timestamp) formataData.parse(request.getParameter("txtSaida")));
            
            VisitanteDAO.editarVisitante(visitanteEditado);
            
        } catch (Exception ex) {
            Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista.html");
        
    }

}
