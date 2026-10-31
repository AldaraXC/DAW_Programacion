package tarea03;

import java.util.Random;
import libtarea3.Dado;

/**
 * Ejercicio 2: Uso de la clase Dado
 *
 * @author Aldara María Cabañas Cuevas
 */
public class Ejercicio02 {

    public static void main(String[] args) {
       
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        //Constantes
        
        // Variables de entrada (dados y puntuación máxima)
        int lanzamientoJug1;       //declaramos las variables que recogeran los lanzamientos de los dados y la puntuación máxima
        int lanzamientoJug2;
        int lanzamientoJug3;
        int puntuacionMax;

        // Variables de salida
        int ganador=0;      //declaramos e inicializamos a 0 las variables que recogeran el dado ganador y la puntuación de la tirada ganadora
        int puntos=0;
        // Variables auxiliares
       
        Random numAleatorio = new Random();     //creamos un número aleatorio con la clase Random
        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //En realidad no hay entrada de datos como tal, pero podemos considerar
        //el número máximo como información de entrada ya que variará el
        //comportamiento del programa.

        //1. Cálculo del número aleatorio de puntos (entre 30 y 60)
        puntuacionMax = numAleatorio.nextInt(30, 60);       
            //con este método asignamos un valor al número aleatorio que creamos antes comprendido entre 30 y 60
                
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------  

        //2. Creación de 3 dados (jugadores) de 6 caras
        Dado jugador1 = new Dado();     //creamos los 3 dados
        Dado jugador2 = new Dado();
        Dado jugador3 = new Dado();
        
        //3. Lanzamiento de los dados y acumulación de las puntuaciones
        System.out.println("LANZAMIENTO DE DADOS");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.printf("Número máximo de puntos: %d \n" , puntuacionMax); //mostramos por pantalla cual será la puntuación máxima del juego
        System.out.println("");
        System.out.printf("                   DADO1  DADO2  DADO3\n");
        
        //vamos a usar un bucle do while para que se sigan lanzando dados hasta que el la suma de las puntuaciones supere la puntuación máxima
        do {
            //3.1 Lanzamos cada uno de los dados y mostramos las puntuaciones
            //Utilizamos los métodos de la clase para contar los lanzamientos
            lanzamientoJug1= jugador1.lanzar();         //con el método lanzar de la clase Dado le damos un valor al lanzamiento de cada uno
            lanzamientoJug2= jugador2.lanzar();
            lanzamientoJug3= jugador3.lanzar();
            
            //mostramos por pantalla el número de lanzamiento y el valor del lanzamiento de cada dado usando los métodos de instancia
            System.out.printf("Lanzamiento nº%d:     %d      %d      %d  \n", jugador1.getNumeroLanzamientos(), lanzamientoJug1, lanzamientoJug2, lanzamientoJug3);
            //3.2 Utilizando los métodos de la clase, acumulamos las puntuaciones
            //de todos los dados en todos los lanzamientos.
            
            
        } while ((jugador1.getSumaPuntuacionHistorica()+jugador2.getSumaPuntuacionHistorica()+jugador3.getSumaPuntuacionHistorica())<=puntuacionMax);
        
        //cuando la suma de las puntuaciones supera a la puntuación máxima el programa sale del bucle y mostramos por pantalla el resultado usando los métodos necesarios
        System.out.printf("Juego terminado. La suma de los lanzamientos es: %d\n", jugador1.getSumaPuntuacionHistorica()+jugador2.getSumaPuntuacionHistorica()+jugador3.getSumaPuntuacionHistorica());
        
        
        //4. Comprobación de cuál de los dados ha sido el ganador y consulta de
        //todas sus tiradas
        
        //mediante el uso de if else encadenados vamos a establecer las condiciones para mostrar al ganador y cual ha sido su puntuación
        if ((lanzamientoJug1>lanzamientoJug2)&&(lanzamientoJug1>lanzamientoJug3)) {
            ganador=1;
            puntos=lanzamientoJug1;
        } else if ((lanzamientoJug2>lanzamientoJug1)&&(lanzamientoJug2>lanzamientoJug3)) {
            ganador=2;
            puntos=lanzamientoJug2;
        } else if ((lanzamientoJug3>lanzamientoJug1)&&(lanzamientoJug3>lanzamientoJug2)) {
            ganador=3;
            puntos=lanzamientoJug3;
        }
        
        
        
        //----------------------------------------------
        //      Salida de resultados
        //----------------------------------------------
        
        //por último mostramos por pantalla los resultados usando las variables de ganador y puntos
        System.out.printf("El ganador es el dado %d con %d puntos en la última jugada.\n", ganador, puntos);
        //para mostrar el número de veces que ha salido una cara  y el número total de lanzamientos usamos los métodos estáticos 
        //getNumeroVecesCaraGlobal y getNumeroLanzamientosGlobal por lo que llamaremos al método desde la clase y no desde una instancia de Dado
        System.out.printf("El valor %d ha salido un total de %d veces en todo el juego y se han realizado un total de %d lanzamientos.\n", puntos, Dado.getNumeroVecesCaraGlobal(puntos), Dado.getNumeroLanzamientosGlobal());
        //finalmente mostraremos en texto todos los lanzamientos del dado ganador usando el método getSerieHistoricaLanzamientos que devuelve un resultado tipo string
        System.out.printf("Todos los lanzamientos del dado %d: %s.\n", ganador, (ganador == 1 ? jugador1.getSerieHistoricaLanzamientos() : ganador == 2 ? jugador2.getSerieHistoricaLanzamientos() : jugador3.getSerieHistoricaLanzamientos()));
    }
}
