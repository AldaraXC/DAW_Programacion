package tarea1;

import java.util.Scanner;

/**
 * Ejercicio 1. Cálculo de expresiones físicas/matemáticas.
 * 
 * @author Aldara Maria Cabañas Cuevas
 */
public class Ejercicio1 {
    
    // Definicion del enum que contiene los nombres de las expresiones a calcular
   
    //creamos el enum para mostrar al final cada valor dependiendo de la operación
    public enum Operaciones{OPERACION, FUERZA_PESO, NUMERO_VUELTAS, AREA_CIRCULO};
    
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
            final float GRAVEDAD= 9.8f;
            double PI;
        // Variables de entrada
            int x, masa, tiempo;
            double radio, frecuencia;
        
        // Variables de salida
            double operacion, fuerzaPeso, vueltasCompletas, areaCirculo;
            
        // Variables auxiliares
            double radioCuadrado;
        
        // Clase Scanner para petición de datos de entrada
            Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        System.out.println("CÁLCULO EXPRESIONES FÍSICAS/MATEMÁTICAS");
        System.out.println("---------------------------------------");
        //pedimos cada dato al usuario y asignamos el valor introducido a la variable correspondiente
        System.out.println("Introduce el valor de X:");
        x = teclado.nextInt();
        System.out.println("Introduce la masa (kg):");
        masa = teclado.nextInt();
        System.out.println("Introduce el tiempo (s):");
        tiempo = teclado.nextInt();
        System.out.println("Introduce la frecuencia (hz):");
        frecuencia = teclado.nextDouble();
        System.out.println("Introduce el radio del círculo (m):");
        radio = teclado.nextDouble();             
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        operacion= (x+x/4.0)/(6.0-x/2.0);
        //en esta operación se da varias veces una conversión impícita de la variable x que pasa de tipo int a double
        
        fuerzaPeso = masa * GRAVEDAD;
        /*en esta operación se da otra conversión implicita de la variable masa que es tipo int a float para poder 
        multiplicarse con GRAVEDAD que es float, además de la conversión implícita de float a double (que es el tipo de la variable fuerzaPeso)
        que se hace sin problemas ya que hay espacio suficiente*/
        
        vueltasCompletas = frecuencia * tiempo;
        //conversión implícita de la variable tiempo de tipo int a double
        
        //establecemos el valor de PI con la aproximación de Leibniz
        PI = 4 *(1.0-1.0/3+1.0/5-1.0/7+1.0/9);
        /*escribimos 1.0 en lugar de 1 en cada operación de la fórmula para que se realice una conversión implícita de int a double y que el resultado sea tipo double.
        Si ponemos todos los números enteros la operación se realizará con enteros y el resultado sera 4 porque se hace el redondeo
        Además hay conversión implícita de los numeros enteros de la fórmula (4, 3, 5, 7 y 9) de tipo int a double*/
        radioCuadrado= radio * radio;
        areaCirculo = PI * radioCuadrado;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        System.out.println();
        System.out.println("RESULTADOS");
        System.out.println("----------");
        System.out.println(Operaciones.OPERACION +": " + operacion);
        System.out.println(Operaciones.FUERZA_PESO +": "+ fuerzaPeso);
        //aquí vamos a usar un castin explícito para que nos de el número de vueltas que se han completado
        System.out.println(Operaciones.NUMERO_VUELTAS +": "+ (int)vueltasCompletas);
        System.out.println(Operaciones.AREA_CIRCULO +": "+ areaCirculo);

        
        
    }
}