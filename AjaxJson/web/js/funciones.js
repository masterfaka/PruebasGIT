/////////////////////////////////Buskeda ajax
function cargarOyente(){
    var buskda= document.getElementById("buskeda");
    buskda.onkeyup=function(){
        buscarK(buskda.value);
    };  
}
 function buscarK(txt){
        var url="miServlet?texto="+txt;//ago la peticion a mi servlet
        var peticion = new XMLHttpRequest();
        peticion.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {//this es lo ke nos llega.. el estatus
             console.log("readystate:"+this.responseText);
                    mostrarProv(this.responseText);
        }
      };
      peticion.open("GET", url, true);
      peticion.send();      
  }
  function mostrarProv(json){ //habra ke borrar siempre los anteriores
        var O_json=JSON.parse(json);//ya lo tenemos como array de obj
        var lista = document.getElementById("lista");
        var l_json= O_json.municipios;
        for(i=0; i<l_json.length; i++){
             var obj_li=document.createElement("li");
              var nombre=l_json[i];
              obj_li.innerHTML="<a href='http://www.aemet.es/xml/municipios/localidad.xml' >"+nombre+"</a>";
              lista.appendChild(obj_li);
        }
        
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