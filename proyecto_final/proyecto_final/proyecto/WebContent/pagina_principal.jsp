<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="pagina_principal.css">
    <title>centro hipico medina del campo</title>
  </head>
  <body>
   <nav>
        <ul>
          <li>
            <a href="pagina_principal.jsp">Centro hipico medina del campo</a>
          </li>
          <li>
            <a href="pagina_caballos.jsp">caballos</a>
          </li>
          <li>
            <a href="pagina_herramientas.jsp">herramientas</a>
          </li>
          <li>
            <a href="pagina_compra.jsp">compra de articulos (provisional)</a>
          </li>
          <li>
            <a href="pagina_peluqueria.jsp">peluqueria equina</a>
          </li>
        </ul>
      </nav>  
          <h1 id="titulo">
        <strong>CENTRO HIPICO MEDINA DEL CAMPO</strong>
      </h1>
   <!--  foto del login para pupilaje-->   
        <a href="pagina_inicio_formulario.jsp"><img id=log src="img/caballo.jpg"/></a>      
      <!-- fotos del carrusel -->
      <div id="fotos">
        <a href="pagina_caballos.jsp">
          <img class="mySlides" id="foto1" src="img/IMG-20210726-WA0004.jpg">
          <img class="mySlides" id="foto2" src="img/IMG-20210726-WA0005.jpg">
          <img class="mySlides" id="foto3" src="img/IMG-20210821-WA0038.jpg">
          <img class="mySlides" id="foto4" src="img/IMG-20210901-WA0008.jpg">
        </a>
      </div>
      <div id=banner>
      Nos encontramos en la direcci�n:(Url de la direcci�n)
      <br><br>
      Nuestras redes sociales son las siguientes: Instagram (foto instagram)
      <br><br>
      Para poneros en contacto con nosotros escriban al correo: (direcci�n de correo) 
      </div>
    <script type="text/javascript" src="pagina_principal.js"></script>
  </body>
</html>