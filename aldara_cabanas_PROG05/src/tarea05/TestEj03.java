package tarea05;

/**
 * Programa de pruebas del <b>ejercicio 03</b> para la clase <code>DispositivoVolador</code>.
 * @author profesorado
 */
public class TestEj03 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj03() {

    }

    /**
     * MÃ©todo main del programa de pruebas
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        // Cabecera de salida de las pruebas
        System.out.println("------------------------------------------------");
        System.out.println("CASO DE PRUEBAS 03: GETTERS Y MÉTODOS ESTÁTICOS");
        System.out.println("------------------------------------------------");

        // Se prueban los atributos públicos de la clase antes de crear las dispositivos
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - ATRIBUTOS PÚBLICOS (antes de crear objetos)  ");
        System.out.println("------------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticos());

        // Se crean varios objetos de tipo DispositivoVolador almacenados en un array
        // utilizando un método de pruebas de la clase TestUtilidades (por defecto, crea 5 dispositivos de ejemplo).
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 02 - Creación de objetos y uso de getters()       ");
        System.out.println("------------------------------------------------------------");
        DispositivoVolador[] arrayDispositivos5 = TestUtilidades.crearArrayDispositivosDatosPrueba();
        System.out.println("Array de dispositivos creado con éxito\n");

        // Se leen los atributos de cada dispositivo usando los getter() pertinentes
        TestUtilidades.consultarAtributosArrayDispositivos(arrayDispositivos5);

        // Se prueban los atributos públicos de la clase después de crear los dispositivos
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 03 - ATRIBUTOS PÚBLICOS (después de crear objetos)");
        System.out.println("------------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticos());
    }
}
