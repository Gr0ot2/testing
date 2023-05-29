<%@page import="proyecto.datos_pupilaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
  <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<link href="relampago.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h1>Pellizco</h1>
<form action="pupilaje" method="get">
<input value="pellizco"name="1" type="hidden"/>
<br></br>
<label id="label">fecha nacimiento o compra</label>
<br><br>
<input name="nacimiento" type="date"/>
<br><br>
<label id="label">Ultima vez herrado</label>
<br><br>
<input name="herrado" type="date"/>
<br></br>
<label id="label">Ultima visita veterinario</label>
<br><br>
<input name="veterinario" type="date"/>
<br></br>
<label id="label">Ultima vez desparasitado</label>
<br><br>
<input name="desparasitado" type="date"/>
<br></br>
<label id="label">Ultimo pienso</label>
<br><br>
<input name="pienso" type="date"/>
<br></br>
 <input name="enviar" type="submit"/>
</form>
<div id="resultado">
<%
Object ob= request.getSession().getAttribute("lista");
ArrayList<datos_pupilaje> listas;
if (ob instanceof ArrayList<?>) {
    listas = (ArrayList<datos_pupilaje>) ob;
 %>
  <%for(datos_pupilaje dato:listas)  {%>
  <br></br>
  fecha nacimiento o compra
  <br></br>
   <%= dato.getFecha_nacimiento()%>
   <br></br>
   Ultima vez herrado
   <br></br>
   <%= dato.getFecha_herrado()%>
    <br></br>
   Ultima visita veterinario
   <br></br>
   <%= dato.getFecha_veterinario()%>
     <br></br>
   Ultima vez desparasitado
   <br></br>
   <%= dato.getFecha_desparasitado()%>
    <br></br>
   Ultimo pienso
   <br></br>
   <%= dato.getFecha_pienso()%>
   <%} %>
 <%} %>
 </div>
</body>
</html>