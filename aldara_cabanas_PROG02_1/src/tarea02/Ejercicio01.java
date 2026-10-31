package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. SUELDOS DE EMPLEADOS.
 *
 * @author CABAÑAS CUEVAS ALDARA MARIA
 */
public class Ejercicio01 {   
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        //primero declaramos las constantes que tendrán el mismo valor en toda la ejecucion
        final double SUELDO_BASE = 1500, EXTRA_MENOS_5AÑOS = 20,
                EXTRA_MAS_5AÑOS = 100, EXTRA_POR_AÑO = 50;
        
        // Variables de entrada
        //aquí declaramos las variables que vamos a pedir al usuario
        int opcionElegida, antiguedadEmpleado1, antiguedadEmpleado2, antiguedadEmpleado3;
        
                
        // Variables de salida
        //aquí declaramos las variables que usaremos para mostrar los resultados requeridos
        double salarioAnual, salarioMensual, sueldoEmpleado1, sueldoEmpleado2,
                sueldoEmpleado3;
        
        //Variables auxiliares
        double sueldoAdicionalAntiguedad, sueldoExtra1, sueldoExtra2, sueldoExtra3;
               
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Sueldos de Empleados\n");
        System.out.println("-----------------------------------------");      

        // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.
        // En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla.  
        
        //vamos a usar un bucle do-while para asegurarnos de que el menú de opciones se muestra al menos una vez
        
        do{
        
        System.out.println("");
        System.out.println("Menú de opciones:");
        System.out.println("1. Calcular sueldo en función de la antigüedad");
        System.out.println("2. Calcular el coste total en sueldos para la empresa");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.println("Seleccione una opción");
        //asignamos el valor introducido por el usuario a la variable de la opcion
        opcionElegida=teclado.nextInt();
              
            
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Cuando haya introducido una opción válida, llevamos a cabo la acción oportuna
        //  -Si nos indica 'Salir', nos despedimos y terminamos
        //  -Si nos indica las opciones 1 o 2
        //      -Realizamos los cálculos oportunos
        
        //para gestionar la opción que elija el usuario vamos a usar un switch
        switch (opcionElegida){
            case 3:     //si el usuario introduce el 3 simplemente imprimiremos el mensaje del salida del programa
                System.out.println("Saliendo del programa...");
                break;
                
            case 1:     /*aquí vamos a pedir los 3 numeros de antigüedad al usuario y asignar su valor
                a las variables correspondientes a cada empleado
                */
                System.out.println("Introduce la antigüedad del empleado 1: ");
                antiguedadEmpleado1 = teclado.nextInt();
                
                System.out.println("Introduce la antigüedad del empleado 2: ");
                antiguedadEmpleado2 = teclado.nextInt();
                
                System.out.println("Introduce la antigüedad del empleado 3: ");
                antiguedadEmpleado3 = teclado.nextInt();
                
                /*vamos a usar la estructura if-else para seleccionar la cantidad que se suma 
                al sueldo base de cada empleado dependiendo de si tiene más de 5 años de 
                antigüedad,5 años o menos
                */
                if (antiguedadEmpleado1 > 5){
                    sueldoExtra1 = SUELDO_BASE + EXTRA_MAS_5AÑOS;
                } else {
                    sueldoExtra1 = SUELDO_BASE + EXTRA_MENOS_5AÑOS;
                }
                //ahora calculamos el sueldo mensual (sin paga extra) sumando la cantidad
                //que corresponde por cada año de antigüedad
                sueldoEmpleado1 = antiguedadEmpleado1 * EXTRA_POR_AÑO + sueldoExtra1;
                
                if (antiguedadEmpleado2 > 5){
                    sueldoExtra2 = SUELDO_BASE + EXTRA_MAS_5AÑOS;
                } else {
                    sueldoExtra2 = SUELDO_BASE + EXTRA_MENOS_5AÑOS;
                }
                sueldoEmpleado2 = antiguedadEmpleado2 * EXTRA_POR_AÑO + sueldoExtra2;
                
                if (antiguedadEmpleado3 > 5){
                    sueldoExtra3 = SUELDO_BASE + EXTRA_MAS_5AÑOS;
                } else {
                    sueldoExtra3 = SUELDO_BASE + EXTRA_MENOS_5AÑOS;
                }
                sueldoEmpleado3 = antiguedadEmpleado3 * EXTRA_POR_AÑO + sueldoExtra3;
                
                //mostramos el resultado del sueldo de cada empleado
                System.out.println("Los salarios mensuales de los empleados (sin prorrateo de pagas extra son: ");
                System.out.println("Empleado 1: " + sueldoEmpleado1 + " euros.");
                System.out.println("Empleado 2: " + sueldoEmpleado2 + " euros.");
                System.out.println("Empleado 3: " + sueldoEmpleado3 + " euros.");
                break;
                
            case 2:     //ahora calculamos el sueldo anual de un empleado nuevo, sumandole al sueldo base el extra que
                //le corresponde por tener menos de 5 años de antigüedad
                salarioAnual = (SUELDO_BASE + EXTRA_MENOS_5AÑOS) * 14;
                //calculamos el sueldo mensual con las pagas prorrateadas
                salarioMensual = (SUELDO_BASE + EXTRA_MENOS_5AÑOS) * 14 / 12;
                //mostramos el resultado
                System.out.printf("El salario anual para un empleado sin antigüedad es: %.2f euros.%n", salarioAnual);
                System.out.printf("El salario mensual para un empleado sin antigüedad"
                        + " (con pagas prorrateadas) es: %.2f euros.%n", salarioMensual);
                break;
                
            default:
                //en la cláusula default establecemos el mensaje que aparecerá si el usuario escribe un número incorrecto
                System.out.println("Opción no válida. Introduce una de las opciones del menú");
                System.out.println("");
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        /* por último vamos a establecer la condición de parada del bucle que
        será cuando el usuario elija la opción 3
        */
        }while (opcionElegida!=3); 
    }                
}
