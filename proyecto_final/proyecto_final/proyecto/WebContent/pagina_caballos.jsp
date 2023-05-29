<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="pagina_caballos.css">
    <title>centro hipico medina del campo</title>
    <script  type="text/javascript"  src="1.js"></script>
  </head>
  <body>
      <!--  barra de navegación-->
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
        <a href="pagina_inicio_formulario.jsp">
        <img id=log src="img/caballo.jpg"/>
      </a>
      <div id="photos">
      <!-- fotos de todos los caballos-->
      <div id="photo_marijuli">
      <form action="caballos_clase" method="get">
      <input value="Marijuli"name="1" type="hidden"/>
      <h2 id="marijuli" >MARRIJULI </h2>
      <button type="submit">
      <img id="photo1" src="img/IMG-20210726-WA0004.jpg"/>
      </button>
	 <!--  <input name="enviar" type="submit"/>-->
      </form>
      </div>      
      <div id="photo_chicuelo">
       <form action="caballos_clase" method="get">
      <input value="Chiquelo"name="1" type="hidden"/>
      <h2  id="chicuelo" >CHICUELO</h2>
      <img id="photo2" src="img/IMG-20210726-WA0005.jpg"/>
       <input name="enviar" type="submit"/>
      </form>
      </div>  
      <div id="photo_leticia">
       <form action="caballos_clase" method="get">
      <input value="Leticia"name="1" type="hidden"/>
      <h2 id="leticia">LETICIA</h2>
      <img id="photo3" src="img/IMG-20210821-WA0038.jpg"/>
	  <input name="enviar" type="submit"/>
	  </form> 	
      </div>  
      <div id="photo_pia">
       <form action="caballos_clase" method="get">
      <input value="Pia"name="1" type="hidden"/>
      <h2 id="pia">PIA</h2>
      <img id="photo4" src="img/IMG-20210726-WA0004.jpg"/>
	  <input name="enviar" type="submit"/>
      </form>
      </div> 
       <div id="photo_valentina">
        <form action="caballos_clase" method="get">
      <input value="Valentina"name="1" type="hidden"/>
      <h2 id="valentina">VALENTINA</h2>
      <img id="photo5" src="img/IMG-20210901-WA0008.jpg"/>
      <input name="enviar" type="submit"/>
	  </form> 
      </div> 
      <div id="photo_fermin">
       <form action="caballos_clase" method="get">
      <input value="Fermin"name="1" type="hidden"/>
      <h2 id="fermin">FERMIN</h2>
      <img id="photo6" src="img/IMG-20210726-WA0004.jpg"/>
	  <input name="enviar" type="submit"/>
	  </form>
      </div>
      <div id="photo_tierra">
       <form action="caballos_clase" method="get">
      <input value="Tierra"name="1" type="hidden"/>
      <h2 id="tierra">TIERRA</h2>
      <img id="photo7" src="img/IMG-20210726-WA0005.jpg"/>
	  <input name="enviar" type="submit"/>
	  </form>
      </div>
      <div id="photo_africa">
       <form action="caballos_clase" method="get">
      <input value="Africa"name="1" type="hidden"/>
      <h2 id="africa">AFRICA</h2>
      <img id="photo8" src="img/IMG-20210821-WA0038.jpg"/>
      <input name="enviar" type="submit"/>
	  </form>
      </div>
      <div id="photo_bombon">
      <form action="caballos_clase" method="get">
      <input value="Bombon"name="1" type="hidden"/>
      <h2 id="bombon">BOMBON</h2>
      <img id="photo9" src="img/IMG-20210726-WA0004.jpg"/>
      <input name="enviar" type="submit"/>
      </form>
      </div>
       <div id="photo_armonia">
        <form action="caballos_clase" method="get">
      <input value="Armonia"name="1" type="hidden"/>
      <h2 id="armonia">ARMONIA</h2>
      <img id="photo10" src="img/IMG-20210726-WA0004.jpg"/>
      <input name="enviar" type="submit"/>
      </form>
      </div>
       <div id="photo_gucci">
        <form action="caballos_clase" method="get">
      <input value="Gucci"name="1" type="hidden"/>
      <h2 id="gucci">GUCCI</h2>
      <img id="photo11" src="img/IMG-20210821-WA0038.jpg"/>
      <input name="enviar" type="submit"/>
      </form>
      </div>
      </div>
  </body>
</html>