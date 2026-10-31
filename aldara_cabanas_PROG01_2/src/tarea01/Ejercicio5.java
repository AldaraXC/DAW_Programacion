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
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    /*
 * ENUNCIADO
 * Escribe un programa en Java que permita calcular el importe a pagar por los clientes 
 * del Parque Acuático AquaTrass teniendo en cuenta los siguientes requisitos:
 *      - existirán dos tipos de entradas: infantil con un precio base de 10,00 € y adulto con un precio base de 15,00 €.
 *      - en caso de que el coste total de las entradas sea superior a 50,00 € se aplicará automáticamente un 5% de descuento. 
 *        Igualmente, si el importe base total es superior a 100,00 € el descuento será de un 15%
 *      
 * Además, una vez realizados los descuentos pertinentes se deberá aplicar un IVA del 21% al importe resultante.
 * El programa solicitará la cantidad de entradas de cada tipo que se desean comprar, 
 * realizará todos los cálculos necesarios y mostrará por pantalla los siguientes resultados:
 *      - el número de entradas de adulto y de entradas infantiles que comprará el cliente.
 *      - el importe total de las entradas antes de aplicar (si procede) el descuento.
 *      - el porcentaje de descuento que se aplicará o el texto "No procede descuento en esta compra"
 *        en caso de que no se cumplan los requisitos para aplicar descuento
 *      - el importe total aplicando el descuento (si procede) pero no el IVA.
 *      - el importe total de la compra tras aplicar el descuento que corresponda y el IVA indicado anteriormente.
 *
 * Por último, el sistema mostrará la cantidad final que deberá pagar el cliente la cual será 
 * la parte entera del importe total calculado anteriormente.
 */


        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        
        //declaramos las constantes que en este caso son los precios de las entradas
        final double PRECIO_INFANTIL, PRECIO_ADULTO;
        
        // Variables de entrada
        
        //declaramos las variables de la información que vamos a pedir al usuario
        int entradaInfantil, entradaAdulto;
        
        // Variables de salida
        
        //declaramos las variables que mostraremos al final por pantalla con los resultados
        double importeEntradas, importeConDto, importeConIva;
        int cantidadAPagar;
        
        // Variables auxiliares
        
        //declaramos las variables para poder establecer las condiciones
        double porcentajeDto;
        boolean ProcedeDto;
        String dtoAplicable;
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 5. ¡Vamos al parque acuático! ");
        System.out.println("---------------------------------------");
        System.out.println(" ");
        //mostramos el mensaje de la información que vamos a pedir que introduzca el usuario
        System.out.println("Por favor, introduce la cantidad de entradas infantiles que deseas adquirir:");
                entradaInfantil = teclado.nextInt();
        System.out.println("Por favor, introduce la cantidad de entradas de adulto que deseas adquirir:");
                entradaAdulto = teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        PRECIO_INFANTIL= 10.0;
        PRECIO_ADULTO= 15.0;
        importeEntradas= (PRECIO_INFANTIL*entradaInfantil)+(PRECIO_ADULTO*entradaAdulto);
        
        
        //vamos a establecer la condicion tipo string para que luego nos muestre por pantalla el descuento que procede
        ProcedeDto= importeEntradas > 50.0;
        dtoAplicable= ProcedeDto? (importeEntradas > 100.0)?  "Se aplicará un descuento del 15%." : 
                    "Se aplicará un descuento del 5%."  :   "No procede descuento en esta compra.";
        
        //ahora establecemos la condición para poder calcular el precio con el descuento aplicado
        importeConDto = (importeEntradas > 100.0) ? importeEntradas*0.85 : (importeEntradas > 50.0) ? importeEntradas*0.95 : importeEntradas;
        //inicializamos el resto de variables
        importeConIva= importeConDto * 1.21;
        cantidadAPagar= (int)importeConIva; 
        //en esta última variable hemos hecho una conversión para que no se muestren decimales como indica el enunciado 

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        
        //usaremos printf donde necesitemos que las cifras que se van a mostrar tengan 2 decimales
        System.out.println("Se comprarán "+entradaInfantil+" entradas infantiles y "+entradaAdulto+" entradas de adulto.");
        System.out.printf("El precio de las entradas antes de aplicar impuestos y posibles descuentos es de %.2f €.%n", importeEntradas);
        System.out.println(dtoAplicable);
        System.out.printf("Tras aplicar posibles descuentos el importe total de las entradas (sin IVA) es de %.2f €.%n", importeConDto);
        System.out.printf("El importe de las entradas con el IVA incluido es de %.2f €.%n", importeConIva);
        System.out.printf("La cantidad final a pagar por el cliente es de %d €.%n", cantidadAPagar);
        System.out.println ();
	System.out.println ("Fin del programa.");
        
        
    }
}
