package tarea1;

import java.util.Scanner;

/**
 * Ejercicio 2. Uso de cadenas.
 *
 * @author Aldara Maria Cabañas Cuevas
 */


public class Ejercicio2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        //declaramos todas las variables que vamos a usar e inicializamos la variable cadenaInicial ya que sabemos su contenido desde el principio
        // Variables de entrada
            String cadenaInicial = " Don Quijote de la Mancha ", letraUsuario;
            
        // Variables de salida
            char letraGrupoProg;
            String cadenaFinal, contieneM, acabaConsonante;
            
        
        // Variables auxiliares
            int posicionCentral;
            char caracterFinal;
        
        // Clase Scanner para petición de datos de entrada
            Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
            System.out.println("USO DE CADENAS DE CARACTERES");
            System.out.println("----------------------------");
            System.out.println("Introduzca la letra del grupo al que perteneces:");
            letraUsuario = teclado.nextLine();
            System.out.println("Cadena original:"+ cadenaInicial);
            System.out.println("");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
            //usamos el método trim de la clase String para quitar espacios al final y al principio
            cadenaInicial = cadenaInicial.trim();
            
            //usamos metodo substring para quedarnos con la parte que requiere el ejercicio 
            cadenaInicial = cadenaInicial.substring(11);
            
            //vamos a añadir el valor de la letra que ha introducido el usuario (que se lee como string) a la variable tipo char que hemos creado antes
            letraGrupoProg = letraUsuario.charAt(0);
            
            //usamos el metodo replace para cambiar el caracter M por L y concatenamos el guión y la letra del grupo
            cadenaFinal = cadenaInicial.replace('M', 'L') + "-" + letraGrupoProg;
            
            //calculamos cual es el numero del caracter central usando el metodo length y dividiendo entre 2
            posicionCentral= cadenaFinal.length()/2;
            
            //usamos el operador ternario y el metodo contains para ver si la cadena contiene la M
            contieneM = cadenaFinal.contains("M")? "SI" : "NO";
            
            //usamos de nuevo el operador ternario para comprobar si la última letra es consonante
            caracterFinal = cadenaFinal.charAt(cadenaFinal.length()-1);//restamos 1 ya que las posiciones de los strings empiezan desde el 0
            acabaConsonante = (caracterFinal=='A'||caracterFinal=='E'||caracterFinal=='I'||caracterFinal=='O'||caracterFinal=='U')? "NO": "SI";
            //primero usamos la variable auxiliar tipo char para poder comparar en la condicion el caracter final con cada una de las vocales

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
            System.out.println("RESULTADOS");
            System.out.println("----------");
            System.out.println("La cadena final es: " + cadenaFinal);
            System.out.println("La cadena final contiene: " + cadenaFinal.length() + " caracteres");
            System.out.println("La cadena final tiene el caracter: " + cadenaFinal.charAt(posicionCentral) + " en su posición central");
            System.out.println("La cadena final contiene el caracter 'M': " + contieneM);
            System.out.println("La cadena final termina en consonante: " +acabaConsonante);
        
        
    }
}