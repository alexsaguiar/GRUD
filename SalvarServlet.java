package clientes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalvarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalvarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        if (request.getParameter("nome").isEmpty()
                || request.getParameter("email").isEmpty()
                || request.getParameter("usuario").isEmpty()
                || request.getParameter("senha").isEmpty()) {

            request.setAttribute("erro", "Preencha todos os campos corretamente.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);

        } else {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            ClienteDAO.salvar(nome, email, usuario, senha);

            request.setAttribute("Sucesso", "Cadastro realizado com sucesso.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
