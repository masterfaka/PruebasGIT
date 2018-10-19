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
     * Correccion:
     *
     * hey un solo metodo para responder con la palabra traducida, donde hay 2
     * querys, y dependiendo de la opcionIDIOMAintroducida coje uno u otro.
     * (VER.2) o mejor independientemente del idioma, en la query se usa un OR
     * where ingles="gato" OR espano="gato" . IMPORTANTE: siendo gato la pal
     * introducida
     *ver3
     * si la palabra metida Equals  palabra ingles else es español
     * la palabra buscada es la ke se pasa a null
     * if palabrabuscada.equals(palabra ingles)
     * 
     * {
     * palabraingles=null;
     * 
     * }else{
     *  palabra espnol=null;
     * 
     * }
     *palabra p= new palabra(palabraIngles, palabra espanol);
     * al mostrar palabra una estara a null, usando esa condicion, al mostrar confirmamos en ke idioma
     * se ha metido
     */
    public static void main(String[] args) {
        String[] Opciones = {"1Insertar palabra", "2-Traducir", "3-Salir"};
        int Opcion = EntradaSalida.mostrarMenu(Opciones);
        while (Opcion != 3) {
            switch (Opcion) {
                case 1://insertar palabra
                    Palabra p = EntradaSalida.preguntarPalabra();//las2
                    AccesoBdd.insertarPalabra(p);

                    break;
                case 2://traducir: cual
                    String[] OpcionesIdiomas = {"1 Ingles-Español", "2-Español-Ingles", "3-Salir"};
                    int cual = EntradaSalida.mostrarEleccion(OpcionesIdiomas);
                    while (cual != 3) {
                        switch (cual) {
                            case 1://de ingles, mostrar español
                                String pIngles = EntradaSalida.preguntarIngles();
                                String pEspanol = AccesoBdd.traducirIngles(pIngles);
                                EntradaSalida.mostrarP(pEspanol);

                                break;
                            case 2:// mostrar pal.ingles
                                String pEsp = EntradaSalida.preguntarEsp();
                                String penIngles = AccesoBdd.traducirEspanol(pEsp);
                                EntradaSalida.mostrarP(penIngles);

                                break;
                            default://salir ,errores
                                break;
                        }
                        cual = EntradaSalida.mostrarEleccion(OpcionesIdiomas);
                    }

                    break;

                default://algo mal introducido error etc
                    break;
            }
            Opcion = EntradaSalida.mostrarMenu(Opciones);
        }
    }

}
