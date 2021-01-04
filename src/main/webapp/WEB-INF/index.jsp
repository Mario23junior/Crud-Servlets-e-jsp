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
    <h2>Seja muito bem vinda(a) <%
       Usuario usuario = (Usuario) request.getSession().getAttribute("userAutenticado"); 
         out.print(usuario.getNome());
     %> </h2>
  
</body>
</html>