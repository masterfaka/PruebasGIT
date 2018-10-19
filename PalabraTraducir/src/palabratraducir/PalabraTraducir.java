/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabratraducir;

/**
 *1 insertar (traduccion; las 2 palabras)
 * 2traducir a: ingles-epañol/ español-ingles.
 * 
 */
public class PalabraTraducir {

    /**
     Correccion:
     * 
     * hey un solo metodo para responder con la palabra traducida, 
     * donde hay 2 querys, y dependiendo de la opcionIDIOMAintroducida
     * coje uno u otro.
     * o mejor independientemente  del idioma, en la query se usa un OR
     * where ingles="gato" OR espano="gato"
. IMPORTANTE: siendo gato la pal introducida
* 
     * 
     */
    public static void main(String[] args) {
        String[] Opciones={"1Insertar palabra","2-Traducir","3-Salir"};
        int Opcion= EntradaSalida.mostrarMenu(Opciones);
        while (Opcion!=3) {            
            switch (Opcion) {
                case 1://insertar palabra
                    Palabra p=EntradaSalida.preguntarPalabra();//las2
                    AccesoBdd.insertarPalabra(p);
                    
                    break;
                case 2://traducir: cual
                    String[] OpcionesIdiomas={"1 Ingles-Español","2-Español-Ingles","3-Salir"};
                    int cual=EntradaSalida.mostrarEleccion(OpcionesIdiomas);
                        while (cual!=3) {
                            switch (cual) {
                                case 1://de ingles, mostrar español
                                    String pIngles=EntradaSalida.preguntarIngles();
                                    String pEspanol=AccesoBdd.traducirIngles(pIngles);
                                    EntradaSalida.mostrarP(pEspanol);
                                    
                                    break;
                                case 2:// mostrar pal.ingles
                                    String pEsp=EntradaSalida.preguntarEsp();
                                    String penIngles=AccesoBdd.traducirEspanol(pEsp);
                                    EntradaSalida.mostrarP(penIngles);
                                    
                                    break;
                                default://salir ,errores
                                   break;
                            }
                            cual=EntradaSalida.mostrarEleccion(OpcionesIdiomas);
                        }
                    
                    break;
                
                default://algo mal introducido error etc
                    break;
            }
            Opcion=EntradaSalida.mostrarMenu(Opciones);
        }
    }
    
}
