package tarea06;

/**
 * Programa de pruebas del <b>ejercicio 03</b> de las clases <code>DipositivoVolador</code>, <code>DronReparto</code> y <code>DronCarreras</code>: 
 * Prueba de los métodos de acción
 * 
 * @author profesorado
 */
public class TestEj03 {
     /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj03 ()
    {
        
    }    
    
    /**
     * Método main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main (String[] args)
    {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------");
        System.out.println("CASO DE PRUEBAS 03: MÉTODOS DE ACCIÓN");
        System.out.println("------------------------------------------");
        
        // Se crea dos drones de prueba de cada tipo
        DronReparto dronReparto1 = TestUtilidades.crearDronReparto("DR-01", "Combustion", 5);
        DronReparto dronReparto2= TestUtilidades.crearDronReparto("DR-02", "Electrico", 10);
        DronCarreras dronCarreras1 = TestUtilidades.crearDronCarreras("DC-01", "Combustion", 100);
        DronCarreras dronCarreras2 = TestUtilidades.crearDronCarreras("DC-02", "Electrico", 150);
        
        // Se realizan pruebas correctas (probando la operativa de calcular consumo)
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (calcular consumo con datos correctos)    ");
        System.out.println("---------------------------------------------------------------------------");
        
        // Calculamos el consumo para todos los drones con una distancia recorrida de 100
        System.out.println("Calculando consumo para una distancia recorrida de 100...");
        TestUtilidades.pruebaMetodoCalcularConsumoDronReparto(dronReparto1, 100);
        TestUtilidades.pruebaMetodoCalcularConsumoDronReparto(dronReparto2, 100);
        TestUtilidades.pruebaMetodoCalcularConsumoDronCarreras(dronCarreras1, 100);
        TestUtilidades.pruebaMetodoCalcularConsumoDronCarreras(dronCarreras2, 100);
        
        // Se realizan pruebas incorrectas (probando la operativa de calcular consumo)
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (calcular consumo con datos erróneos)    ");
        System.out.println("---------------------------------------------------------------------------");
        
        // Calculamos el consumo para todos los drones con una distancia recorrida de -75
        System.out.println("Calculando consumo para una distancia recorrida de -75...");
        TestUtilidades.pruebaMetodoCalcularConsumoDronReparto(dronReparto1, -75);
        
        System.out.println("\n---------------------------------------------------------------");
        System.out.println(" - CONSULTA DE ATRIBUTOS DEL DRONREPARTO (antes de cargar)" );
        System.out.println("---------------------------------------------------------------");
        System.out.println(TestUtilidades.consultarAtributosDronReparto(dronReparto1));
        
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (cargar dron de reparto con datos correctos)    ");
        System.out.println("---------------------------------------------------------------------------");
        TestUtilidades.pruebaMetodoCargarDronReparto(dronReparto1, 3);
        
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (cargar dron de reparto con datos incorrectos)    ");
        System.out.println("---------------------------------------------------------------------------");
        TestUtilidades.pruebaMetodoCargarDronReparto(dronReparto1, -2); // - Excepcion IllegalArgumentException
        TestUtilidades.pruebaMetodoCargarDronReparto(dronReparto1, 30); // - Excepcion IllegalStateException
        
        System.out.println("\n---------------------------------------------------------------");
        System.out.println(" - CONSULTA DE ATRIBUTOS DEL DRONREPARTO (después de cargar)" );
        System.out.println("---------------------------------------------------------------");
        System.out.println(TestUtilidades.consultarAtributosDronReparto(dronReparto1));
        
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (el dron de reparto reparte con datos correctos)    ");
        System.out.println("---------------------------------------------------------------------------");
        TestUtilidades.pruebaMetodoRepartirDronReparto(dronReparto1, 2);
        
        System.out.println("---------------------------------------------------------------");
        System.out.println(" - CONSULTA DE ATRIBUTOS DEL DRONREPARTO (después de repartir)" );
        System.out.println("---------------------------------------------------------------");
        System.out.println(TestUtilidades.consultarAtributosDronReparto(dronReparto1));
        
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" - USO DE LOS MÉTODOS DE ACCIÓN (el dron de reparto reparte con datos incorrectos)    ");
        System.out.println("---------------------------------------------------------------------------");
        TestUtilidades.pruebaMetodoRepartirDronReparto(dronReparto1, -2); // - Excepcion IllegalArgumentException
        TestUtilidades.pruebaMetodoRepartirDronReparto(dronReparto1, 4); // - Excepcion IllegalStateException
        
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println(" - PRUEBA DEL MÉTODO ABSTRACTO PARA PROBAR LA LIGADURA DINÁMICA         ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("-> Realizando el mantenimiento de un DronReparto...");
        dronReparto1.realizarMantenimiento();
        System.out.println("\n-> Realizando el mantenimiento de un DronCarreras...");
        dronCarreras1.realizarMantenimiento();
    }
}