<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clientes.*" %>
<%@page import="clientes.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <div align="center">
            <h1>Lista de Clientes Cadastrados</h1>
            <table border="1">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>Nome</td>
                        <td>E-mail</td>
                        <td>Usuário</td>
                        <td>Senha</td>
                        <td>Editar</td>
                        <td>Excluir</td>
                    </tr>
                </thead>
                <tbody>
                    <% for(Cliente clientes : ClienteDAO.listar()) { %>
                    <tr>
                        <td><%=clientes.id %></td>
                        <td><%= clientes.nome %></td>
                        <td><%= clientes.email %></td>
                        <td><%= clientes.usuario %></td>
                        <td><%= clientes.senha %></td>
                        <td><a href="atualizarEditar.jsp?id=<%=clientes.id %>">Editar</a></td>
                        <td><a href="ExcluirServlet?id=<%= clientes.id%>">Excluir</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>    
        </div>
    </body>
</html>
