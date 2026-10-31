package tarea05;

/**
 * Clase de utilidades necesaria para la realización de las pruebas escritas
 * en las clases <b>TestEj0102</b>, <b>TestEj03</b> , <b>TestEj04</b>  
 * y <b>TestEj05</b>.
 * @author profesorado
 */
public class TestUtilidades {

    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestUtilidades() {

    }

    /**
     * Método de consulta de atributos estáticos de la clase
     *
     * @return String Consulta de atributos estáticos de la clase
     */
    public static String consultaAtributosEstaticos() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> numDispositivos: %d\n", DispositivoVolador.getNumDispositivos()));
        
        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos públicos de la clase
     *
     * @return String Consulta de atributos públicos de la clase
     */
    public static String consultaAtributosPublicos() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> MODELO_DEFECTO: %s\n", DispositivoVolador.MODELO_DEFECTO));
        consulta.append(String.format(" -> TIPO_MOTOR_DEFECTO: %s\n", DispositivoVolador.TIPO_MOTOR_DEFECTO));
        consulta.append(String.format(" -> ALTITUD_MAXIMA: %s\n", DispositivoVolador.ALTITUD_MAXIMA));
        consulta.append(String.format(" -> RANGO_OPERACION: %d\n", DispositivoVolador.RANGO_OPERACION));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos públicos de la clase
     *
     * @param dispositivo DispositivoVolador
     * @return String Consulta de atributos públicos de la clase
     */
    public static String consultarAtributosDispositivoVolador(DispositivoVolador dispositivo) {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();

        // Ahora se lee el valor de cada getter() del dispositivo
        consulta.append("Leyendo los datos almacenados en el DispositivoVolador\n");
        consulta.append(String.format(" -> getModelo(): %s\n", dispositivo.getModelo()));
        consulta.append(String.format(" -> getTipoMotor(): %s\n", dispositivo.getTipoMotor()));
        consulta.append(String.format(" -> getAltitudActual(): %s\n", dispositivo.getAltitudActual()));
        consulta.append(String.format(" -> getPosicionX(): %s\n", dispositivo.getPosicionX()));
        consulta.append(String.format(" -> getPosicionY(): %s\n", dispositivo.getPosicionY()));
        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Lee los datos de un array de dispositivos y los imprime por pantalla
     *
     * @param arrayDispositivos Array de dispositivos
     */
    public static void consultarAtributosArrayDispositivos(DispositivoVolador[] arrayDispositivos) {
        // Se leen los datos de cada dispositivo y se muestran por pantalla
        for (DispositivoVolador disp : arrayDispositivos) {
            System.out.println(TestUtilidades.consultarAtributosDispositivoVolador(disp));
        }
    }

    /**
     * Crea un DispositivoVolador para un dispositivo usando el constructor de dos parámetros
     * 
     * @param modelo Modelo del dispositivo
     * @param tipoMotor tipoMotor del dispositivo
     * @return String Consulta de atributos públicos de la clase
     */
    public static DispositivoVolador crearDispositivo(String modelo, String tipoMotor) {
        // Se crea un objeto de tipo DispositivoVolador y se capturan las excepciones producidas
        DispositivoVolador dispositivo = null;
        try {
            System.out.printf("Registrando un DispositivoVolador para el dispositivo [%s,%s]", modelo, tipoMotor);
            dispositivo = new DispositivoVolador(modelo, tipoMotor);
            System.out.println("\n -> Objeto creado con éxito");
        } catch (NullPointerException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se devuelve el dispositivo creado
        return dispositivo;
    }


    /**
     * Crea un DispositivoVolador para un dispositivo usando el constructor sin parámetros
     * 
     * @return String Consulta de atributos públicos de la clase
     */
    public static DispositivoVolador crearDispositivo() {
        // Se crea un objeto de tipo DispositivoVolador
        DispositivoVolador dispositivo = null;
        try {
            System.out.printf("Registrando un DispositivoVolador para un dispositivo con los parámetros por defecto");
            dispositivo = new DispositivoVolador();
            System.out.println("\n -> Objeto creado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se devuelve el dispositivo creado
        return dispositivo;
    }

    /**
     * Crea un array de dispositivos con los datos por defecto usando el método fábrica
     * 
     * @param cantidad Indica la cantidad de dispositivos a crear en el array
     * @return arrayDispositivos Array de dispositivos
     */
    public static DispositivoVolador[] crearArrayDispositivos(int cantidad) {
        // Se crea un objeto de tipo array para almacenar los dispositivos
        DispositivoVolador[] arrayDispositivos = null;
        try {
            System.out.printf("Intentando crear array de %d objetos.\n", cantidad);
            arrayDispositivos = DispositivoVolador.crearArrayDispositivos(cantidad);
            System.out.println(" -> Array de objetos creado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna el array creado
        return arrayDispositivos;
    }

    /**
     * Crea un array de dispositivos con datos de prueba
     *
     * @return ComputadorVuelo Array de dispositivos
     */
    public static DispositivoVolador[] crearArrayDispositivosDatosPrueba() {
        // Se crea un array de dispositivos vací­o
        DispositivoVolador[] arrayDispositivos = new DispositivoVolador[3];

        // Se crean 5 dispositivos de ejemplo con datos usando el constructor de 2 parámetros
        arrayDispositivos[0] = TestUtilidades.crearDispositivo("D-01", "Electrico");
        arrayDispositivos[1] = TestUtilidades.crearDispositivo("H-01", "Combustion");
        arrayDispositivos[2] = TestUtilidades.crearDispositivo("D-02", "Hibrido");

        // Se devuelve el array de dispositivos
        return arrayDispositivos;
    }
    
    /**
     * Realiza una prueba del método de desplazar del DispositivoVolador controlando las excepciones
     *
     * @param dispositivo Dispositivo (DispositivoVolador)
     * @param desplazamientoX Desplazamiento en el eje X
     * @param desplazamientoY Desplazamiento en el eje Y
     */
    public static void pruebaMetodoDesplazar(DispositivoVolador dispositivo, int desplazamientoX, int desplazamientoY)
    {
        // Testea el método de desplazar y captura las excepciones
        try {
            dispositivo.desplazar(desplazamientoX, desplazamientoY);
        } catch (IllegalStateException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }
    }
    
    /**
     * Realiza una prueba del método calcularConsumo del DispositivoVolador controlando las excepciones
     *
     * @param dispositivo Dispositivo (DispositivoVolador)
     * @param distanciaRecorrida Distancia para calcular el consumo
     * @return Consumo del dispositivo
     */
    public static double pruebaMetodoCalcularConsumo(DispositivoVolador dispositivo, int distanciaRecorrida)
    {
        double resultado = -1;
        try {
            resultado = dispositivo.calcularConsumo(distanciaRecorrida);
        } catch (IllegalStateException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }
        return resultado;
    }
}
