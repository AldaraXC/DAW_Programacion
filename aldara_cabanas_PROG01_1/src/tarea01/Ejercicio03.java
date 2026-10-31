package tarea01;

import java.util.Scanner;

/**
 * Ejercicio 3. Validación de contraseñas.
 *
 * @author Cabañas Cuevas Aldara María
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        String password; //variable que almacena la contraseña introducida por el usuario
        
        // Variables de salida
        String validezPassword; //variable que almacena el resultado de evaluar las condiciones anidadas
        
        // Variables auxiliares
        int ultimaLetra; 
        //voy a usar esta variable para obtener el número de índice de la última letra de la contraseña introducida
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALIDACIÓN DE CONTRASEÑAS");
        System.out.println("-------------------------");
        

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        System.out.print("Introduzca la contraseña: ");
        //vamos a usar el método toUpperCase para pasar la contraseña introducida a minúsculas 
        //directamente, ya que para el ejercicio no es necesario diferenciar entre mayúsculas y minúsculas
        password = teclado.nextLine().toLowerCase(); 
        
        // Cálculo de información auxiliar previa
        
        //primero voy inicializar la variable usando el método length y restando uno, ya que los índices
        //empiezan a contar desde 0
        ultimaLetra = password.length()-1;
        
        // Comprobamos si tiene como mínimo 12 caracteres
        
        //ahora vamos a usar varios ternarios anidados para ir comprobando si la contraseña reune los requisitos
        //primero vamos a usar el método length para ver el número de caracteres. 
        //Si es mayor que 12 pasaremos al siguiente ternario anidado
        
        validezPassword = (password.length()<12)
                ? "NO VÁLIDA."
                
        
        // Comprobamos si comienza por una vocal (mayúscula o minúscula)
                
                //para comprobar si empieza por vocal vamos a usar el método charAt con el parámetro 0, que será la primera letra de la contraseña
                //usaremos el operador lógico && para indicar que si la primera letra no es ninguna de las vocales, la contraseña no será válida, 
                //pero si lo es, pasaremos a la siguiente condición a evaluar
                : ((password.charAt(0)!= 'a') && (password.charAt(0)!= 'e') 
                && (password.charAt(0)!= 'i') && (password.charAt(0)!= 'o')
                && (password.charAt(0)!= 'u'))
                    ? "NO VÁLIDA."
        
        // Comprobamos si termina con una consonante (mayúscula o minúscula)
                
                //para comprobar si acaba en consonante vamos a usar de nuevo el método charAt, pero esta vez el parámetro será el valor de la variable ultimaLetra
                //usaremos el operador lógico || para indicar que si la ultima letra es una de las 5 vocales la contraseña no será valida
                //en caso contrario pasaremos a la última condición
                    : ((password.charAt(ultimaLetra)== 'a') || (password.charAt(ultimaLetra)== 'e') 
                    || (password.charAt(ultimaLetra)== 'i') || (password.charAt(ultimaLetra)== 'o')
                    || (password.charAt(ultimaLetra)== 'u'))
                        ? "NO VÁLIDA."
        
        // Comprobamos si contiene al menos uno de los caracteres especiales requeridos
                
                //por último vamos a usar el método contains para ver si la contraseña contiene alguno de los 5 símbolos requeridos usando de nuevo el operador lógico ||
                        :(password.contains("@") || password.contains("#") || password.contains("_")
                        || password.contains(".")|| password.contains(";"))
                            ? "VÁLIDA"
                            : "NO VÁLIDA.";
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        //por último concatenamos el texto que sacaremos al final por pantalla con el valor que ha tomado la variable 
        //después de evaluar las diferentes condiciones según la contraseña introducida
        System.out.println("La contraseña es "+ validezPassword);
    }
}
