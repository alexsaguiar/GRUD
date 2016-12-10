<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clientes.*"%>
<%@page import="clientes.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar e Editar Cliente</title>
    </head>
    <body>
        
            <%
                int id = Integer.valueOf(request.getParameter("id"));
                Cliente cliente = ClienteDAO.buscar(id);
            %>
            
        <div>
            <h1>Atualização do Cliente e edição</h1>

            <form action="AtualizarServlet" method="post">
                <label>id</label>
                <input name="id" value="<%= cliente.id%>">
                <br>
                <label>nome</label>
                <input name="nome" value="<%= cliente.nome%>">
                <br>
                <label>E-mail</label>
                <input name="email" value="<%= cliente.email%>">
                <br>
                <label>Usuário</label>
                <input name="usuario" value="<%= cliente.usuario%>">
                <br>
                <label>Senha</label>
                <input name="senha" value="<%= cliente.senha%>">
                <br>
                <input type="submit" value="Atualizar">
            </form>
        </div>
    </body>
</html>
