//Por ser campos INPUT SE USA ONFOCUS Y ONBLUR!!!! no onchange
/* ESTO NO LO PUEDE HACER PORK EL HTML NO LO A CARGADO
document.getElementById("boton").onclick=function(){
	console.log("clicaste");	
}
document.getElementById("boton").onmouseOn=function(){
	console.log("estas encima!!");	
}
*/
function bordeRojo(elemento){
	elemento.classList.remove('w3-border');
	elemento.classList.add('w3-border-red');
}
function bordeVerde(elemento){
	elemento.classList.remove('w3-border');
		elemento.classList.remove('w3-border-red');
	elemento.classList.add('w3-border-green');
}
//nombre y pellido se comprueba gual por vacion anywas
function comprobarN(el){
	if(el.value===""){//tambien se podria poner con 2 pero no va
		alert("debes poner algo");
		bordeRojo(el);
		return false;
	}
}
function comprobarE(el){//para esto hay una sentencia de formato ke se comprueba con string.test()
    /*
     * 
     * function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
function verificarEmail()
{
	var email=document.getElementById("email");
	var email_ok=validateEmail(email.value);
	if (email_ok==true)
	{
		//fondo verde
		email.className="campoCorrecto";
	}
	else
	{
		//fondo_rojo
		email.className="campoIncorrecto";
	}
}    * 
     * 
     */
	var posA=el.value.indexOf("@");//-1 si no existe
	var posP=el.value.lastIndexOf(".");//buscamos pto por e final si no 
	if(!el.value){//signifuca vacio o null
		alert("debes introducir algo");
		bordeRojo(el);
	}else if(posA==-1 || posP==-1){//no hay pto o arroba
		alert("Introduce  server(.com) o dominio( p ej @gmail)");
		bordeRojo(el);
		//aki se puede anidar para saber exactamente cual
	}else if(posA>posP){//pto antes de arroba
		alert("formato incorrecto; server(.com) va despues del dominio (pej: gmail)");
		bordeRojo(el);
	}else if(posP-posA<=1){//punto y arroba no pueden ir juntos === no hay dominio
		alert("dominio Incorrecto; debe haber algo entre @ y punto (.com)");
		bordeRojo(el);
	}else{//sera correcto sino
		alert("mail correcto");
		bordeVerde(el);
		
	}
	
	
}
function comprobarA(el){
	if(el.value==""){
		alert("debes poner algo");
		bordeRojo(el);
		return false;
	}
}
function comprobarEdad(el){
	//para comprobar null cero o vacion
	// en js se usa ! y el if=>     if(!elemento.value) y comprueba todo simple
	//no compruebo si es un nro pork hatml no t dejaria poner
	if(!el.value){
		alert("debes poner algo");
		bordeRojo(el);
		return false;
	}else if(el.value<=17){
				alert("debes Tener al menos 18!!pipa!");
		bordeRojo(el);
		return false;
	}else{
		bordeVerde(el);
	}
}
function comprobarD(el){
	    var dni= document.getElementById("dni").value;
		//verificamos long
		if(dni.length!=9){
			alert("long incorrecta!");
			return false;//pra ke pare jecucion de funcion con reultado
			bordeRojo(el);
			
		}
		dni=el;
		var numDni=document.getElementById("dni").value.substr(0,8);//(incio, cuantos_chars)
		//despues de comprobar nro digitos comprobomas ke ea unum
		if(isNaN(numDni)){//true sk no es un nro. si es false seguimos
			alert("Debe de ser un NRO!!!");
			bordeRojo(el);
		}
		//comprobamos letra
		//comprobamos letra primero k no ea num logo si es la correcta
		var letra= el.value.charAt(8);//en la pos 8
		if(isNaN(letra)==false){
			//es un nro asi k salimos y alertamos
			alert("No es una letra sikiera!!");
			bordeRojo(el);
		}
		var resto=numDni%23;
		var letras="TRWAGMYFPDXBJÇNJZSQVHLCKE";//esto podria ser array pero como al string se le puede buscar por pos empezando en 0 da =
		var letra_correcta=letras.charAt(resto);
		if(letra!=letra_correcta){
			alert("letra incorrecta");
			return false;
			bordeRojo(el);
		
		}
	   //le echo con returns(false) pero no necesita return true pork nadie escucha esta fucn
	   //aki solo para la ejecucion del programa
	   alert("dni correcto");
	   bordeVerde(el);
}

//////////////////////////////////// Openweathe
function cargarOyentes(){//aki solo se adjuntan los aoyentes(ventos a los elementos)
    document.getElementById("cuidad").onchange=function(){
        pedirT();
      //  mostrarValores();
    };
}
function  pedirT(){
    var sitio= document.getElementById("cuidad").value;
    var url="http://api.openweathermap.org/data/2.5/weather?q="+sitio+"&appid=57703a7a9ab7b873a99116a3ea379748";
    var peticion = new XMLHttpRequest();
    peticion.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {//this es lo ke nos llega.. el estatus
     //document.getElementById("demo").innerHTML = this.responseText;
	 //logueamos todo por consola. this es lo ke nos llega 
	 console.log("readystate:"+this.readyState);
	 console.log("status: "+this.status);
	//parsear
                    mostrarValores(this.responseText);
	/* var obj_json=JSON.parse(this.responseText);
	 var temp= obj_json.main.temp;
	 var max= obj_json.main.temp_max;
	 var min= obj_json.main.temp_min;
	 document.getElementById("temps").innerHTML="max:"+max+", min: "+min;*/
    }
  };
  peticion.open("GET", url, true);
  peticion.send(); 
}
function mostrarValores(res){
    var o_json=JSON.parse(res);
    //se estructura para saber d dnd sacar valores
   // var temp=o_json.main.temp;//esta es la media.. no sirve de momnent
     var max= o_json.main.temp_max;
     var min= o_json.main.temp_min;
     var ciudad=o_json.name;
     var tabla=document.getElementById("tabla");
     var tbody=document.createElement("tbody");//se adjunta todo al body de la tabla sino peta
     var o_fila=document.createElement("tr");
     var o_col= document.createElement("td");
             o_col.innerHTML=ciudad;
     var o_col1= document.createElement("td");
             o_col1.innerHTML=max;
     var o_col2= document.createElement("td");
             o_col2.innerHTML=min;
    //metemos todo en la fila
    o_fila.appendChild(o_col);
    o_fila.appendChild(o_col1);
    o_fila.appendChild(o_col2);
    document.getElementsByTagName("tbody")[0].appendChild(o_fila);//solo hay un td sino se 
    ////inserta uno nuevo cada vez k llamamos a la func
   // tabla.appendChild(tbody);//metemos la fla en la tabla
    
}