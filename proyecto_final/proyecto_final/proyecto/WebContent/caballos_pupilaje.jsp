<%@page import="proyecto.datos_pupilaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Object ob= request.getSession().getAttribute("lista");
ArrayList<datos_pupilaje> listas;
if (ob instanceof ArrayList<?>) {
    listas = (ArrayList<datos_pupilaje>) ob;
 %>
  <%for(datos_pupilaje dato:listas)  {%>
  <br></br>
  fecha_nacimiento/compra
  <br></br>
   <%= dato.getFecha_nacimiento()%>
   <br></br>
   fecha_herrado
   <br></br>
   <%= dato.getFecha_herrado()%>
    <br></br>
   fecha_veterinario
   <br></br>
   <%= dato.getFecha_veterinario()%>
     <br></br>
   fecha_desparasitadp
   <br></br>
   <%= dato.getFecha_desparasitado()%>
    <br></br>
   fecha_pienso
   <br></br>
   <%= dato.getFecha_pienso()%>
   <%} %>
 <%} %>
</body>
</html>