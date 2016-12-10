<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clientes.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastro</title>
</head>
<body>
    <div align="center">
        
        <div style="color:red; font-size: 25px;">${erro}</div>
        <div style="color:blue; font-size: 25px;"> ${Sucesso}</div>
        
        <h1>Cadastro de Clientes</h1>
        <form action="SalvarServlet" method="post">
            <!-- id será serial no DB -->
            <label>Nome: </label>
            <input name="nome">
            <br>
            <label>E-mail: </label>
            <input name="email">
            <br>
            <label>Usuário: </label>
            <input name="usuario">
            <br>
            <label>senha: </label>
            <input type="password" name="senha">
            <br>
            <input type="submit" value="Cadastrar">
            <a href="cadastro.jsp">Retornar</a >
            <br>
            <section>
            <a href="listaClientes.jsp">Lista de Clientes </a>
            <br>
            <a href="login.jsp">Login</a>
            </section>
        </form>
    </div>
</body>
</html>
