<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="pagina_inicio_formulario.css" type="text/css" rel="stylesheet">
<title></title>
</head>
<body>
<form action="inicio_formulario" method="post" id="cuestionario">
<label id="label">¿Tiene caballo de pupilaje?</label><br>
<input id="radio" type="radio" name="escoja" value="Si">Si
<input id="radio" type="radio" name="escoja" value="No">No<br>
<input name="enviar" type="submit"/>
</form>
</body>
</html>