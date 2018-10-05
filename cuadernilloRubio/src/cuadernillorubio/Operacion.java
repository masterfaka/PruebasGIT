/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

/**
 *
 * @author Mañanas
 */
class Operacion{

  

    static Operacion obtenerMulti() {
                    Operacion o= new Operacion();
            //obtener numero aleatorios
            int a=(int)(Math.random()*9+1);
            o.setS1(a);
             a=(int)(Math.random()*9+1);
             o.setS2(a);
             o.setSigno('x');
             int auxResultado=o.getS1()*o.getS2();
             o.setResultado(auxResultado); 
        return o;
        
    }
        private int s1,s2,resultado;
       private char signo;
       static Operacion obtenerSuma() {
            Operacion o= new Operacion();
            //obtener numero aleatorios
            int a=(int)(Math.random()*9+1);
            o.setS1(a);
             a=(int)(Math.random()*9+1);
             o.setS2(a);
             o.setSigno('+');
             int auxResultado=o.getS1()+o.getS2();
             o.setResultado(auxResultado); 
        return o;
    }
        static Operacion obtenerResta(){
             Operacion o= new Operacion();
            //obtener numero aleatorios
            int a=(int)(Math.random()*9+1);
            o.setS1(a);
             a=(int)(Math.random()*9+1);
             o.setS2(a);
             o.setSigno('-');
             int auxResultado=o.getS1()-o.getS2();
             o.setResultado(auxResultado); 
        return o;
        
        }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public char getSigno() {
        return signo;
    }

    public void setSigno(char signo) {
        this.signo = signo;
    }
    
    
    
}
