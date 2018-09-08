/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danie
 */
@WebServlet(name = "PortalServelet", urlPatterns = {"/PortalServelet"})
public class PortalServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        List<Usuario> lista = new ArrayList<Usuario>();
        lista.add(new Usuario("daniel","danyboy","123"));
        lista.add(new Usuario("thiago","thiago123","123"));
        lista.add(new Usuario("renan","rras","123"));
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> <form method=\"post\" action=\"CadastroUsuarioServelet\"></h1>");
            out.println("<h1><label>Nome:</label></h1>");
            out.println("<h1> <input name=\"nome\" type=\"text\" placeholder=\"Renan Romanio\">  </h1>");
            out.println("<h1><label>Login:</label></h1>");
            out.println("<h1> <input name=\"login\" type=\"text\" placeholder=\"Renan Romanio\"> </h1>");
            out.println("<h1><label>Senha:</label> </h1>");
            out.println("<h1><input name=\"senha\" type=\"password\" placeholder=\"exemplo@exemplo.com\">  </h1>");
            out.println("<h1><button type=\"submit\">Salvar</button></h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.println("<table>");
            out.println("<tr><td>nome</td><td>login</td><td>senha</td></tr>");
            for(Usuario usuario : lista){
                out.println("<tr><td>" + usuario.nome + "</td><td>" + usuario.login + "</td><td>" + usuario.senha + "</td></tr>");
            }
            out.println("</table>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
