<%@page import="br.com.project.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="menu.jsp"%>
 
    <h2>Seja muito bem vinda(a)</h2> <%
       Usuario usuario = (Usuario) request.getSession().getAttribute("userAutenticado"); 
         out.print(usuario.getNome());
     %>
  
</body>
</html>