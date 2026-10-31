/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package tarea01;


import java.util.Scanner;
/**
 *
 * @author Cabanas_Cuevas_Aldara_Maria
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    /*
 * ENUNCIADO
 *  Realiza un programa en Java que permita introducir por teclado tres palabras. 
 *  Una vez introducidas las palabras, se realizarán las comprobaciones necesarias para determinar:
 *      1. Si las dos primeras palabras introducidas tienen menos de 6 caracteres o la tercera palabra tiene más de 8 caracteres.
 *      2. Si la segunda palabra es la de mayor longitud de las tres.
 *      3. Si las tres palabras están encadenadas (la última letra de una palabra es igual a la primera letra de la palabra siguiente) o no.
 *      4. Si se trata de palabras circulares (palabras encadenadas en la que la última letra de la última palabra también coincide 
 *          con la primera letra de la primera palabra) o no.
 */


        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        
        String palabra1, palabra2, palabra3;    //primero declaramos las variables de las palabras 
                                                //que el usuario debe introducir por teclado
        
        // Variables de salida

        //aquí declaramos las variables del resultado de las condiciones que se mostrarán por consola  
       String resultado1, resultado2, resultado3, resultado4;

        // Variables auxiliares

         //ahora declaramos las variables de las cuatro condiciones que pide el ejercicio
        boolean condicion1, condicion2, condicion3, condicion4;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 3. Palabras circulares ");
        System.out.println("--------------------------------");
        System.out.println(" ");
        
        //ahora mostramos el mensaje de la información que vamos a pedir por consola 
        //para que el usuario la introduzca por teclado
        System.out.println("Por favor, introduce la primera palabra:");
                palabra1 = teclado.nextLine();
        System.out.println("Por favor, introduce la segunda palabra:");
                palabra2 = teclado.nextLine();
         System.out.println("Por favor, introduce la tercera palabra:");
                palabra3 = teclado.nextLine();                

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //aquí vamos a establecer las condiciones que pide el ejercicio con operadores lógicos
        //y luego comprobaremos si se cumplen o no con el operador ternario
        
        /*en esta primera condición vamos a comprobar primero si la palabra3 tiene más de 8 caracteres
        ya que será más rápido que comprobar si las dos primeras tienen más de 6 caracteres
        */
        condicion1= palabra3.length()>8 || (palabra1.length()<6 && palabra2.length()<6);
        resultado1= condicion1?  "SI"    : "NO" ; 
        
        condicion2= palabra2.length() > palabra1.length() && palabra2.length() > palabra3.length();
        resultado2= condicion2? "SI"    :   "NO"    ;
        
        /*para la 3 condición vamos a pasar las 3 palabras a minúsculas, ya que si no lo hacemos y algunos caracteres
        están escritos en mayúscula y otros en minúscula el programa no los considerará iguales*/
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();
        palabra3 = palabra3.toLowerCase();
        condicion3= palabra1.charAt(palabra1.length()-1) == palabra2.charAt(0) && 
                    palabra2.charAt(palabra2.length()-1) == palabra3.charAt(0);
        resultado3= condicion3? "SI"    :   "NO"    ;
        
        condicion4= palabra1.charAt(palabra1.length()-1) == palabra2.charAt(0) && 
                    palabra2.charAt(palabra2.length()-1) == palabra3.charAt(0) &&
                    palabra3.charAt(palabra3.length()-1) == palabra1.charAt(0);
        resultado4= condicion4? "SI"    :   "NO"    ;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        
        System.out.println("¿Las dos primeras palabras introducidas tienen menos de 6 caracteres"
                + " o la tercera palabra tiene más de 8 caracteres? " + resultado1 + ".");
        System.out.println("¿La segunda palabra es la de mayor longitud de las tres? "+ resultado2 + ".");
        System.out.println("¿Las palabras introducidas son palabras encadenadas? " + resultado3 + ".");
        System.out.println("¿Las palabras introducidas son palabras circulares? " + resultado4 + ".");
        System.out.println ();
	System.out.println ("Fin del programa.");
        
        
    }
}
