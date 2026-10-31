package tarea05;

/**
 * Programa de pruebas de los <b>ejercicios 01</b> y <b>02</b> para la clase <code>DispositivoVolador</code>.
 * @author profesorado
 */
public class TestEj0102 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj0102() {

    }

    /**
     * MÃ©todo main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------------");
        System.out.println("CASO DE PRUEBAS 01-02: CONSTRUCTORES Y ATRIBUTOS");
        System.out.println("------------------------------------------------");

        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - ATRIBUTOS PÚBLICOS                           ");
        System.out.println("------------------------------------------------------------");
        // Se prueban los atributos públicos de la clase
        System.out.println(TestUtilidades.consultaAtributosPublicos());

        // Se prueban los constructores y el método fábrica
        // Pruebas correctas (se crean varios objetos usando los distintos constructores y el método fábrica)
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 02 - CONSTRUCTORES Y FÁBRICA (con datos correctos)");
        System.out.println("------------------------------------------------------------");
        // Se instancian varios dispositivos utilizando valores correctos
        DispositivoVolador dispositivo1 = TestUtilidades.crearDispositivo("D-01", "Combustion");
        DispositivoVolador dispositivo2 = TestUtilidades.crearDispositivo();
        System.out.println();

        // Se utilia el método fábrica especificando cantidades correctas
        DispositivoVolador[] arrayDispositivos1 = TestUtilidades.crearArrayDispositivos(1);  // Se prueban los valores límite
        DispositivoVolador[] arrayDispositivos2 = TestUtilidades.crearArrayDispositivos(20); // Se prueban los valores límite
        System.out.println();

        // Pruebas que deben lanzar excepciones
        // Pruebas incorrectas (se crean varios objetos usando los distintos constructores y el método fábrica)
        System.out.println("--------------------------------------------------------");
        System.out.println(" - PRUEBA 03 - CONSTRUCTORES Y FÁBRICA (con excepciones)");
        System.out.println("--------------------------------------------------------");
        // Se instancian varios dispositivos utilizando valores nulos en el constructor o la cadena vací­a
        DispositivoVolador dispositivo3 = TestUtilidades.crearDispositivo(null, "Combustion");
        DispositivoVolador dispositivo4 = TestUtilidades.crearDispositivo("H-01", "");

        System.out.println();
        
        // Se utilia el método fábrica especificando cantidades incorrectas (negativas, y valores lí­mite)
        DispositivoVolador[] arrayDispositivos3 = TestUtilidades.crearArrayDispositivos(-1); // Se prueban los valores límite
        DispositivoVolador[] arrayDispositivos4 = TestUtilidades.crearArrayDispositivos(50); // Se prueban los valores límite
        System.out.println();
    }
}
