package tarea02;

import java.util.Random;

/**
 *
 * @author Aldara Mª Cabañas Cuevas
 */
public class Ejercicio04 {

/* ENUNCIADO
* Se desea desarrollar una aplicación para simular los premios en una máquina tragaperras. 
* Dicha máquina obtiene en cada jugada una secuencia de tres símbolos y cada símbolo se 
* obtendrá de forma aleatoria, con la misma probabilidad que los demás símbolos.
* Los símbolos son P, F, M, N y C. Representan una fruta de las siguientes respectivamente:
*   - Plátano (P)
*   - Fresa (F)
*   - Manzana (M)
*   - Naranja (N)
*   - Cereza (C)
* El simulador nos debe decir el número de jugadas que se ha tardado en obtener un premio 
* y en caso de obtenerlo, qué premio ha obtenido.
* Los premios son:
*   - Premio 1: PPP
*   - Premio 2: FFF
*   - Premio 3: MMM
*   - Premio 4: NNN
*   - Premio 5: CCC
    */
    public static void main(String[] args) {
        //----------------------------------------------
        //               Declaración de variables
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        
        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        String secuenciaPremio=" ";
        int intento=1, premio=0;
        int frutas, fruta1=0, fruta2=0, fruta3=0;
        /*en este caso he inicializado algunas variables directamente (como las variables secuenciaPremio, premio, fruta1, fruta2 y fruta3)
        ya que al tomar el valor necesario dentro del bucle me estaban dando error si no las inicializaba antes.
        Una vez las usamos dentro del buclen toman el valor correcto y el procesamiento sale bien
        En el caso de la variable intento la he inicializado en 1 para que no empiece a contar los intentos desde 0.
        Por ultimo la variable frutas tomará el valor que le asigne la clase random.
        */
        /* La clase Random es una clase de Java que nos sirve para generar elementos aleatorios
            en este caso el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1, por ejemplo r.nextInt(5), generará 
            un número entero entre 0 y 4, es decir, podrá devolver 0,1,2,3 o 4 cada vez que se 
            utilice.
         */
        Random r = new Random();
        //----------------------------------------------
        //              Entrada de datos
        //----------------------------------------------
        // En este caso no hay entrada de datos. 
        System.out.println("Ejercicio 4. Simulador de Máquina Tragaperras.");
        System.out.println("----------------------------------------------------"); 
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        System.out.println("Voy a generar secuencias de 3 frutas entre Plátano, Fresa, Naranja, Manzana\n"
                + " y Cereza hasta conseguir 3 iguales y te diré qué premio has obtenido de los cinco:");
        // Hemos de generar una secuencia de 3 frutas
        // Las frutas son: Plátano, Fresa, Manzana, Naranja, Cerezas 
        // Representamos cada fruta con un caracter: P,F,M.N,C
        // Para elegir una de las cinco frutas podemos asociar cada una con un número
        // Para ello podemos generar un número aleatorio 
        
        //vamos a usar un bucle do-while para que se ejecute el codigo hasta que se consiga el premio
        do {
            System.out.print(intento+"-");
            //usaremos un bucle for para obtener una secuencia de 3 letras para cada intento
            for (int i=1 ; i<=3 ; i++){   
                
                frutas=r.nextInt(5); //con esto generaremos un numero aleatorio entre el 0 y el 4
                // con los siguientes if-else anidados vamos a distinguir cada una de las 3 frutas de la secuencia y les asignaremos el 
                //valor aleatorio que hemos obtenido antes
                if (i == 1) {
                    fruta1 = frutas;
                  } else if (i == 2) {
                    fruta2 = frutas;
                  } else if (i == 3) {
                    fruta3 = frutas;
                  }
                //vamos a usar un switch para asignar una fruta a cada uno de los valores posibles que nos va a dar la variable frutas e imprimir su inicial
                switch(frutas){
                    case 0:
                        System.out.print("P");
                        break;
                    case 1:
                        System.out.print("F");
                        break;
                    case 2:
                        System.out.print("M");
                        break;
                    case 3:
                        System.out.print("N");
                        break;
                    case 4:
                        System.out.print("C");
                        break;
                //en este caso no voy a añadir un default ya que el usuario no va a introducir datos y el numAleatorio no va 
                //a devolver ningun valor diferente a los contenidos en los cases
                }
            }
            System.out.println();
            intento++;
            
            //con los siguientes if-else anidados asignaremos un numero de premio a cada secuencia de 3 frutas iguales
            if (fruta1 == 0 && fruta2 == 0 && fruta3 == 0) {
            premio = 1;
            secuenciaPremio="PPP";
            } else if (fruta1 == 1 && fruta2 == 1 && fruta3 == 1) {
                premio = 2;
                secuenciaPremio="FFF";
            } else if (fruta1 == 2 && fruta2 == 2 && fruta3 == 2) {
                premio = 3;
                secuenciaPremio="MMM";
            } else if (fruta1 == 3 && fruta2 == 3 && fruta3 == 3) {
                premio = 4;
                secuenciaPremio="NNN";
            } else if (fruta1 == 4 && fruta2 == 4 && fruta3 == 4) {
                premio = 5;
                secuenciaPremio="CCC";
            }  
        
    } while((fruta1 != fruta2) || (fruta2 != fruta3) || (fruta1 != fruta3));
      
        //El proceso debe hacerse hasta que se obtengan 3 iguales, cosa que suponemos que se producirá en x intentos. Hemos de llevar la cuenta de los intentos.
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //Además de los intentos en los que se ha obtenido el premio, hay que decir qué premio hemos tenido de entre los posibles.
    System.out.println("Has conseguido el premio "+ premio +" en el intento "+intento+" con la secuencia: "+secuenciaPremio+".");
    }
}
