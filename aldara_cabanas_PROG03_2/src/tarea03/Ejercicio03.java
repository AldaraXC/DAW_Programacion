package tarea03;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Ejercicio 3: Día de cumpleaños
 *
 * @author Aldara Maria Cabañas Cuevas
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Variables de entrada
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        int anyoActual;
        // Variables de salida
        

        // Variables auxiliares
        int maxDiasMes;
        String nombreDia;
        LocalDate fechaCumple;
        LocalDate fechaRepeticion;
        String nombreDiaRepeticion;
        int contador = 0;
        String fechaFormateada;
        
        // Objeto Scanner para lectura desde teclado
        Scanner sc = new Scanner(System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DÍA DE CUMPLEAÑOS");
        System.out.println("-----------------");

        // 1. Entrada de datos: lectura de año de nacimiento
        //vamos a usar bucles do while para que si no de introduce un valor correcto se vuelvan a pedir los datos por pantalla
        
        // 1.1.- Leer y comprobar el año de nacimiento (entre 1900 y año actual)
        anyoActual= LocalDate.now().getYear(); //inicializamos la variable usando los métodos de LocalDate que nos devolverán el valor del año en que se hace la consulta
          
            do {
                try { 
                    System.out.println("Introduce tu año de nacimiento (desde 1900 hasta el año actual):");
                    anyo = sc.nextInt();
                    if (anyo < 1900 || anyo > anyoActual) {
                    System.out.println("Error de lectura. Año incorrecto.");
                    }
                } catch (InputMismatchException anyoErroneo) {
                    System.out.println("Error de lectura. Año incorrecto");
                    sc.nextLine(); //usamos este método para limpiar las entradas erróneas previas
                }
            } while (anyo < 1900 || anyo > anyoActual);
        

        // 1.2.- Leer y comprobar el mes de nacimiento 
            do {
                try { 
                    System.out.println("Introduce el mes de nacimiento (1-12):");
                    mes = sc.nextInt();
                    if (mes < 1 || mes > 12) {
                    System.out.println("Error de lectura. Mes incorrecto.");
                    }
                } catch (InputMismatchException mesErroneo) {
                    System.out.println("Error de lectura. Mes incorrecto");
                    sc.nextLine(); 
                }
            } while (mes < 1 || mes > 12);
            

        // 1.3.- Averiguamos cuántos días tiene el mes de nacimiento
            //vamos a usar YearMonth para crear un objeto con la combinación de año y mes que hemos introducido por consola y usaremos
            //lenghtOfMonth para recoger el número máximo de días que tiene ese mes
            maxDiasMes= YearMonth.of(anyo, mes).lengthOfMonth();
          
        // 1.4.- Leer y comprobar el día de nacimiento 
            do {
                try { 
                    System.out.println("Introduce el día de nacimiento:");
                    dia = sc.nextInt();
                    if (dia < 1 || dia > maxDiasMes) {
                    System.out.println("Error de lectura. Día incorrecto.");
                    }
                } catch (InputMismatchException diaErroneo) {
                    System.out.println("Error de lectura. Día incorrecto");
                    sc.nextLine(); 
                }
            } while (dia < 1 || dia > maxDiasMes);

        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        //2.- Cálculo del día de la semana en que cayó el nacimiento       
                fechaCumple = LocalDate.of(anyo, mes, dia); //creamos la instancia de la fecha de cumpleaños
                nombreDia = fechaCumple.format(DateTimeFormatter.ofPattern("EEEE")); 
                // usamos ofpattern con el formato EEEE por que utiliza directamente el lenguaje del sistema para representar el dia de la semana.
                System.out.println("El día en que naciste fue " + nombreDia +" .");
                
        // 3.- Recorremos desde el año posterior al año de nacimiento hasta el año actual (bucle)
                System.out.println("¿Cuántas veces ha caído tu cumpleaños en "+nombreDia+"?");
                System.out.println("-----------------------------------------------------------");

                //Vamos a separar la fecha del 29 de Febrero de las demás fechas
                if (dia != 29) {
                    for (int i = anyo + 1; i <= anyoActual; i++) {  // usamos un bucle for para recorrer desde la fecha del nacimiento hasta el año actual.
                        fechaRepeticion = LocalDate.of(i, mes, dia);       // sacamos el dia de la semana 
                        nombreDiaRepeticion = fechaRepeticion.format(DateTimeFormatter.ofPattern("EEEE"));    // damos el mismo formato que nombreDia para compararlos.
                        if (nombreDiaRepeticion.equals(nombreDia)) {       // hacemos la comparacion de los dos dias de la semana segun el año y el mes.
                            fechaFormateada = fechaRepeticion.format(FORMATO_FECHA);      //le damos formato a la fecha
                            System.out.println(contador + ". " + fechaFormateada);    // imprimimos el contados, para saber cuantas fechas identicas tenemos y las fechas ya formateadas
                            contador++;             
                        }
                    }
                } else if (dia == 29) {
                    for (int j = anyo + 1; j <= anyoActual; j++) {
                        if (Year.isLeap(j)) {       // usamos j para comprobar los años que son bisiestos 
                            fechaRepeticion = LocalDate.of(j, mes, dia);       // sacamos el dia de la semana 
                            nombreDiaRepeticion = fechaRepeticion.format(DateTimeFormatter.ofPattern("EEEE"));    
                            if (nombreDiaRepeticion.equals(nombreDia)) {       
                                contador++;             
                                fechaFormateada = fechaRepeticion.format(FORMATO_FECHA);     
                                System.out.println(contador + ". " + fechaFormateada);    
                            }
                        }
                    }
                }

        // 4.- Mostramos por pantalla el número de coincidencias
                System.out.println("Número total de coincidencias: " + contador);
    }
}
