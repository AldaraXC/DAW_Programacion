package tarea02;

/**
 *
 * @author Aldara Mª Cabañas Cuevas
 */
import java.util.Scanner;

public class Ejercicio02 {

/*ENUNCIADO
* Vamos a programar el sistema de control de una máquina expendedora de bebidas. 
* Para ello, la máquina informará al usuario de las bebidas de que dispone así como su precio 
* a través de un menú de opciones (de valores enteros). 
* Se solicita al usuario el número del menú correspondiente a la bebida elegida. 
*   - Debe existir una opción “0” para salir. Mostrando el mensaje de despedida 
*     "Gracias por usar la Máquina Expendedora. ¡Hasta luego!" y no haciendo nada más.
*   - Si la opción elegida por el usuario no es correcta se debe volver a 
*     mostrar el menú de opciones y solicitar una nueva opción.
*   - Si la  opción seleccionada es válida, el usuario introducirá una cantidad 
*     de dinero para realizar el pago de la bebida seleccionada. 
*       · Si la cantidad de dinero es inferior al precio se mostrará el mensaje: 
*         “Dinero insuficiente. Su dinero será devuelto.” y el programa finalizará.
*       · Si la cantidad de dinero es igual o superior al precio se calculará la diferencia 
*         entre la cantidad introducida y el precio de la bebida. Se informará del cambio 
*         devuelto y el programa finalizará. El cambio devuelto debe tener dos decimales 
*         obligatoriamente, pues representa euros y céntimos de euro.
*/
    public enum Bebidas {
        COCACOLA, PEPSI, AGUA, ZUMO, OTRO
    };

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        //primero he declarado como constantes los precios de las bebidas para calcular mas tarde el cambio que debe dar la máquina
        final double PRECIO_COCACOLA =1.50;
        final double PRECIO_PEPSI= 1.50;
        final double PRECIO_AGUA= 1.00;
        final double PRECIO_ZUMO= 2.00;
      
        //a continuación, declaramos las variables donde se guardarán la cantidad de dinero  que ingresará el usuario
        //y también la bebida que elegirá del menú principal
        double dineroIngresado;
        int bebidaElegida;
        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        
        //ahora declaramos la variable que nos dirá el cambio que se le devolverá al usuario
        double cambio;
        
        
        // Variables auxiliares
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        
        Scanner teclado = new Scanner(System.in);
        Bebidas miBebida = null;
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        System.out.println("Ejercicio 2: Máquina expendedora de Bebidas\n");
            System.out.println("----------------------------------------------------");      
            System.out.println(" ");
        
        /*En este caso voy a usar la estructura do - while ya que queremos que el menú se muestre por lo menos una vez
          para que el usuario elija una opción y que, si esta no es válida,el programa vuelva al principio y le muestre 
          el menú de opciones al usuario
            */    
        do {
            // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.
            //  En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla.
            
            //he intentado ahorrar algunas líneas de código en la impresión del menú
            //ya que más adelante voy a repetir algunas líneas
            System.out.println("Bienvenido a la Máquina Expendedora de Bebidas.");
            System.out.println("Por favor, seleccione una bebida: \n1. COCACOLA - 1.50€ \n2. PEPSI - 1.50€ \n3. AGUA - 1.00€ \n"
                    + "4. ZUMO de naranja - 2.00€ \n0. SALIR \n");
            System.out.println("Seleccione una opción: ");
                bebidaElegida = teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento y  Salida de resultados 
        //----------------------------------------------
        
        // Cuando haya introducido una opción válida, llevamos a cabo la acción oportuna
        //  -Si nos indica 'Salir', nos despedimos y terminamos
        //  -Si nos indica un producto
        //      -Decimos el producto seleccionado y su precio
        //      -Pedimos que introduzca el importe
        //          -Si el importe es suficiente
        //               -Imprimimos el producto obtenido (Equivale a la orden de suministrar el producto
        //               -Decimos el importe que ha sobrado
        //          -Si no, indicamos que el importe es insuficiente 
        
        
        /*para este programa he usado un switch ya que el usuario introduce un número del 0 al 4 para seleccionar su bebida
          el principal problema que he encontrado es la asignación del precio de cada bebida al pertenecer a la clase Enum
          ya que, al intentar asignarle un valor fuera del switch para intentar crear un bloque de codigo con la introduccion
          del dinero y la devolucion del cambio o mensaje de dinero insuficiente, la variable "precio" que había intentado crear
          se quedaba fuera del ámbito. Por esto he decidido meter todo el procesamiento (aunque repita líneas de codigo)
          dentro de cada opción del switch, ha sido la única forma que he encontrado de hacer que el programa hiciera todo lo requerido.
        */
            switch (bebidaElegida) {
                //vamos a ir creando los cases para cada opción
                case 1:
                    miBebida = Bebidas.COCACOLA; //la variable miBebida va a tomar un valor distinto dependiendo 
                    //del valor que introduzca el usuario
                    System.out.print("Ha seleccionado " + miBebida + ".");
                    //en los lugares donde haya que imprimir decimales vamos a usar printf
                    System.out.printf("El precio es de %.2f €.%n", PRECIO_COCACOLA);
                    System.out.println("Ingrese la cantidad de dinero en euros:");
                        dineroIngresado=teclado.nextDouble();
                    /*una vez introducido el dinero, vamos a usar la estructura if/else de la siguiente manera:
                      - primero haremos que evalúe si el dinero es suficiente, si no lo es mostrará el mensaje de 
                        dinero insuficiente y será el fin de programa
                      - si el dinero el suficiente inicializaremos la variable "cambio" y se ejecutarán los cálculos
                        de devolución del cambio, además de los mensajes de compra exitosa y despedida
                        */
                        if (dineroIngresado<PRECIO_COCACOLA)
                            System.out.println("Dinero insuficiente. Su dinero será devuelto");
                        else {
                            cambio=dineroIngresado-PRECIO_COCACOLA;
                            System.out.printf("Compra exitosa. Su cambio es %.2f €.%n", cambio);
                            System.out.println("¡Disfrute de su "+ miBebida +"!");
                        }
                    break;
                case 2:
                    miBebida = Bebidas.PEPSI;
                    System.out.print("Ha seleccionado " + miBebida + ".");
                    System.out.printf("El precio es de %.2f €.%n", PRECIO_PEPSI);
                    System.out.println("Ingrese la cantidad de dinero en euros:");
                        dineroIngresado=teclado.nextDouble();
                        if (dineroIngresado<PRECIO_PEPSI)
                            System.out.println("Dinero insuficiente. Su dinero será devuelto");
                        else {
                            cambio=dineroIngresado-PRECIO_PEPSI;
                            System.out.printf("Compra exitosa. Su cambio es %.2f €.%n", cambio);
                            System.out.println("¡Disfrute de su "+ miBebida +"!");
                        }
                    break;
                case 3:
                    miBebida = Bebidas.AGUA;
                    System.out.print("Ha seleccionado " + miBebida + ".");
                    System.out.printf("El precio es de %.2f €.%n", PRECIO_AGUA);
                    System.out.println("Ingrese la cantidad de dinero en euros:");
                        dineroIngresado=teclado.nextDouble();
                        if (dineroIngresado<PRECIO_AGUA)
                            System.out.println("Dinero insuficiente. Su dinero será devuelto");
                        else {
                            cambio=dineroIngresado-PRECIO_AGUA;
                            System.out.printf("Compra exitosa. Su cambio es %.2f €.%n", cambio);
                            System.out.println("¡Disfrute de su "+ miBebida +"!");
                        }
                    break;
                case 4:
                    miBebida = Bebidas.ZUMO;
                    System.out.print("Ha seleccionado " + miBebida + ".");
                    System.out.printf("El precio es de %.2f €.%n", PRECIO_ZUMO);
                    System.out.println("Ingrese la cantidad de dinero en euros:");
                        dineroIngresado=teclado.nextDouble();
                        if (dineroIngresado<PRECIO_ZUMO)
                            System.out.println("Dinero insuficiente. Su dinero será devuelto");
                        else {
                            cambio=dineroIngresado-PRECIO_ZUMO;
                            System.out.printf("Compra exitosa. Su cambio es %.2f €.%n", cambio);
                            System.out.println("¡Disfrute de su "+ miBebida +"!");
                        }
                    break;
                case 0:
                //este case será diferente, ya que lo usaremos para que el usuario pueda salir del programa
                // por lo que solo hay que mostrar un mensaje de despedida
                    miBebida = Bebidas.OTRO;
                    System.out.println("Gracias por usar la Máquina Expendedora. ¡Hasta luego!");
                    break;
                default:
                //por último vamos a usar default para mostrar un mensaje por consola en caso de que el usuario 
                //no introduzca una de las opciones válidas del switch
                    System.out.println("Opción no válida. Seleccione una bebida válida.");
                    System.out.println(" ");
            }
        
        /*Finalmente, en la parte del while estableceremos la condición para que el bucle se ejecute de nuevo
          que en este caso será usar cualquier numero entero que no sea ninguno de los contemplados en el switch (0-4.
          De esta forma, con el default que establecimos antes y esta condición del while conseguimos que si 
          el usuario no introduce una opción válida, el código se vuelva a ejecutar desde el principio volviendo
          a mostrar el menú.
        */
        } while (bebidaElegida>4);
    
    //en este caso no he podido usar una "salida de resultados" propiamente dicha, 
    //ya que he metido todo el procesamiento dentro del switch
        }
        //----------------------------------------------
        //             Salida de resultados 
        //----------------------------------------------
               
  
}

