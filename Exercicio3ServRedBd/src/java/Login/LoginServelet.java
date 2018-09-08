/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import br.com.ib.teste.Teste;
import br.com.ib.dao.PessoaDAO;
import br.com.ib.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author daniel
 */
@WebServlet(name = "LoginServelet", urlPatterns = {"/LoginServelet"})
public class LoginServelet extends HttpServlet {

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
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        response.setContentType("text/html;charset=UTF-8");

        PessoaDAO pDao = new PessoaDAO();
        
        Pessoa pUser = new Pessoa();
        pUser.setLogin(login);
        pUser.setSenha(senha);
        
        pDao.buscarPessoa();

        String nomee = retorno.getNome();
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        if (nomee == null || nomee.isEmpty()) {//               
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
            request.setAttribute("msg", "Erro acessando a Servlet");
            request.setAttribute("page", "index.html");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("nomee", nomee);
            out.println("<h1> O Usuário está logado com sucesso</h1>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalServlet");
            rd.forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (login.equals(senha)) {
                String teste = Teste.main();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Sucesso</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuário Logado com sucesso</h1>");
                out.println("<a href='PortalServelet'>PortalServelet</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Sucesso</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuário ou Senha não encntrados</h1>");
                out.println("<a href='index.html'>Index</a>");
                out.println("</body>");
                out.println("</html>");
            }
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
