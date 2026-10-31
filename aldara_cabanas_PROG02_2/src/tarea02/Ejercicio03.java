package tarea02;

import java.util.Scanner;

/**
 *
 * @author Aldara Mª Cabañas Cuevas
 */
public class Ejercicio03 {

/* ENUNCIADO
* Vamos a desarrollar una aplicación para simular formaciones militares para una legión 
* romana, donde automáticamente se  genere un gráfico con el número de soldados y el 
* tipo de formación que elija el usuario.
* Cuando empiece el programa se le darán las instrucciones al usuario y se solicitarán dos datos:
*   - Número de soldados: que debe ser al menos 1 (Se debe controlar que no se introduzcan 
*     valores negativos obviamente). En caso contrario se vuelve a pedir.
*   - Tipo de formación: Debe ser  “LINEA”, “CUADRADO” o “TRIANGULO” (El programa debe ignorar 
*     las mayúsculas y minúsculas). Se recomienda no introducir tildes en la entrada de datos. 
*     Si no es una de ellas se indicará "Opción NO CORRECTA" y finalizará el programa. 
    */
    public static void main(String args[]) {
        //----------------------------------------------
        //               Declaración de variables y constantes
        //----------------------------------------------
        
        final String ASTERISCO="* "; //imprime un asterisco
        final String ESPACIO=" ";   //imprime espacio en blanco
        int numSoldados;            //almacena el numero de soldados que introducirá el usuario
        double raizCuadrada;        //declaramos la variable raizCuadrada que usaremos para construir la formacion cuadrado
        int raizCuadradaEntera;     //raiz cuadrada convertida a int
        int soldadosSobrantes;      //variable para calcular los soldados que sobran
        int filaSoldados;           //variable que contiene la formula para poder crear la formacion triangulo
        int contadorSoldados= 0;       //usaremos esta variable para poder calcular si sobran soldados en la formacion triangulo
        String tipoFormacion;           //almacena el tipo de formación seleccionada
        Scanner teclado = new Scanner(System.in);// Clase Scanner para petición de datos al usuario a través del teclado
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio03: Formación romana a partir de un número de soldados.");
        System.out.println("----------------------------------------------------------------");
        // Bloque 1. Solicitud del número de soldados
        // Validación de entrada: Deberíamos comprobar que es mayor o igual que uno. En caso contrario volvemos solicitar el número de soldados
        // Se supone que nos introducen un número entero. En caso que no sea así saltará una excepción, cuyo tratamiento veremos en uinidades posteriores
        
        //vamos a usar un bucle do-while para que el programa muestre el mensaje de peticion de un numero al usuario
        //y que en caso de que el numero no sea mayor que cero vuelva a pedirle otro numero valido
        do {
            System.out.println("Introduce el número de elementos de la formación (debe ser mayor que 0):");
            numSoldados=teclado.nextInt();
        }while (numSoldados<1);
        // 
        // Bloque 2. Solicitud del tipo de formación. 
        // Indicaremos que tiene que ser LINEA, CUADRADO o TRIANGULO
        // Leemos una cadena, puede que no sea una de las anteriores.
            System.out.println("Ahora introduce el tipo de formación (LINEA, CUADRADO O TRIANGULO):");
            tipoFormacion=teclado.next();
            //pasaremos a mayusculas la variable tipoFormacion para que no de error si el usuario introduce la palabra en minuscula
            //y para que el resultado se imprima en mayuscula despues
            tipoFormacion=tipoFormacion.toUpperCase();
            
         //--------------------------------------------------------------
        //             Procesamiento y salida de resultados
        //---------------------------------------------------------------
          
            
            //ahora estableceremos la condicion para que si el usuario introduce una opcion válida, esta se imprima, y si introduce una que
            //no lo es, le aparezca un mensaje indicando que no es correcta y finalice el programa
            if (tipoFormacion.equals("LINEA") || tipoFormacion.equals("CUADRADO")|| tipoFormacion.equals("TRIANGULO"))
                System.out.println(tipoFormacion);
            else  
                System.out.println("Opción NO CORRECTA.");
            
            //ahora vemos a ir construyendo las formaciones. Usaremos estructuras if/else con bucles for dentro
            if (tipoFormacion.equals("LINEA")){
                for (int i=0 ; i<numSoldados ; i++)
                    System.out.print(ASTERISCO);
                System.out.println();
            }
            else if (tipoFormacion.equals("CUADRADO")){
                raizCuadrada=Math.sqrt(numSoldados);//calculamos la raiz cuadrada del numero que nos ha dado el usuario
                raizCuadradaEntera=(int)raizCuadrada;// esta variable contendrá la conversion a tipo int de la raiz cuadrada 
                for  (int j=0 ; j<raizCuadradaEntera ; j++){  //aquí usaremos dos bucles, uno para crear una fila de asteriscos y otro para repetirla el numero de veces que necesitamos
                    for (int k=0 ; k<raizCuadradaEntera ; k++){
                        System.out.print(ASTERISCO);
                    }
                    System.out.println();
                }
                //a continuacion, calcularemos si sobran  soldados y añadiremos una impresión por pantalla en el caso de que sobren
                soldadosSobrantes= numSoldados % (raizCuadradaEntera*raizCuadradaEntera);
                if (soldadosSobrantes != 0)
                System.out.println("De los "+numSoldados+" asignados, una vez hecha la mayor formación posible del tipo indicado, sobran "+soldadosSobrantes+" soldados.");
            }
            else if (tipoFormacion.equals("TRIANGULO")){
                //primero inicializaremos la variable con la formula que se nos da en el ejercicio y 
                //hacemos la conversion a int, ya que Math.sqrt devuelve un tipo double
                filaSoldados= (int)((Math.sqrt(1+8*numSoldados)-1)/2) ; 
                for  (int l=filaSoldados ; l>=0 ; l--){  
                    //bucle para imprimir los espacios en blanco
                    for (int espacioBlanco = 0; espacioBlanco <(filaSoldados - l) + 1; espacioBlanco++) {
                        System.out.print(ESPACIO);
                    }
                    //bucle para imprimir los asteriscos
                    for (int m = 0; m<l; m++) {
                        System.out.print(ASTERISCO);
                        contadorSoldados++;
                    }
                    System.out.println();
                }
                //ahora calcularemos si sobran  soldados y añadiremos una impresión por pantalla si sobran
                soldadosSobrantes= numSoldados-contadorSoldados;
                if (soldadosSobrantes != 0)
                System.out.println("De los "+numSoldados+" asignados, una vez hecha la mayor formación posible del tipo indicado, sobran "+soldadosSobrantes+" soldados.");
            } 
    }
}
              //----------------------------------------------
              //              Salida de resultados 
              //----------------------------------------------

               //----------------------------------------------
