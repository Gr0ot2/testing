<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="seleccion_esther" method="post">
<label id="label">¿Quieres dar de alta/baja o ver tu caballo?</label>
<br></br>
<input id="radio" type="radio" name="escoja" value="alta">Alta
<input id="radio" type="radio" name="escoja" value="baja">Baja
<input id="radio" type="radio" name="escoja" value="pellizco">Pellizco
<br></br>
 <input name="enviar" type="submit"/>
</form>
</body>
</html>