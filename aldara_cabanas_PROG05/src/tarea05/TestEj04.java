package tarea05;

/**
 * Programa de pruebas del <b>ejercicio 04</b>  de la clase <code>DispositivoVolador</code>.
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
     * Método main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main (String[] args)
    {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------------");
        System.out.println("CASO DE PRUEBAS 04: MÉTODOS DE ACCIÓN");
        System.out.println("------------------------------------------------");
        
        // Se crean tres dispositivos de prueba
        DispositivoVolador dispositivo1 = TestUtilidades.crearDispositivo("D-01", "Electrico");
        DispositivoVolador dispositivo2 = TestUtilidades.crearDispositivo("D-02", "Combustion");
        DispositivoVolador dispositivo3 = TestUtilidades.crearDispositivo("H-01", "Hibrido");
        
        // Se realizan pruebas correctas probando la operativa de desplazamiento
        System.out.println("\n----------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - Uso correcto del método de acción desplazar()");
        System.out.println("------------------------------------------------------------");
        
        // Se consultan los datos registrados en el dispositivo antes del desplazamiento
        System.out.println(TestUtilidades.consultarAtributosDispositivoVolador(dispositivo1));
        
        // El dispositivo se desplaza hacia adelante 10 posiciones en el eje X y 20 en el eje Y
        TestUtilidades.pruebaMetodoDesplazar(dispositivo1, 10, 20);
        System.out.println(" -> El dispositivo " + dispositivo1.getModelo()+ " se ha desplazado hacia adelante 10 posiciones en el eje X y 20 en el eje Y\n");
        
        // Se consultan los datos registrados en el dispositivo tras el primer desplazamiento
        System.out.println(TestUtilidades.consultarAtributosDispositivoVolador(dispositivo1));
        
        // El dispositivo se desplaza hacia detrás 5 posiciones en el eje X y 5 en el eje Y
        TestUtilidades.pruebaMetodoDesplazar(dispositivo1, -5, -5);
        System.out.println(" -> El dispositivo " + dispositivo1.getModelo()+ " se ha desplazado hacia detrás 5 posiciones en el eje X y 5 en el eje Y\n");
        
        // Se consultan los datos registrados en el dispositivo tras el segundo desplazamiento
        System.out.println(TestUtilidades.consultarAtributosDispositivoVolador(dispositivo1));
                
        // Se realizan pruebas que generan excepciones (operaciones no permitidas o llenado de registros)
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" - PRUEBA 02 - Uso incorrecto del método de acción desplazar()");
        System.out.println("-------------------------------------------------------------------");
        
        // El dispositivo se desplaza hacia adelante 500 posiciones en el eje X y 20 en el eje Y
        System.out.println("El dispositivo " + dispositivo1.getModelo()+ " se va a intentar desplazar hacia delante 500 posiciones en el eje X y 20 en el eje Y");
        TestUtilidades.pruebaMetodoDesplazar(dispositivo1, 500, 20);
                
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println(" - PRUEBA 03 - Uso correcto del método de acción calcularConsumo()" );
        System.out.println("-----------------------------------------------------------------------");
        
        System.out.println("Calculando consumos para una distancia recorrida de 100 posiciones");
        System.out.printf(" -> El consumo del dispositivo " + dispositivo1.getModelo()+ " es %.2f\n",TestUtilidades.pruebaMetodoCalcularConsumo(dispositivo1, 100));
        System.out.printf(" -> El consumo del dispositivo " + dispositivo2.getModelo()+ " es %.2f\n",TestUtilidades.pruebaMetodoCalcularConsumo(dispositivo2, 100));
        System.out.printf(" -> El consumo del dispositivo " + dispositivo3.getModelo()+ " es %.2f\n",TestUtilidades.pruebaMetodoCalcularConsumo(dispositivo3, 100));
   
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println(" - PRUEBA 04 - Uso incorrecto del método de acción calcularConsumo()" );
        System.out.println("-----------------------------------------------------------------------");
        
        System.out.println("Intentando calcular el consumo del dispositivo " + dispositivo1.getModelo()+ " para una distancia recorrida negativa...");
        TestUtilidades.pruebaMetodoCalcularConsumo(dispositivo3, -1);
    }
}
