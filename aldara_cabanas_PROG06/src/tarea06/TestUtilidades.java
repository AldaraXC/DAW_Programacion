package tarea06;

/**
 * Clase de utilidades necesaria para la realizacion de las pruebas escritas en
 * las clases <b>TestEj01</b>, <b>TestEj02</b>, <b>TestEj03</b>,
 * <b>TestEj04</b>, <b>TestEj05</b> y <b>TestEj06</b>
 *
 * @author profesorado
 */
public class TestUtilidades {

    /**
     * Se crea un constructor privado para evitar que la clase pueda
     * instanciarse
     */
    private TestUtilidades() {

    }

    /**
     * Método de consulta del atributo estático de la clase DronReparto.
     *
     * @return String Consulta del atributo estático de la clase DronReparto
     */
    public static String consultaAtributosEstaticosDronReparto() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> Número de drones de reparto creados: %d\n", DronReparto.getNumDronesReparto()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta del atributo estático de la clase DronCarreras.
     *
     * @return String Consulta del atributo estático de la clase DronCarreras
     */
    public static String consultaAtributosEstaticosDronCarreras() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> Número de drones de carreras creados: %d\n", DronCarreras.getNumDronesCarreras()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta del atributo público de la clase DronCarreras
     *
     * @return String Consulta del atributo público de la clase DronCarreras
     */
    public static String consultaAtributosPublicosDronCarreras() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> Factor de aceleración: %s\n", DronCarreras.FACTOR_ACELERACION));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos privados del objeto de la clase DronReparto
     *
     * @param dronReparto DronReparto sobre el que se consultan sus atributos
     * @return String Consulta de atributos privados del objeto de la clase DronReparto
     */
    public static String consultarAtributosDronReparto(DronReparto dronReparto) {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();

        // Ahora se lee el valor de cada getter() del dispositivo
        consulta.append("Leyendo los datos almacenados en el dron de reparto...\n");
        consulta.append(String.format(" -> Capacidad máxima del dron de reparto: %s\n", dronReparto.getCapacidadMaxima()));
        consulta.append(String.format(" -> Capacidad actual del dron de reparto: %d\n", dronReparto.getCapacidad()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos privados del objeto de la clase DronCarreras
     *
     * @param dronCarreras DronCarreras sobre el que se consultan sus atributos
     * @return String Consulta de atributos privados del objeto de la clase DronCarreras
     */
    public static String consultarAtributosDronCarreras(DronCarreras dronCarreras) {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();

        // Ahora se lee el valor de cada getter() del dispositivo
        consulta.append("Leyendo los datos almacenados en el dron de carreras...\n");
        consulta.append(String.format(" -> Aceleración máxima del dron de carreras: %s\n", dronCarreras.getAceleracionMaxima()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Crea un DronReparto usando el constructor de tres parámetros
     *
     * @param modelo modelo del dron: "D-01", "H-02"
     * @param tipoMotor tipo de motor del dron: "Electrico", "Combustion" o "Hibrido"
     * @param capacidadMaxima número máximo de paquetes que puede soportar el dron
     *
     * @throws NullPointerException Si alguno de los parámetros es nulo
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     *
     * @return String Consulta de atributos públicos de la clase
     */
    public static DronReparto crearDronReparto(String modelo, String tipoMotor, int capacidadMaxima) throws IllegalArgumentException, NullPointerException {
        // Se crea un objeto de tipo DronReparto
        DronReparto dronReparto = null;
        try {
            System.out.printf("Creando un DronReparto con los parámetros [%s,%s,%d]...\n", modelo, tipoMotor, capacidadMaxima);
            dronReparto = new DronReparto(modelo, tipoMotor, capacidadMaxima);
            System.out.println(" -> Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna el dron de reparto creado
        return dronReparto;
    }

    /**
     * Crea un DronCarreras usando el constructor de tres parámetros
     *
     * @param modelo modelo del dron: "D-01", "H-02"
     * @param tipoMotor tipo de motor del dron: "Electrico", "Combustion" o "Hibrido"
     * @param aceleracionMaxima aceleración máxima que puede soportar el dron
     *
     * @throws NullPointerException Si alguno de los parámetros es nulo
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     *
     * @return String Consulta de atributos públicos de la clase
     */
    public static DronCarreras crearDronCarreras(String modelo, String tipoMotor, int aceleracionMaxima) throws IllegalArgumentException, NullPointerException {
        // Se crea un objeto de tipo DronCarreras
        DronCarreras dronCarreras = null;
        try {
            System.out.printf("Creando un DronCarreras con los parámetros [%s,%s,%d]...\n", modelo, tipoMotor, aceleracionMaxima);
            dronCarreras = new DronCarreras(modelo, tipoMotor, aceleracionMaxima);
            System.out.println(" -> Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna el dron de carreras creado
        return dronCarreras;
    }
    
    /**
     * Realiza una prueba del método de calcularConsumo del DronReparto controlando
     * las excepciones
     *
     * @param dronReparto dron (DronReparto)
     * @param distanciaRecorrida distancia recorrida por el dron de reparto
     *
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     * @throws NullPointerException Si alguno de los parámetros es nulo
     */
    public static void pruebaMetodoCalcularConsumoDronReparto(DronReparto dronReparto, int distanciaRecorrida) throws IllegalArgumentException, IllegalStateException {
        // Testea el método de calcular consumo y captura las excepciones
        try {
            System.out.printf(" -> El DronReparto %s consume %.2f\n", dronReparto.getModelo(), dronReparto.calcularConsumo(distanciaRecorrida));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }
    }

    /**
     * Realiza una prueba del método de calcularConsumo del DronCarreras controlando
     * las excepciones
     *
     * @param dronCarreras dron (DronCarreras)
     * @param distanciaRecorrida distancia recorrida por el dron de carreras
     *
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     * @throws NullPointerException Si alguno de los parámetros es nulo
     */
    public static void pruebaMetodoCalcularConsumoDronCarreras(DronCarreras dronCarreras, int distanciaRecorrida) throws IllegalArgumentException, IllegalStateException {
        // Testea el método de calcular consumo y captura las excepciones
        try {
            System.out.printf(" -> El DronCarreras %s consume %.2f\n", dronCarreras.getModelo(), dronCarreras.calcularConsumo(distanciaRecorrida));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }
    }
    
    /**
     * Realiza una prueba del método de cargar el dron de reparto controlando
     * las excepciones
     * 
     * @param dronReparto dron (DronReparto)
     * @param numPaquetes numero de paquetes a cargar
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     * @throws IllegalStateException Si se quieren cargar más paquetes de la capacidad máxima del dron
     */
    public static void pruebaMetodoCargarDronReparto(DronReparto dronReparto, int numPaquetes) throws IllegalArgumentException, IllegalStateException {
        // Testea el método de calcular consumo y captura las excepciones
        try {
            System.out.printf("Cargando DronReparto %s con %d paquetes...\n", dronReparto.getModelo(), numPaquetes);
            dronReparto.cargar(numPaquetes);
            System.out.println(" -> DronReparto cargado con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }
    }
    
    /**
     * Realiza una prueba del método de repartir el dron de reparto controlando
     * las excepciones
     * 
     * @param dronReparto dron (DronReparto)
     * @param numPaquetes numero de paquetes a repartir
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     * @throws IllegalStateException Si se quieren repartir más paquetes de los disponibles
     */
    public static void pruebaMetodoRepartirDronReparto(DronReparto dronReparto, int numPaquetes) throws IllegalArgumentException, IllegalStateException {
        // Testea el método de calcular consumo y captura las excepciones
        try {
            System.out.printf("El DronReparto %s reparte %d paquetes...\n", dronReparto.getModelo(), numPaquetes);
            dronReparto.repartir(numPaquetes);
            System.out.println(" -> DronReparto ha repartido con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }
    }

}