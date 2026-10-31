package tarea01;

import java.util.Scanner;

/**
 * Ejercicio 1. Cálculos aritméticos.
 *
 * @author Cabañas Cuevas Aldara María
 */
public class Ejercicio01 {
    
    // Definición del enum
    
    //primero creamos el enum para mostrar al final cada valor dependiendo de la operación
    public enum Operaciones{OPERACION_1, OPERACION_2, OPERACION_3};
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        
        //declaramos las variables que guardarán los números que vamos a pedir al usuario
        //todas las variables serán tipo double, ya que estamos pidiendo números reales
        double valorX, valorY, valorZ;
        
        // Variables de salida
        
        //declaramos las variables que guardarán el resultado de cada operación
        double resultado1, resultado2, resultado3;
        
        // Variables auxiliares
        
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULOS ARITMÉTICOS");
        System.out.println("--------------------");
        
        //primero vamos a imprimir el mensaje para indicar al usuario lo que se le pide
        System.out.println("Introduzca tres números reales:");
        
        //ahora vamos a ir asignando cada número introducido por el usuario a las variables que hemos declarado antes
        //de entrada, para después imprimir su valor
        valorX = teclado.nextDouble();
        //para imprimir el valor de cada variable vamos a concatenar el texto con cada una usando el '+'
        System.out.println("Valor para la X: "+ valorX);
        
        valorY = teclado.nextDouble();
        System.out.println("Valor para la Y: " + valorY);
        
        valorZ = teclado.nextDouble();
        System.out.println("Valor para la Z: " + valorZ);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Primera expresión
        
        //asignamos las operaciones a cada variable de salida
        //en la primera no necesitamos paréntesis ya que las operaciones siguen el orden de precedencia
        resultado1 = valorX / 3 + 8;
        
        // Segunda expresión
        
        //en la segunda operación para el cuadrado del valor de x no vamos a necesitar paréntesis
        //tampoco necesitaremos paréntesis que engloben las dos fracciones, ya que la división se hace antes que la suma
        resultado2 = valorX*valorX / (valorY*valorY) + (valorY*valorY / (valorZ*valorZ)); 
        
        // Tercera expresión
        
        //en la tercera sí vamos a necesitar paréntesis que engloben numerador y denominador por separado
        //dentro del paréntesis del numerador no vamos a necesitar paréntesis adicionales ya que las multiplicaciones
        //se hacen antes que la suma
        //en el denominador sí necesitaremos el paréntesis porque la división se haría antes
        resultado3 = (valorX*valorX + 3*valorX*valorY + valorY*valorY) / (1/(valorX*valorX)); 
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        //vamos a imprimir los resultados de las operaciones concatenando el enum correspondiente 
        //con cada variable de resultado
        System.out.println(Operaciones.OPERACION_1 + ": " + resultado1);
        System.out.println(Operaciones.OPERACION_2 + ": " + resultado2);
        System.out.println(Operaciones.OPERACION_2 + ": " + resultado3);
        
    }
}
