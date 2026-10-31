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
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
 * ENUNCIADO
        
 * Realiza un programa Java que permita la introducción de dos números reales. 
 * Estos números representarán el radio de la circunferencia y la altura del cilindro. 
 * Una vez introducidos los números por teclado, el programa calculará el volumen de dicho 
 * cilindro siguiendo la fórmula indicada y escribirá por pantalla el resultado 
 * (debes mostrar el resultado presentando únicamente dos decimales).
         */

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final double PI;

        // Variables de entrada
        double radio;
        double altura;

        // Variables de salida
        // Variables auxiliares
        double radio2;             // la variable radio2 sirve para calcular el radio al cuadrado sin usar métodos que no hemos visto

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 1. Cálculo del volumen de un cilindro");
        System.out.println("-----------------------------------------------");

        System.out.println("Introduce el radio:");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        radio = teclado.nextDouble();                       // a través del Scanner pedimos al usuario que escriba el radio del cilindro

        System.out.println("Introduce la altura:");   // mostramos un mensaje sobre la información que vamos a pedir por teclado
        altura = teclado.nextDouble();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        PI = 3.1415927;                                         //aquí inicializamos la constante PI para poder hacer la operación
        radio2 = radio * radio;                                 //También inicializamos radio2 para calcular el cuadrado
        double volumenCilindro = PI * radio2 * altura;          //Declaramos e inicializamos en la misma línea la variable que contiene la formula

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("El volumen de tu cilindro es %.2f. %n ", volumenCilindro);
                                            //aqui usamos printf para dar formato a la salida y que muestre 
                                            //solo dos decimales con el %.2f
        System.out.println();
        System.out.println("Fin del programa.");

    }
}
