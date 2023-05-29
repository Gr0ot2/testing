<%@page import="proyecto.datos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.ImageIcon"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
Object obj= request.getSession().getAttribute("dat");
ArrayList<datos> dat;
if (obj instanceof ArrayList<?>) {
    dat = (ArrayList<datos>) obj;
 %>
  <%for(datos dato:dat)  {%>
  <%=dato.getNombre() %>
  <br></br>
 	RAZA
   <br></br>
   <% String prueba=dato.getUrl(); %>
   
   <%=prueba %>
   <img src="data:image/jpg;base64,${encodedImage}" alt="Imagen">
   
   <%--<img src="data:img/jpg;base64, ${dato.getUrl()}"/>--%>
   <%} %>
     <br></br>
   <%} %>
</body>
</html>