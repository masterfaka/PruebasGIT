function cargarOyentes(){//aki solo se adjuntan los aoyentes(ventos a los elementos)
    document.getElementById("B_peticion").onclick=function(){
        hacerPeticion();
      //  mostrarValores();
    };
}
function hacerPeticion(){
    var url="https://datahub.ckan.io/dataset/05a60bd1-6328-4a82-9fa8-7362859c26ea/resource/3dd2f540-e171-49c9-be98-99d3d3c49d1d/download/polxtica_nacional.json";
     var peticion = new XMLHttpRequest();
    peticion.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     //document.getElementById("demo").innerHTML = this.responseText;

                    console.log("JSON:"+this.responseText);
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
function mostrarValores(txt){
    var json=JSON.parse(txt);
    for (var i = 0; i < json.length; i++) {
        var titulo=json[i].Titulo;
        var pClave=json[i].Palabras_clave;
        var semi=json[i].Semilla;
        console.log("titulo: "+titulo+", semilla: "+semi);
        //mostrar en tabla
     var tabla=document.getElementById("tabla");
     var tbody=document.createElement("tbody");//se adjunta todo al body de la tabla sino peta
     var o_fila=document.createElement("tr");
     var o_col= document.createElement("td");
             o_col.innerHTML=titulo;
     var o_col1= document.createElement("td");
             o_col1.innerHTML=pClave;
     var enlace=document.createElement("a");
     enlace.href=semi;
     var o_col2= document.createElement("td");
             o_col2.innerHTML=semi;
    //metemos todo en la fila
    o_fila.appendChild(o_col);
    o_fila.appendChild(o_col1);
    //o_fila.appendChild(o_col2);
    enlace.appendChild(o_col2);
    o_fila.appendChild(enlace);
    document.getElementsByTagName("tbody")[0].appendChild(o_fila);//solo hay un td sino se 
    ////inserta uno nuevo cada vez k llamamos a la func
   // tabla.appendChild(tbody);//metemos la fla en la tabla
   
    }  
} 