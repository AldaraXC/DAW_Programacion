package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. Gestión de un Gimnasio.
 *
 * @author Aldara María Cabañas Cuevas
 */
public class Ejercicio01 {   
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        /*declaramos constantes y variables que vamos a usar a lo largo del programa e inicializamos algunas de ellas
        para que no nos salgan avisos más adelante*/
        // Constantes
        final double PRECIO_BASE_FITNESS=10.0, PRECIO_BASE_YOGA= 15.0, PRECIO_BASE_MUSCULACION=20.0;
        final int TIPOS_MATRICULA=3;
        
        // Variables de entrada
        int iva, opcionMenu, tipoMatricula, descuento, totalMatriculas;
                
        // Variables de salida
        double pvp, precioOferta, importeTotal=0;
        
        //Variables auxiliares
        double precioBase=0;
        String tipoActividad="";
               
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        
        System.out.println("EJERCICIO 1: GESTIÓN DE UN GIMNASIO");
        System.out.println("-----------------------------------");    
        System.out.println("TIPOS DE MATRÍCULAS: 1. FITNESS - 2. YOGA - 3. MUSCULACIÓN");
        //mostramos por pantalla los precios base de cada actividad
        System.out.println("Precio de la Matrícula tipo 1 (FITNESS): "+PRECIO_BASE_FITNESS+"€");
        System.out.println("Precio de la Matrícula tipo 2 (YOGA): "+PRECIO_BASE_YOGA+"€");
        System.out.println("Precio de la Matrícula tipo 3 (MUSCULACIÓN): "+PRECIO_BASE_MUSCULACION+"€");
        
        do {    //usamos un bucle do-while para que el menú de opciones del programa se repita hasta que el usuario seleccione la opcion Salir
            System.out.println("");
            System.out.println("--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Calcular PVP de cada matrícula.");
            System.out.println("2. Aplicar oferta a un tipo de matrícula (sin IVA).");
            System.out.println("3. Calcular el importe total de matrículas relizadas (sin IVA).");
            System.out.println("4. Salir.");
            System.out.println("Seleccione una opción:");   //pedimos al usuario que introduzca la opcion que quiera
            opcionMenu = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
            //vamos a usar un switch para que el programa haga una acción u otra dependiendo de la opción que elija el usuario
            switch (opcionMenu){
                case 1: //calcular el PVP de cada tipo de matrícula
                    
                    //ENTRADA DE DATOS
                    /* para esta opción vamos a usar un bucle for para no tener que repetir código con cada actividad.
                    Aunque la salida no es exactamente igual que en la solución, creo que es mejor hacerlo así por si más
                    adelante se quieren añadir otras actividades en el gimnasio. Así se repetirá el codigo tantas veces
                    como actividades diferentes haya.
                    */
                    for (int i = 1; i <= TIPOS_MATRICULA; i++) {  
                        System.out.println("Ingrese el IVA para el tipo de matrícula "+ i +" (4 - 10 - 21):");
                        iva = teclado.nextInt();    //pedimos al usuario que introduzca el iva
                        
                    //PROCESAMIENTO
                    /* como en esta parte vamos a tener que asignar un valor determinado a dos variables, he optado por hace un switch
                    en lugar de encadenar varios if else. Así dependiendo de la opción elegida se dará el precio y nombre acorde a cada actividad,
                    además de poder ampliar los cases si se añaden más actividades en el futuro
                    */
                        switch (i){
                            case 1:
                                precioBase = PRECIO_BASE_FITNESS;
                                tipoActividad = "Fitness";
                                break;
                            case 2:
                                precioBase = PRECIO_BASE_YOGA;
                                tipoActividad = "Yoga";
                                break;
                            case 3:
                                precioBase = PRECIO_BASE_MUSCULACION;
                                tipoActividad = "Musculación";
                                break;
                        }       //en este caso no vamos a poner clausula default ya que al estar controlado por el bucle for, i solo puede valer 1, 2 o 3
                        
                        pvp = precioBase + (precioBase*iva/100.0); //cada vez que use un literal voy a escribirlo en decimales para que el resultado de la operacion salga en decimales
                    
                    //SALIDA DE RESULTADOS
                        System.out.println("El PVP de la actividad de "+ tipoActividad +" es: "+ pvp +"€");
                        System.out.println("");
                    }
                    break;
                
                case 2:   //aplicar una oferta a un tipo de matricula
                    //ENTRADA DE DATOS
                    System.out.println("Seleccione tipo de matrícula (1. Fitness, 2. Yoga o 3. Musculación:");
                    tipoMatricula = teclado.nextInt();
                    System.out.println("Ingrese el % de descuento a aplicar: ");
                    descuento = teclado.nextInt();
                    
                    //PROCESAMIENTO
                    // como aquí solo hay que asignar el valor de una variable, he optado por encadenar if else 
                    if (tipoMatricula==1){
                            precioBase = PRECIO_BASE_FITNESS;
                    } else if (tipoMatricula==2){
                            precioBase = PRECIO_BASE_YOGA;
                    } else if (tipoMatricula==3){
                            precioBase = PRECIO_BASE_MUSCULACION;
                    }
                    
                    precioOferta = precioBase - (precioBase*descuento/100.0);
                    
                    //SALIDA DE RESULTADOS
                    System.out.println("El precio final (sin iva) con descuento para el tipo de matrícula "+ tipoMatricula +" es: "+ precioOferta +"€");
                    break;
                
                case 3:     //calcular importe total de matriculas realizadas
                    //de nuevo voy a optar por un bucle for por los mismos motivos
                    for (int i = 1; i <= TIPOS_MATRICULA; i++) {  
                        
                    //ENTRADA DE DATOS
                        System.out.println("Ingrese las matrículas realizadas para el tipo de matrícula "+ i +" (1. Fitness, 2. Yoga o 3. Musculación:):");
                        totalMatriculas = teclado.nextInt();
                    
                    //PROCESAMIENTO
                        //como solo hay que asignar el valor de una variable usare un if else en lugar de otro switch
                        if (i==1){
                            precioBase = PRECIO_BASE_FITNESS;
                        } else if (i==2){
                            precioBase = PRECIO_BASE_YOGA;
                        }else if (i==3){
                            precioBase = PRECIO_BASE_MUSCULACION;
                        }
                        //añadimos el acumulador para que vaya sumando el resultado de cada vuelta del bucle al importe total
                        importeTotal += precioBase*totalMatriculas;
                    }
                    
                    //SALIDA DE RESULTADOS
                    System.out.println("El importe total (sin iva) de las matrículas realizadas es: "+ importeTotal +"€");
                    break;
                
                case 4:     //salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                
                default:    //añadimos la clausula default para cuando el usuario elija una opcion incorrecta, volviendo a mostrar el menú
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcionMenu !=4); //el menú se seguirá repitiendo hasta que el usuario seleccione la opcion 4 Salir
        
    }                
}
