package tarea06;

/**
 * Programa de pruebas del <b>ejercicio 01</b> de las clases <code>DipositivoVolador</code>, <code>DronReparto</code> y <code>DronCarreras</code>: 
 * Creación y consulta de objetos
 * 
 * @author profesorado
 */
public class TestEj01 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj01() {

    }

    /**
     * Método main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        // Cabecera de salida de las pruebas
        System.out.println("-----------------------------------------------");
        System.out.println("CASO DE PRUEBAS 01: CONSTRUCTORES Y ATRIBUTOS");
        System.out.println("-----------------------------------------------");
        
        
        System.out.println("------------------------------------");
        System.out.println(" - CONSULTA DE ATRIBUTOS PÚBLICOS");
        System.out.println("------------------------------------");
        // Se prueban los atributos públicos de la clase
        System.out.println(TestUtilidades.consultaAtributosPublicosDronCarreras());

        // Se prueban los constructores
        // Pruebas correctas (se crean varios objetos usando los distintos constructores)
        System.out.println("------------------------------------------------------------------");
        System.out.println(" - PRUEBA DEL CONSTRUCTOR DE TRES PARÁMETROS (con datos correctos)");
        System.out.println("------------------------------------------------------------------");

        DronReparto dronReparto1 = TestUtilidades.crearDronReparto("DR-01", "Combustion", 5);
        DronReparto dronReparto2= TestUtilidades.crearDronReparto("DR-02", "Electrico", 10);
        DronCarreras dronCarreras1 = TestUtilidades.crearDronCarreras("DC-01", "Combustion", 100);
        DronCarreras dronCarreras2 = TestUtilidades.crearDronCarreras("DC-02", "Electrico", 150);
        

        // Pruebas que deben lanzar excepciones
        // Pruebas incorrectas (se crean varios objetos usando el constructor)
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" - PRUEBA DEL CONSTRUCTOR DE TRES PARÁMETROS (con datos no válidos)");
        System.out.println("-------------------------------------------------------------------");

        // Se instancian varios objetos utilizando valores nulos en el constructor o la cadena vacÃ­a
        DronReparto dronReparto3 = TestUtilidades.crearDronReparto(null, "Combustion", 5);
        DronReparto dronReparto4= TestUtilidades.crearDronReparto("DR-02", "", 10);
        DronCarreras dronCarreras3 = TestUtilidades.crearDronCarreras("", "Combustion", 10);
        DronCarreras dronCarreras4 = TestUtilidades.crearDronCarreras("DC-02", null, 10);
        
    }
}