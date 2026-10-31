
package tarea05;

/**
 * Programa de pruebas del <b>ejercicio 05</b>  de la clase <code>DispositivoVolador</code>.
 * @author profesorado
 */
public class TestEj05 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj05 ()
    {
        
    }    
    
    /**
     * Método main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main (String[] args)
    {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------------");
        System.out.println("CASO DE PRUEBAS 05: método toString()           ");
        System.out.println("----------------------------------------------\n");
        
        // Se crea un dispositivo de prueba
        DispositivoVolador dispositivo = TestUtilidades.crearDispositivo("D-01", "Electrico");
        
        System.out.println("\n----------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - Visualización del estado del objeto          ");
        System.out.println("------------------------------------------------------------");
        
        // Se muestra el estado inicial del dispositivo
        System.out.println(" -> El dispositivo " + dispositivo.getModelo()+ " tiene los siguientes datos iniciales");
        System.out.printf("Datos del dispositivo " + dispositivo.getModelo()+ ":  %s\n\n" , dispositivo.toString());
        
        // Se realizan algunas operaciones básicas para leer el estado del dispositivo

        // El dispositivo se desplaza hacia adelante 50 posiciones en el eje X y 50 en el eje Y
        System.out.println(" -> El dispositivo " + dispositivo.getModelo()+ " se ha desplazado hacia adelante 50 posiciones en el eje X y 50 en el eje Y");
        TestUtilidades.pruebaMetodoDesplazar(dispositivo, 50, 50);
        
        // Se muestra el estado del dispositivo tras el desplazamiento
        System.out.printf("Datos del dispositivo " + dispositivo.getModelo()+ ":  %s\n\n" , dispositivo.toString());
        
        // El dispositivo modifica correctamente su altitud actual, posición en el eje X y posición en el eje Y
        System.out.println(" -> El dispositivo " + dispositivo.getModelo()+ " modifica su altitud actual a 25 metros y su posicion en el eje X a 15 y en el eje Y a 35");
        dispositivo.setAltitudActual(25);
        dispositivo.setPosicionX(15);
        dispositivo.setPosicionY(35);
        
        // Se muestra el estado del dispositivo tras dichas modificaciones correctas
        System.out.printf("Datos del dispositivo " + dispositivo.getModelo()+ ":  %s\n\n" , dispositivo.toString());
        
        // El dispositivo modifica incorrectamente su altitud actual, posición en el eje X y posición en el eje Y
        System.out.println(" -> El dispositivo " + dispositivo.getModelo()+ " intenta establecer su altitud actual a 250 metros y su posicion en el eje X a 300 y en el eje Y a -1000");
        dispositivo.setAltitudActual(250);
        dispositivo.setPosicionX(300);
        dispositivo.setPosicionY(-1000);
        
        // Se muestra el estado del dispositivo tras dichas modificaciones incorrectas
        System.out.printf("Datos del dispositivo " + dispositivo.getModelo()+ ":  %s\n\n" , dispositivo.toString());   
    }
}