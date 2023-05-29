<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="alta_baja" method="get">
 <input value="alta"name="1" type="hidden"/>
<label id="label">NOMBRE CABALLO</label>
<br><br>
<input name="name" type="text"/>
<br><br>
<label id="label">DESCRIPCIÓN RAZA</label>
<br><br>
<input name="raza" type="text"/>
<br><br>
<label id="label">DESCRIPCIÓN CAPA</label>
<br><br>
<input name="capa" type="text"/>
<br><br>
 <input name="enviar" type="submit"/>
 <input name="reset" type="reset"/> 

</form>
</body>
</html>