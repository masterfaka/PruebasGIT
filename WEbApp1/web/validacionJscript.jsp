<%-- 
    Document   : validacionJscript
    Created on : 21-ene-2019, 12:18:08
    Author     : Mañanas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		        <link rel="stylesheet" href="stylo.css">
				<script src="js/funciones.js"></script>
        <title>Formulario js</title>
        
<style>
form{width:600px;
	margin :0 auto;
}
</style>
    </head>
    <body>

<div class="w3-card-4">
  <div class="w3-container w3-khaki">
    <h2>Formulario</h2>
  </div>
  <form class="w3-container" action="#">
    <p>      
    <label class="w3-text-brown"><b>Nombre</b></label>
    <input class="w3-input w3-border w3-sand" id="nombre" name="nombre" type="text" required
	onblur="comprobarN(this)"
	></p>
    <p>      
    <label class="w3-text-brown"><b>Apellido</b></label>
    <input class="w3-input w3-border w3-sand" name="apellido" id="apellido"type="text" required
	onblur="comprobarA(this)"></p>
    <p>  
	<label class="w3-text-brown"><b>Email</b></label>
    <input class="w3-input w3-border w3-sand" name="email" id="mail "type="email" required
	onblur="comprobarE(this)"></p>
    <p>   
	<label class="w3-text-brown"><b>DNI</b></label>
    <input class="w3-input w3-border w3-sand" name="dni" id="dni" type="text" required
	onblur="comprobarD(this)"></p>
   
	  <p>   
	<label class="w3-text-brown"><b>edad</b></label>
    <input class="w3-input w3-border w3-sand" name="edad" id="edad" type="number" required
	onblur="comprobarEdad(this)"></p>
    <p>
    <button class="w3-btn w3-brown" id="boton">Register</button></p>
  </form>
</div>

</body>
<script>
//aki va cualkier script y event handler sino no lo lee
//document.getElementById(id).onclick = function(){code}
//document.getElementById("myBtn").onclick = displayDate; no va hasta ke el boton no cargue
document.getElementById("boton").onclick = function(){
console.log("clicaste");
};
document.getElementById("boton").onmouseover = function(){
console.log("estas ON");
};
</script>

</html>
