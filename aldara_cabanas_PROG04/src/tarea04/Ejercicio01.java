package tarea04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Aldara María Cabañas Cuevas
 */

public class Ejercicio01 {      
        
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes   
        final int COLUMNAS_INVENTARIO = 5;  //Número de columnnas que almacenaremos en el inventario.

        // Variables de entrada
        int filasInventario, opcionMenu;
        String[][] inventario; //declaramos el array para crearlo cuando el usuario introduzca el numero de filas
        String codigoDispositivo, nombreDispositivo, tipoDispositivo, estadoDispositivo, precioDispositivo;
        // Variables de salida


        // Variables auxiliares
        boolean codigoValido=false, tipoValido=false, estadoValido=false, precioValido=false, codigoEncontrado=false;
        String codigoBuscado;

        // Clase Scanner para petición de datos de entrada  
        Scanner teclado = new Scanner(System.in);


        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------  
        System.out.println("Ejercicio 1: Inventario de dispositivos");
        System.out.println("---------------------------------------");
        System.out.println();

        do { //usamos un bucle do while para que el codigo se repita hasta que el usuario introduzca un numero correcto
            System.out.println("¿Cuantos dispositivos desea registrar?");
            filasInventario = teclado.nextInt();
            teclado.nextLine(); //añado esta línea para que el enter que pulsamos al introducir el numero de dispositivos no se guarde en la memoria
            if (filasInventario<=0){ //usamos un if para mostrar un mensaje cuando se selecciona un numero incorrecto
                System.out.println("El número de dispositivos debe ser mayor que 0. Inténtelo de nuevo");
            }
        } while (filasInventario<=0);


        inventario = new String[filasInventario][COLUMNAS_INVENTARIO]; //creamos el array con las filas seleccionadas según el numero de dispositivos a introducir
        
        //EXPRESIONES REGULARES: las creamos fuera del bucle para no tener que compilarlas en cada iteración
        //para crear la expresión regular del codigo de dispositivo usamos la clase pattern
        Pattern patronDispositivo = Pattern.compile("^DISP-\\d{4}$");//añadimos ^ y $ para delimitar el principio y el fin de la cadena
        
        //para introducir el precio he usado una expresión regular ya que era la opción que veía mas clara para la introducción del mismo
        Pattern patronPrecio = Pattern.compile("^[0-9]+([.,][0-9]{1,2})?$");
        //con esta expresión solo permitimos dígitos y una parte decimal opcional con una coma o un punto
        
        for (int i=0; i<filasInventario; i++) { //usamos un bucle for para recorrer el array introduciendo los datos
            System.out.println();
            System.out.printf("--- Dispositivo %d ---%n", i+1);

            do { //usamos bucles do-while en cada uno de los datos a rellenar para repetir el codigo cada vez que el usuario introduzca datos incorrectos
                System.out.println("Introduzca código (DISP-XXXX):");
                codigoDispositivo = teclado.nextLine().toUpperCase();//usamos el metodo toUpperCase para asegurarnos de que las letras van en mayuscula
                Matcher coincidenciaCodigo = patronDispositivo.matcher(codigoDispositivo);
                //usamos el metodo matcher para vincular el patron de la expresion regular con el codigo introducido por el usuario
                if (!coincidenciaCodigo.matches()){//con el metodo matches comprobamos si el codigo introducido sigue el patron definido en la expresion regular
                    System.out.println("--El código no es válido--");
                    codigoValido= false;
                }else{
                    codigoValido = true;
                    for (int j=0; j<i; j++){ //con otro bucle for recorremos las filas anteriores del array para buscar si el codigo existe ya 
                        if (inventario[j][0].equals(codigoDispositivo)){ //para buscar la coincidencia usamos el metodo equals que devolvera true si el valor es idéntico
                            System.out.println("--Código ya existente--");
                            codigoValido = false;
                        }
                    }
                }
            } while (!codigoValido);
            //una vez que la información es correcta la almacenamos en su lugar del array
            inventario[i][0] = codigoDispositivo;
            
            System.out.println("Introduzca el nombre del dispositivo:");
            nombreDispositivo = teclado.nextLine();
            inventario[i][1] = nombreDispositivo;
            
            do {
                System.out.println("Tipo (O->Ordenador/ R->Router/ M->Monitor/ I->Impresora):");
                tipoDispositivo = teclado.nextLine().toUpperCase();
                //usamos el metodo contains que devolvera true si la letra introducida por el usuario es una de las validas
                if ("ORMI".contains(tipoDispositivo) && tipoDispositivo.length()==1){//ademas forzamos que solo introduzca una letra estableciendo length = 1
                    tipoValido=true;
                }else {
                    System.out.println("--Tipo incorrecto--");
                    tipoValido=false;
                }
            }while (!tipoValido);
            inventario[i][2] = tipoDispositivo;
            
            do {
                System.out.println("Estado (D->Disponible/ R->Reparación/ V->Vendido)");
                estadoDispositivo = teclado.nextLine().toUpperCase();
                if ("DRV".contains(estadoDispositivo) && estadoDispositivo.length()==1){
                    estadoValido=true;
                }else {
                    System.out.println("--Estado incorrecto--");
                    estadoValido=false;
                }
            }while (!estadoValido);
            inventario[i][3] = estadoDispositivo;
            
            
            do {
                System.out.println("Precio: ");
                precioDispositivo = teclado.nextLine();
                Matcher coincidenciaPrecio = patronPrecio.matcher(precioDispositivo);
                if (coincidenciaPrecio.matches()){
                    precioDispositivo = precioDispositivo.replace(',', '.');
                    //reemplazamos con el metodo replace las comas(en caso de que las haya) por puntos para facilitar las operaciones con los precios mas adelante
                    precioValido=true;
                }else{
                    System.out.println("Error. Debes introducir un número válido. ");
                    precioValido=false;
                }
            }while (!precioValido);
            inventario[i][4] = precioDispositivo;

        }


        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------


        do{  //usamos un bucle do-while para que el menú de opciones del programa se repita hasta que el usuario seleccione la opcion Salir
            System.out.println();
            System.out.println("--- Menú de opciones ---");
            System.out.println("1. Mostrar inventario completo.");
            System.out.println("2. Buscar dispositivos por código.");
            System.out.println("3. Salir.");
            System.out.println("Seleccione una opción:");
            opcionMenu = teclado.nextInt();
            teclado.nextLine();//añado esta línea para que el enter que pulsamos al seleccionar la opción no se guarde en la memoria
        
            //vamos a usar un switch para que el programa haga una acción u otra dependiendo de la opción que elija el usuario
            switch (opcionMenu){
                case 1://INVENTARIO COMPLETO
                    System.out.println("--- INVENTARIO COMPLETO ---");
                    System.out.println();
                    //para dar formato a la tabla usaremos printf y alinearemos a la izquierda usando el simbolo -
                    System.out.printf("%-12s | %-15s | %-6s | %-7s | %s%n","CÓDIGO", "NOMBRE", "TIPO", "ESTADO", "PRECIO");
                    System.out.println("----------------------------------------------------------------");
                    //usamos un bucle for para imprimir toda la información de cada fila del array 
                    for (int i = 0; i < filasInventario; i++) {
                        //usamos como parametros del printf cada posición del array para mostrar la informacion de cada columna
                        System.out.printf("%-12s | %-15s | %-6s | %-7s | %.2f €%n",inventario[i][0],inventario[i][1],inventario[i][2],
                        inventario[i][3], Double.parseDouble(inventario[i][4])); 
                        //para el precio estoy usando una clase envoltorio para que devuelva un valor double y formatear con printf su salida con 2 decimales 
                    }
                    break;
                    
                case 2://BUSCAR DISPOSITIVO POR CODIGO
                    System.out.println("Introduzca el nombre del dispositivo para buscar su precio (DISP-XXXX):");
                    codigoBuscado= teclado.nextLine().toUpperCase();
                    //reiniciamos la variable codigoEncontrado para que no guarde resultados de otras busquedas
                    codigoEncontrado=false;
                    //usamos un bucle for para buscar en las filas del array
                    for (int i=0; i<filasInventario; i++){
                        //usamos de nuevo el metodo equals para comprobar si la información contenida en la primera columna de cada fila coincide con el codigo introducido
                        if (inventario[i][0].equals(codigoBuscado)) {
                            System.out.printf("PRECIO: %.2f €%n", Double.parseDouble(inventario[i][4]));
                            //de nuevo uso una clase envoltorio para mostrar la informacion de la 5 columna del array (el precio) como un double y formatearla con el printf con dos decimales
                            System.out.println(" ");
                            codigoEncontrado=true;
                            break;//vamos a usar usar un break para que pare de buscar cuando encuentre el codigo
                        } 
                    }
                    //imprimimos el mensaje si no encuentra el codigo (es importante hacerlo fuera del bucle porque sino imprimira el mensaje cuando no lo encuentre en cada fila)
                    if (!codigoEncontrado){  
                        System.out.println("--- No existe ningún dispositivo con ese código ---");
                        System.out.println(" ");
                    }
                        
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:    //añadimos la clausula default para cuando el usuario elija una opcion incorrecta, volviendo a mostrar el menú
                System.out.println("Opción no válida. Por favor, elige una opción correcta.");
            }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        } while (opcionMenu !=3); //el menú se seguirá repitiendo hasta que el usuario seleccione la opcion 3 Salir
    }
}
        
