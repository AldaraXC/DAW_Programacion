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
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    /*
 * ENUNCIADO 
 *
 * Realiza un programa Java que permita la introducción de tres números enteros. 
 * El programa realizará los cálculos necesarios para determinar:
 *      - un tercio del primer número más la mitad del tercer número.   
 *      - el cuadrado de la mitad de la suma del segundo número más el tercero.
 *      - si el triple de la suma del segundo más el tercer número menos el primero es par.
 *      - la suma del primero más el segundo, multiplicado por la diferencia del tercero 
 *        menos el primero y todo ello partido por el segundo número.      
 */


        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        
        int num1;         //declaramos primero las 3 variables de los números a introducir
        int num2;
        int num3;
        
        
        // Variables de salida

        double operacion1;          //ahora declaramos las variables de las 4 operaciones que realizaremos con esos numeros
        double operacion2;          //las que tendran valor numerico las declaramos como double para ver los decimales
        String operacion3;
        double operacion4;

        // Variables auxiliares
        
        double sumaNumeros1_2;  //usaremos esta variable para la suma de los numeros 1 y 2 que se repite
        double resultado3;      //usaremos esta variable para el cálculo de la condicion de la operacion3
        double parte1;          //usaremos estas dos últimas variables para dividir en partes la última operación
        double parte2;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2. Operadores aritméticos ");
        System.out.println("-----------------------------------");
        System.out.println(" ");
        
        System.out.println("Por favor, introduce el valor del primer número:"); //mostramos mensaje sobre la información que vamos a pedir por teclado
            num1 = teclado.nextInt();                                      //a traves del Scanner pedimos al usuario que introduzca los números
        System.out.println("Ahora introduce el valor del segundo número:");
            num2 = teclado.nextInt();
        System.out.println("Por último, introduce el valor del tercer número:");
            num3 = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //en este apartado inicializamos las variables con las fórmulas de cada operacion
        
        sumaNumeros1_2 = num2+num3;
        
        //a partir de aqui tenemos que hacer la conversion de tipo de las variables de los numeros enteros introducidos 
        //para poder obtener los decimales correctamente
        
        operacion1 =((double)num1/3.0) + ((double)num3/2.0);    
        

        operacion2 = ((double)sumaNumeros1_2/2)*((double)sumaNumeros1_2/2);

        resultado3 =((double)sumaNumeros1_2*3) - num1;       //inicializamos la variable con la fórmula para establecer la condición
        operacion3 = resultado3%2==0 ?  "par" : "impar";
         
        //en el caso de la operacion 4, vamos a dividirla en partes
        parte1 = (double)num1 + (double)num2;
        parte2 = (double)num3 - (double)num1;
        operacion4 = parte1*parte2/num2;
     
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        
        System.out.println("El tercio del primer número más la mitad del tercer número es " + operacion1 + ".");
        System.out.println("El cuadrado de la mitad de la suma del segundo número más el tercero es " + operacion2 + ".");
        System.out.println("El triple de la suma del segundo más el tercer número menos el primero es " + operacion3 + ".");
        
        //en la siguiente línea utilizaremos una secuencia de escape para hacer un salto de línea,
        //ya que el texto de la última operacion es bastante largo
        
        System.out.println("La suma del primer número más el segundo, multiplicado por la diferencia del tercero \n"
                + " menos el primero y todo ello partido por el segundo número es " + operacion4 + ".");
        System.out.println ();
	System.out.println ("Fin del programa.");
        
        
    }
}
