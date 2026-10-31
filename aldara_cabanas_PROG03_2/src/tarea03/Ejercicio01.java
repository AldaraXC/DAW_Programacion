package tarea03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import libtarea3.Teatro;

/**
 * Ejercicio 1: Trabajo con teatros
 * @author Aldara María Cabañas Cuevas
 */

public class Ejercicio01 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1.2. Declaración de constante para dar formato de fecha hora 
        final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        
        // 1.1. Declaración de tres variables referencia a objetos instancia de la clase Teatro
        Teatro granTeatro;
        Teatro teatroReal;
        Teatro teatroJardinito;
        
        //Declaración variables auxiliares
        LocalDateTime fechaActual;      //declaramos las variables que vamos a usar para mostrar la fecha
        String fechaFormateada;

        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //              Presentación
        //----------------------------------------------
        System.out.println("TRABAJO CON TEATROS");
        System.out.println("--------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 2. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 2.1. Número de teatros creados hasta el momento
        //para obtener los 3 primeros datos usamos los métodos estáticos de la clase Teatro
        System.out.println("El número de teatros creados hasta el momento es: "+ Teatro.getTeatrosTotales());

        // 2.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.println("El número total de obras que se están representando en este momento es de: "+ Teatro.getObrasActivas());
        
        //2.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.println("El número total de entradas vendidas para todos los teatros y todas las obras es de: "+ Teatro.getEntradasVendidasTotales());
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("\n2.-CREACIÓN Y USO DE TEATROS");
        System.out.println("------------------------------\n");

        // 3.- Instanciación de tres objetos Teatro

        System.out.println("Creación de teatros (constructores)");
        System.out.println("-------------------------------------");

        // 3.1.- Intento de crear un teatro con un aforo inferior (hay que gestionar la posible excepción)
        try {                                                       
            granTeatro= new Teatro("Gran Teatro", 250);
        } catch (IllegalArgumentException ex1){      
            System.out.println(ex1.getMessage());
            //para gestionar la excepción vamos a capturarla con el catch y usaremos el método getMessage para 
            //que muestre por pantalla el mensaje adecuado al tipo de excepción
        }
        // 3.2.- Intento de crear un teatro con un aforo superior (hay que gestionar la posible excepción)
         try {
            granTeatro= new Teatro("Gran Teatro", 1250);
        } catch (IllegalArgumentException ex2){
            System.out.println(ex2.getMessage());
        }
        
        // 3.3.- Intento de crear un teatro con un nombre de teatro vacío y aforo por defecto
        try {
            granTeatro= new Teatro("");
        } catch (IllegalArgumentException ex3){
            System.out.println(ex3.getMessage());
        }

        // 3.4.- Creación de un primer teatro usando el constructor de dos parámetros
        //creamos las 3 instancias como especifica el enunciado
        granTeatro= new Teatro ("Gran Teatro", 900);
        
        // 3.5.- Creación de un segundo teatro con un aforo por defecto usando el constructor de un parámetro        
        teatroReal= new Teatro ("Teatro Real");
        
        // 3.6.- Creación de un tercer teatro usando el constructor sin parámetros        
        
        teatroJardinito= new Teatro ();
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        // 4.- Operaciones con teatros
        System.out.println("");
        System.out.println("Manipulación de teatros (métodos)");
        System.out.println("-----------------------------------");
        
        // 4.1.- Intento de terminar de representar una obra a un teatro que no tiene obra asignada (debemos capturar el error)
        try {       //para obtener este dato usaremos el método de instancia terminarObra. Además gestionaremos las excepciones como en el caso anterior
        granTeatro.terminarObra();
        } catch (IllegalStateException ex4){
            System.out.println(ex4.getMessage());
        }
        
        //4.2.- Asignamos una obra al teatro1 y lo llenamos (debemos comprobar antes si podemos asignarla)
        if (granTeatro.tieneObra()){        //con el uso del if else comprobaremos si el teatro tiene obra y si no tiene asignaremos una
            System.out.println("El teatro ya tiene una obra.");
        } else {
            granTeatro.asignarObra("Cats");
            //mostramos por pantalla la obra asignada al teatro a través del método correspondiente
            System.out.println("Se ha asignado la obra: "+ granTeatro.getObra()+".");
            granTeatro.llenarTeatro();
            //llenaremos el teatro y mostraremos los datos pedidos por pantalla usando los métodos de instancia adecuados
            System.out.println("El aforo del Gran Teatro es de: "+granTeatro.getAforo()+". Se han vendido "+granTeatro.getEntradasVendidas()+" entradas.");
        }
        
        //4.3.- Devolvemos 50 entradas del teatro1 (puesto que acabamos de llenar el teatro, no es necesario comprobar si podemos devolver entradas)
        granTeatro.devolverEntradas(50);
        //devolvemos las entradas mediante el método devolverEntradas y mostramos por pantalla la cantidad de entradas vendidas que quedan
        System.out.println("El total de entradas vendidas tras la devolución es de "+granTeatro.getEntradasVendidas()+" entradas.");
        
        
        //4.4.- Intentamos traspasar la representación de la obra del teatro1 al teatro2 (hay que gestionar la posible excepción)
        try {
            granTeatro.traspasarObra(teatroReal);
        } catch (IllegalStateException ex5){
            System.out.println(ex5.getMessage());
        }
        
        //4.5.- Devolvemos otras 50 entradas del teatro1 (no es necesario comprobar si podemos devolver entradas)
        granTeatro.devolverEntradas(50);
        System.out.println("El número total de entradas vendidas tras la devolución es de "+granTeatro.getEntradasVendidas()+"entradas.");
        
        //4.6.- Volvemos a intentar traspasar la obra del teatro1 al teatro2 (ahora no debe dar excepción)
        granTeatro.traspasarObra(teatroReal);
        //comprobamos que el otro teatro tiene asignada la obra que hemos traspasado
        System.out.println("Se ha traspasado al Teatro Real la obra: "+teatroReal.getObra());
        
        //4.7.- Devolver una entrada del teatro2
        teatroReal.devolverEntrada();
        System.out.println("El número total de entradas vendidas tras la devolución es de "+teatroReal.getEntradasVendidas()+"entradas.");
        
        
         //5.- Obtención de información del segundo teatro creado
        System.out.println ("\nPrueba de los getters del segundo teatro creado:");
        System.out.println ("----------------------------------------------------");
        
        fechaActual= LocalDateTime.now(); //con el método now vamos a crear una instancia de fecha y hora con los valores del momento en que se crea
        fechaFormateada= fechaActual.format(FORMATO_FECHA_HORA);//a continuación damos el formato deseado a fechaActual
        System.out.printf("Fecha de la prueba: %s.\n", fechaFormateada);
        //usamos los métodos de instancia adecuados para mostrar por pantalla los datos pedidos
        System.out.printf("El código del teatro es: %s.\n",teatroReal.getCodigoTeatro());
        System.out.printf("El nombre del teatro es: %s.\n",teatroReal.getNombreTeatro());
        System.out.printf("El aforo del teatro es: %d.\n",teatroReal.getAforo());
        if (teatroReal.tieneObra()){    //usaremos un if else para determinar el mensaje que se mostrará por pantalla dependiendo de si el teatro tiene o no obra asignada
            System.out.printf("Se está representando actualmente la obra %s.\n",teatroReal.getObra());
        } else {
            System.out.println("No se está representando ninguna obra actualmente.");
        }
        //----------------------------------------------
        //               Análisis Final
        //----------------------------------------------        
        // 6. Consulta de valores finales
        System.out.println("3.-CONSULTA FINAL DE VALORES GLOBALES");
        System.out.println("-------------------------------------");
        System.out.println();
        
        //volvemos a usar los métodos estáticos para mostrar los datos al final del programa
        // 6.1. Número de teatros creados hasta el momento
        System.out.printf("El número de teatros creados hasta el momento es: %d.\n",Teatro.getTeatrosTotales());

        // 6.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.printf("El número total de obras que se están representando en este momento es de: %d.\n", Teatro.getObrasActivas());
        
        //6.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.printf("El número total de entradas vendidas para todos los teatros y todas las obras es de: %d.\n", Teatro.getEntradasVendidasTotales());
        
    }
    
}