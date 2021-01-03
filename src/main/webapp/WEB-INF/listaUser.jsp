<%@page import="java.util.List"%>
<%@page import="br.com.project.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem do Usuarios </title>
 <script type="text/javascript">
       function confirmarExclusao(id) {
    	   if(window.confirm("Esse dado sera excluido permanentemente. deseja realmente excluir ?")){
    		   location.href="usuController.do?acao=excluir&id="+id;
    	   }
       }
 </script>
</head>
<body>
    <%
      List<Usuario> lista = (List<Usuario>)request.getAttribute("listaUsuarios");
    %>
      <table border=1>
         <tr> <th>id</th> <th>Nome</th> <th>Ação</th> </tr>
      <% for(Usuario listFor : lista){ %>
        <tr>
    	  <td><% out.println(listFor.getId());%></td>
    	  <td><% out.println(listFor.getNome());%></td>
    	  <td> <a href="javascript:confirmarExclusao(<%=listFor.getId()%>)">Excluir</a></td>  	   
     	</tr>
    <%}%>     
   </table>
    
    
</body>
</html>