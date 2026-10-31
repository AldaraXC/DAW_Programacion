package tarea06;

/**
 * Programa de pruebas del <b>ejercicio 02</b> de las clases <code>DipositivoVolador</code>, <code>DronReparto</code> y <code>DronCarreras</code>: 
 * Consulta de los atributos de objeto y de clase
 * 
 * @author profesorado
 */
public class TestEj02 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj02() {

    }

    /**
     * Método main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------------");
        System.out.println("CASO DE PRUEBAS 02: GETTERS Y MÉTODOS ESTÁTICOS");
        System.out.println("------------------------------------------------");

        // Se prueban los atributos públicos de la clase antes de crear los objetos
        System.out.println("--------------------------------------------------------");
        System.out.println(" CONSULTA DE ATRIBUTOS DE CLASE (antes de crear objetos)");
        System.out.println("--------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticosDronReparto());
        System.out.println(TestUtilidades.consultaAtributosEstaticosDronCarreras());

        // Se crea un objeto de tipo DronReparto
        // utilizando un método de pruebas de la clase TestUtilidades
        System.out.println("---------------------------------");
        System.out.println(" CREACIÓN DE UN DRONREPARTO DE PRUEBA ");
        System.out.println("---------------------------------");
        DronReparto dronReparto1 = TestUtilidades.crearDronReparto("DR-01", "Combustion", 5);
        
        // Se crea un objeto de tipo DronCarreras
        // utilizando un método de pruebas de la clase TestUtilidades
        System.out.println("---------------------------------");
        System.out.println(" CREACIÓN DE UN DRONCARREAS DE PRUEBA ");
        System.out.println("---------------------------------");
        DronCarreras dronCarreras1 = TestUtilidades.crearDronCarreras("DC-01", "Combustion", 100);
        
        System.out.println("----------------------------------");
        System.out.println(" CONSULTA DE LOS DATOS DEL DRONREPARTO ");
        System.out.println("----------------------------------");
        System.out.println(TestUtilidades.consultarAtributosDronReparto(dronReparto1));
        System.out.println("------------------------------------");
        System.out.println(" CONSULTA DE LOS DATOS DEL DRONCARREAS ");
        System.out.println("------------------------------------");
        System.out.println(TestUtilidades.consultarAtributosDronCarreras(dronCarreras1));
        
        
        // Se prueban los atributos públicos de la clase después de crear los objetos
        System.out.println("----------------------------------------------------------");
        System.out.println(" CONSULTA DE ATRIBUTOS DE CLASE (después de crear objetos)");
        System.out.println("----------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticosDronReparto());
        System.out.println(TestUtilidades.consultaAtributosEstaticosDronCarreras());
    }
}