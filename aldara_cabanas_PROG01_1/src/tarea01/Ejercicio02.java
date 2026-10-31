
package tarea01;

/**
 * Ejercicio 2. Operaciones con constantes y variables.
 *
 * @author Cabañas Cuevas Aldara María
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //---------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final double CONSTANTE1 = 80.3;
        final int CONSTANTE2 = 3;

        // Variables de entrada
        
        // Variables de salida
        
        // Variables auxiliares
        boolean valorBool;
        byte enteroByte;
        short enteroShort;
        int enteroInt, producto;
        long enteroLong;
        double decimalDoble;
        float decimalSimple;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay entrada de datos
        System.out.println("OPERACIONES CON CONSTANTES Y VARIABLES.");
        System.out.println("---------------------------------------");
        System.out.println(" ");

        //----------------------------------------------
        //     Procesamiento 
        //----------------------------------------------
        
        //----------------------------------------------
        // Ejemplos que se proporcionan como modelo:
        
        // Las variables booleanas solo pueden tener los valores true o false
        // valorBool = 0;
        
        // decimalSimple = 9.9 * 4.6;       
        // SOLUCIÓN: CASTING EXPLÍCITO
        decimalSimple = (float) (9.9 * 4.6);

        // CASTING IMPLÍCITO: de tipo char a tipo int
        enteroInt = 'a';
        //----------------------------------------------
        
        //los decimales se escriben con coma ',' al introducirlos por consola en el codigo usamos el punto '.'
        decimalDoble = 5.17;
        
        enteroLong = 25_369L;

        //como producto es tipo int y estamos usando un long (que reserva más espacio de memoria) en la operación
        //Java indica que al hacer la conversión implícita de long a int se puede perder información
        //se puede forzar una conversión explícita a int para que deje de dar error pero perderemos la parte decimal
        producto =  (int) enteroLong * enteroInt;

        //el valor de un boolean solo puede ser true o false
        valorBool = (97 == 'a' == 97);
        

        //como es una constante que ya está inicializada al principio no se puede modificar su valor
        CONSTANTE1 = 100.3;

        //conversión impícita de tipo char a float
        decimalSimple = 'c';

        decimalDoble = 3.2 * 4.7;

        //aunque está resuelto al principio también podemos solucionarlo añadiendo la f después de cada valor
        //ya que Java toma los decimales como double por defecto si esa f no aparece
        decimalSimple = 9.9f * 4.6f;
        
        //de nuevo el error está en que se intenta guardar un resultado tipo double (que reserva más espacio) en 
        //una variable tipo int. Podemos forzar la conversión explícita a int para que deje de dar error pero perdemos la parte decimal
        producto = (int) CONSTANTE1 * CONSTANTE2;

        //conversión implícita de float a double
        decimalDoble = 5.67F;

        //conversión implícita de int a double. Si no ponemos parte decimal Java toma ese valor como int por defecto
        decimalDoble = 8;

        enteroInt = 1 / 2;
    }
}
