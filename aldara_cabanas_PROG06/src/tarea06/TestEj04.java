package tarea06;

/**
 * Programa de pruebas del <b>ejercicio 04</b> de las clases <code>DipositivoVolador</code>, <code>DronReparto</code> y <code>DronCarreras</code>: 
 * Método toString
 * 
 * @author profesorado
 */
public class TestEj04 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj04 ()
    {
        
    }    
    
    /**
     * Metodo main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main (String[] args)
    {
        // Cabecera de salida de las pruebas
        System.out.println("--------------------------------------");
        System.out.println("CASO DE PRUEBAS 04: MÉTODO toString()   ");
        System.out.println("--------------------------------------");
        
        // Se crea dos de drones de prueba de cada tipo
        DronReparto dronReparto1 = TestUtilidades.crearDronReparto("DR-01", "Combustion", 5);
        DronCarreras dronCarreras1 = TestUtilidades.crearDronCarreras("DC-01", "Hibrido", 100);
        
        System.out.println("----------------------------------------------------");
        System.out.println(" - PRUEBAS PARA VISUALIZAR EL ESTADO DE LOS OBJETOS ");
        System.out.println("----------------------------------------------------");
        
        // Se imprime el estado inicial del DronReparto y del DronCarreras
        System.out.println("Obteniendo los datos del DronReparto...");
        System.out.println(dronReparto1.toString() + "\n");
        
        System.out.println("Obteniendo los datos del DronCarreras...");
        System.out.println(dronCarreras1.toString() + "\n");
        
        // Se realizan algunas operaciones básicas para leer el nuevo estado del DronReparto
        // El DronReparto carga 4 paquetes
        TestUtilidades.pruebaMetodoCargarDronReparto(dronReparto1, 4);
        
        // Se imprime el nuevo estado del DronReparto
        System.out.println("Obteniendo los datos del DronReparto...");
        System.out.println(dronReparto1.toString() + "\n");
        
        // Se modifican algunos parámetros de estado de los objetos
        System.out.println("Cambiando posición en el eje X del DronReparto a 10...");
        dronReparto1.setPosicionX(10);
        System.out.println("Cambiando posición en el eje Y del DronReparto a 20...");
        dronReparto1.setPosicionY(20);
        System.out.println("Cambiando altitud del DronReparto a 30.00...\n");
        dronReparto1.setAltitudActual(30.00);
        
        System.out.println("Cambiando posición en el eje X del DronCarreras a 15...");
        dronCarreras1.setPosicionX(15);
        System.out.println("Cambiando posición en el eje Y del DronCarreras a 5...");
        dronCarreras1.setPosicionY(5);
        System.out.println("Cambiando altitud del DronCarreras a 15.00...\n");
        dronCarreras1.setAltitudActual(15.00);

        // Se imprime el estado final del DronReparto y del DronCarreras
        System.out.println("Obteniendo los datos del DronReparto...");
        System.out.println(dronReparto1.toString() + "\n");
        
        System.out.println("Obteniendo los datos del DronCarreras...");
        System.out.println(dronCarreras1.toString() + "\n");
    }
}