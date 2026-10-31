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
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    /*
 * ENUNCIADO
 * Diseña un programa en Java que permita monitorizar el nivel de agua de un embalse. 
 * El embalse tiene una capacidad fija máxima de 2.000 hm3.
 * El usuario deberá introducir por el teclado el volumen de agua embalsada en un momento determinado.
 * A partir de esa cantidad, el programa calculará la cantidad de hectómetros cúbicos de agua que son 
 * necesarios para que el embalse se llene completamente.
 * Igualmente, se calculará el porcentaje que corresponde la cantidad de agua embalsada respecto a la capacidad total del embalse.
 *      - Si el porcentaje actual de agua embalsada es superior al 95% de la capacidad total del embalse se realizará una 
 *        liberación controlada de agua de un 10% del volumen de agua embalsada.
 *        En este caso, se debe informar al usuario del porcentaje de liberación que se ha realizado, de cuántos hm3 
 *        se han vaciado en esa operación, cual es el volumen actual del depósito, y cuál es el porcentaje actual.
 *      - Por contra, si el porcentaje actual del embalse es inferior al 95% no se realizará ningún tipo de liberación. 
 *        En este caso simplemente se mostrará el mensaje "No es necesario considerar la liberación controlada de agua en este momento."
 */


        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        
        //primero declaramos la constante que es la capacidad máxima del embalse
        final double CAPACIDAD_MAXIMA;  
        
        // Variables de entrada
        
        //Ahora declaramos la variable que el usuario introducirá por teclado
        double aguaEmbalsada;
        
        // Variables de salida

        String resultado;   //declaramos la variable del resultado que se mostrará al final

        // Variables auxiliares
        
        //a continuación, declaramos las variables que vamos a necesitar para hacer los 
        //cáculos de agua y también la variable que va a contener la condición
        double aguaRestante, porcentajeInicial;
        double hectometrosVaciados, volumenTrasLiberacion, porcentajeActual;
        boolean supera95;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 4. Gestión de recursos hídricos ");
        System.out.println("-----------------------------------------");
        System.out.println(" ");
        //mostramos el mensaje de la información que vamos a pedir que introduzca el usuario
        System.out.println("Por favor, introduce el volumen actual de agua embalsada (hm3):");
                aguaEmbalsada = teclado.nextDouble();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //primero inicializamos la constantes
        CAPACIDAD_MAXIMA = 2000;
        
        
        //ahora vamos a ir inicializando las variables para realizar los cálculos
        aguaRestante = CAPACIDAD_MAXIMA - aguaEmbalsada;
        porcentajeInicial= (aguaEmbalsada/CAPACIDAD_MAXIMA)* 100.0;
        
        //ahora mostraremos por pantalla los dos datos iniciales que se nos pide
        System.out.printf("Faltan %.2f hm3 para llenar completamente el embalse.%n", aguaRestante);
        System.out.printf("El embalse esta a un %.2f%% de su capacidad máxima.", porcentajeInicial);
                                                        //usamos %% en el printf para poder imprimir el simbolo %
        //terminamos de inicializar el resto de variables
        hectometrosVaciados= aguaEmbalsada * 0.10;
        volumenTrasLiberacion= aguaEmbalsada - hectometrosVaciados;
        porcentajeActual= (volumenTrasLiberacion/CAPACIDAD_MAXIMA)*100.0; 
        
        // a continuación establecemos los términos de la condición usando operadores lógicos y el operador ternario
        supera95= porcentajeInicial > 95.0;
        resultado= supera95?    "Se ha liberado un 10% del volumen, que corresponde a "+hectometrosVaciados+" hm3 de agua.\n" 
                + "El volumen actual del depósito es de "+volumenTrasLiberacion+" hm3, que supone un porcentaje del "+porcentajeActual+"% de su capacidad máxima.": 
                "No es necesario considerar la liberación controlada de agua en este momento.";
        
        
        
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        
        System.out.println(resultado);
        System.out.println ();
	System.out.println ("Fin del programa.");
        
        
    }
}
