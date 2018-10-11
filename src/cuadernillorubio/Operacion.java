/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

/**
 *
 * @author luis
 */
public class Operacion {

    static Operacion obtenerResta() {
        int n1=obtenerAleatorio();
        int n2=obtenerAleatorio();
        /*while(n2>n1)
        {
            n2=obtenerAleatorio();
        }*/
        //Quiero que n1 sea mayor o igual que n2
        //n1=2
        //n2=5
         if (n1<n2)
         {
             int a=n1;//a=2
             n1=n2;//n1=5
             n2=a;//n2=2
         }
        int resultado=n1-n2;
        char signo='-';
        Operacion o=new Operacion(n1, n2, resultado, signo);
        return o;
    }
    private int operando1, operando2, resultado;
    private char signo;

    public Operacion(int operando1, int operando2, int resultado, char signo) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
        this.signo = signo;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
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
    public static Operacion obtenerSuma()
    {
        int n1=obtenerAleatorio();
        int n2=obtenerAleatorio();
        int resultado=n1+n2;
        char signo='+';
        Operacion o=new Operacion(n1, n2, resultado, signo);
        return o;
    }
    private static int obtenerAleatorio()
    {
        double d=Math.random();
        d=d*9+1;
        int numero=(int)d;
        return numero;
        
    }
}
