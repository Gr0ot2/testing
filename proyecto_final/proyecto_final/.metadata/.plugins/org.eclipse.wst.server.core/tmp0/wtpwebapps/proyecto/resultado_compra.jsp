<%@page import="proyecto.datos_compra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ESTAMOS EN LA PAGINA DE RESULTADOS</h1>
<%
Object obj= request.getSession().getAttribute("lista");
ArrayList<datos_compra> lista;
if (obj instanceof ArrayList<?>) {
    lista = (ArrayList<datos_compra>) obj;
 %>
 <%for(datos_compra dato:lista)  {%>
 id:
 <%= dato.getId() %>
 <br></br>
 producto:
 <%= dato.getProductos() %>
  <br></br>
 cantidad:
 <%= dato.getCantidad() %>
  <br></br>
 precio:
 <%= dato.getPrecio() %>
 <br></br>
 El precio final es de: 
 <%= dato.getPrecio_final() %>
 <%} %>
 <%} %>
</body>
</html>