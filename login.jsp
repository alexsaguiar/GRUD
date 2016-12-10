<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clientes.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div align="center">
            ${erro}
            ${Sucesso}

            <h1>Login</h1>
            <form action="LoginServlet" method="post">
                <label>Usuário</label>
                <input name="usuario">
                <br>
                <label>Senha</label>
                <input type="password" name="senha">
                <br>
                <input type="submit" value="Entrar">
            </form>
        </div>
    </body>
</html>
