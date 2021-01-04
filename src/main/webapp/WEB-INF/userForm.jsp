<%@page import="br.com.project.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Agenda</title>
</head>
<body>
       <%@ include file="menu.jsp"%>
       
       <%
          Usuario usuarioData = (Usuario)request.getAttribute("userAlterar");
       %>
    <form method="post" action="usuController.do">
        
        <label>ID</label>
        <input type="number" placeholder="Digite o id" name="id" value="<%=usuarioData.getId()%>"> <br> <br>
    
        <label>Nome</label>
        <input type="text" placeholder="Digite seu nome" name="nome" value="<%=usuarioData.getNome()%>"> <br> <br>
        
        <label>login</label>
        <input type="text" placeholder="Digite seu login" name="login" value="<%=usuarioData.getLogin()%>"> <br> <br>
        
        <label>Senha</label>
        <input type="password" placeholder="Digite sua senha" name="senha" value="<%=usuarioData.getSenha()%>"/> <br> <br>
               
         <button type="submit">Salvar</button>
    </form>
</body>
</html>