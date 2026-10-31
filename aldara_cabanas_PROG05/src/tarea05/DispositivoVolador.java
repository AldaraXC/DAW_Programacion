package tarea05;

// ------------------------------------------------------------
//                   Clase DispositivoVolador
// ------------------------------------------------------------
/**
* Clase que representa un dispositivo que tiene la capacidad de volar.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar la información
 * relativa al estado del dispositivo y la información de su desplazamiento.
 * <p>
 * La clase también posee información general (estática), relativa a los
 * diferentes dispositivos que existen, como la cantidad total de dispositivos.
 * 
 * @author Aldara Maria Cabañas Cuevas
 */
public class DispositivoVolador {
   
    // ------------------------------------------------------------------------
    // Atributos estáticos públicos (inmutables)
    // Pueden ser accedidos desde cualquier caso
    // ------------------------------------------------------------------------
    
    /**
     * Altitud máxima permitida para los dispositivos en metros: {@value ALTITUD_MAXIMA}.
     */
    public static final double ALTITUD_MAXIMA = 50.0;
    
    /**
     * Rango de operación del dispositivo: {@value RANGO_OPERACION}.
     */
    public static final int RANGO_OPERACION = 100;
    
    /**
     * Modelo por defecto del dispositivo: {@value MODELO_DEFECTO}.
     */
    public static final String MODELO_DEFECTO = "Dispositivo Generico";
    
    /**
     * Tipo de motor por defecto del dispositivo: {@value TIPO_MOTOR_DEFECTO}.
     */
    public static final String TIPO_MOTOR_DEFECTO = "Electrico";
    
    
    // ------------------------------------------------------------------------
    // Atributos estáticos privados (mutables)
    // No dependen de instancias de objetos particulares y sólo pueden 
    // modificarse desde la propia clase
    // ------------------------------------------------------------------------
    
    /**Cantidad total de dispositivos creados*/
    private static int numDispositivos = 0;

    // ------------------------------------------------------------------------
    // Atributos de objeto inmutables (privados)
    // Representan el estado del objeto pero no pueden cambiar su valor
    // ------------------------------------------------------------------------
    
    /**Modelo del dispositivo*/
    private final String modelo;
    
    /** Tipo de motor.
     * Posibles valores: Electrico, Combustion o Hibrido
     */
    private final String tipoMotor;
    
    // ------------------------------------------------------------------------
    // Atributos de objeto variables (privados)
    // Representan el estado del objeto y pueden cambiar su valor
    // ------------------------------------------------------------------------
    private double altitudActual;
    private int posicionEjeX;
    private int posicionEjeY;

    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------
    // Constructor con dos parámetros
    
    /**
     * Constructor de dos parámetros de la clase DispositivoVolador. 
     * Crea un objeto DispositivoVolador y almacena su modelo y tipo de motor.
     * 
     * @param modelo Modelo del dispositivo.
     * @param tipoMotor Tipo de motor del dispositivo.
     * 
     * @throws NullPointerException Si alguno de los dos parámetros es nulo
     * @throws IllegalArgumentException Si alguno de los dos parámetros no es válido
     */
    public DispositivoVolador(String modelo, String tipoMotor) throws NullPointerException, IllegalArgumentException {
        if (modelo == null){
            throw new NullPointerException("El modelo del dispositivo no puede ser nulo.");
        }
        if (modelo.equals("")) {
            throw new IllegalArgumentException("El modelo del dispositivo no puede estar vacío.");
        }
        if (tipoMotor == null){
            throw new NullPointerException("El tipo de motor no puede ser nulo.");
        }
        if (tipoMotor.equals("")) {
            throw new IllegalArgumentException("El tipo de motor no puede estar vacío.");
        }
        
        //Asignamos el valor de los atributos
        this.modelo = modelo;
        
        //Con un if-else controlamos que se introduzca el tipo de motor adecuado y sino se asigne el tipo de motor por defecto
        if (tipoMotor.equals("Electrico") || tipoMotor.equals("Combustion") || tipoMotor.equals("Hibrido")){
            this.tipoMotor = tipoMotor;
        } else {
            this.tipoMotor = DispositivoVolador.TIPO_MOTOR_DEFECTO;
        }
        //Inicializamos a 0 el resto de atributos
        this.altitudActual = 0.0;
        this.posicionEjeX = 0;
        this.posicionEjeY = 0;
        
        //Incrementamos el contador de dispositivos creados
        DispositivoVolador.numDispositivos++;
    } 
    
    // Constructor por defecto
    
    /**
     * Constructor sin parámetros de la clase DispositivoVolador. 
     * Crea un objeto DispositivoVolador con el modelo y el tipo de motor por defecto.
     */
    public DispositivoVolador(){
        //llamamos al constructor mas completo para que haga las comprobaciones y asigne los valores usando this()
        this(DispositivoVolador.MODELO_DEFECTO, DispositivoVolador.TIPO_MOTOR_DEFECTO);
    }
    
    
    // Método fábrica
    
    /**
     * Método fábrica de la clase DispositivoVolador. 
     * Crea un array de objetos DispositivoVolador con sus valores por defecto.
     * 
     * @param cantidad Número de dispositivos voladores que se van a crear.
     * @return Array de dispositivos voladores.
     * 
     * @throws IllegalArgumentException Si la cantidad no es válida
     */
    public static DispositivoVolador[] crearArrayDispositivos(int cantidad) throws IllegalArgumentException {
        //Comprobamos que la cantidad es correcta
        if (cantidad < 1 || cantidad > 20) {
            throw new IllegalArgumentException("Número de dispositivos incorrecto: "+ cantidad +". Debe ser mayor o igual que 1 y menor o igual que 20.");
        }
        //Creamos el array de dispositivos
        DispositivoVolador[] arrayDispositivosVoladores = new DispositivoVolador[cantidad];
        //Usamos un bucle for para recorrer el array introduciendo la información
        for (int i = 0; i < arrayDispositivosVoladores.length; i++) {
            //Usamos el constructor por defecto para crear cada dispositivo
            arrayDispositivosVoladores[i] = new DispositivoVolador();
        }
        return arrayDispositivosVoladores;
    }
   
    
    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------
    // Getters que consultan el estado en un momento dado
    
    /**
     * Método de consulta (getter) para obtener el modelo del dispositivo.
     * @return Modelo del dispositivo. 
     */
    public String getModelo() {
        return this.modelo;
    }
    
    /**
     * Método de consulta (getter) para obtener el tipo de motor del dispositivo.
     * @return Tipo de motor del dispositivo. 
     */
    public String getTipoMotor() {
        return this.tipoMotor;
    }
    
    /**
     * Método de consulta (getter) para obtener la altitud actual del dispositivo.
     * @return Altitud actual del dispositivo.
     */
    public double getAltitudActual() {
        return this.altitudActual;
    }
    
    /**
     * Método de consulta (getter) para obtener la posición en el eje X del dispositivo.
     * @return Posición en el eje X del dispositivo.
     */
    public int getPosicionX() {
        return this.posicionEjeX;
    }
    
    /**
     * Método de consulta (getter) para obtener la posición en el eje Y del dispositivo.
     * @return Posición en el eje Y del dispositivo.
     */
    public int getPosicionY() {
        return this.posicionEjeY;
    }
    
    
    // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
    
    /**
     * Método de consulta (getter) para obtener el atributo estático de la clase numDispositivos.
     * @return Número de dispositivos creados hasta el momento.
     */
    public static int getNumDispositivos() {
        return DispositivoVolador.numDispositivos;
    }  
    
    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------
    
    /**
     * Método que modifica la altitud actual del dispositivo.
     * @param altitudActual Nueva altitud a la que vuela el dispositivo.
     */
    public void setAltitudActual(double altitudActual) {
        //Si la altitud introducida excede el mínimo o el máximo permitido asignamos el valor inicial
        if (altitudActual < 0 || altitudActual > DispositivoVolador.ALTITUD_MAXIMA){
            this.altitudActual = 0.0;
        } else { //Si la altitud introducida es correcta asignamos dicho valor al atributo
            this.altitudActual = altitudActual;
        }
    }
    
    /**
     * Método que modifica la posición en el eje X del dispositivo.
     * @param posicionEjeX Nueva posición en el eje X del dispositivo.
     */
    public void setPosicionX(int posicionEjeX) {
        //Si la posición introducida excede el limite del rango permitido (- por la izquierda o + por la derecha) asignamos el valor inicial
        if (posicionEjeX < -(DispositivoVolador.RANGO_OPERACION) || posicionEjeX > DispositivoVolador.RANGO_OPERACION){
            this.posicionEjeX = 0;
        } else { //Si la posición introducida es correcta asignamos dicho valor al atributo
            this.posicionEjeX = posicionEjeX;
        }
    }
    
    /**
     * Método que modifica la posición en el eje Y del dispositivo.
     * @param posicionEjeY Nueva posición en el eje Y del dispositivo.
     */
    public void setPosicionY(int posicionEjeY) {
        //Si la posición introducida excede el limite del rango permitido (- hacia detrás o + hacia delante) asignamos el valor inicial
        if (posicionEjeY < -(DispositivoVolador.RANGO_OPERACION) || posicionEjeY > DispositivoVolador.RANGO_OPERACION){
            this.posicionEjeY = 0;
        } else { //Si la posición introducida es correcta asignamos dicho valor al atributo
            this.posicionEjeY = posicionEjeY;
        }
    }
    
    
    // ------------------------------------------------------------------------
    // Métodos de acción (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------
    
    /**
     * Método que realiza el desplazamiento del dispositivo.
     * Recibe dos parámetros que corresponderán al número de posiciones que se quiere desplazar el dispositivo en el eje X y el eje Y.
     * 
     * @param desplazamientoEjeX Desplazamiento de posiciones del dispositivo en el eje X.
     * @param desplazamientoEjeY Desplazamiento de posiciones del dispositivo en el eje Y.
     * 
     * @throws IllegalStateException Si el dispositivo se intenta desplazar fuera de su rango de operación en cualquier eje.
     */
    public void desplazar(int desplazamientoEjeX, int desplazamientoEjeY) throws IllegalStateException{
        //Primero vamos a sumar el desplazamiento a la posición anterior y vamos a almacenarla en dos variables auxiliares
        int nuevaPosicionX = this.posicionEjeX + desplazamientoEjeX;
        int nuevaPosicionY = this.posicionEjeY + desplazamientoEjeY;
        
        //Comprobamos si la nueva posición X es válida (si no lo es lanzamos la excepción)
        if (nuevaPosicionX < -(DispositivoVolador.RANGO_OPERACION) || nuevaPosicionX > DispositivoVolador.RANGO_OPERACION){
            throw new IllegalStateException("El dispositivo se ha intentado desplazar fuera de su rango de operación en el eje X.");
        }
        
        //Comprobamos si la nueva posición Y es válida (si no lo es lanzamos la excepción)
        if (nuevaPosicionY < -(DispositivoVolador.RANGO_OPERACION) || nuevaPosicionY > DispositivoVolador.RANGO_OPERACION){
            throw new IllegalStateException("El dispositivo se ha intentado desplazar fuera de su rango de operación en el eje Y.");
        }
        
        //Si las nuevas posiciones son correctas asignamos el nuevo valor a los atributos
        this.posicionEjeX = nuevaPosicionX;
        this.posicionEjeY = nuevaPosicionY;
    }
    
    
    /**
     * Método que realiza el cálculo del consumo del dispositivo.
     * Recibe como parámetro un número entero que indica la distancia recorrida por el dispositivo. 
     * Devuelve un número real que equivale al consumo del dispositivo para dicha distancia.
     * 
     * @param distanciaRecorrida Distancia recorrida por el dispositivo
     * 
     * @return double Consumo del dispositivo.
     * 
     * @throws IllegalArgumentException Si la distancia recorrida es negativa
     * @throws IllegalStateException Si el tipo de motor del dispositivo es incorrecto
     */
    public double calcularConsumo(int distanciaRecorrida) throws IllegalArgumentException, IllegalStateException{
        //Comprobamos que la distancia introducida no es negativa
        if (distanciaRecorrida < 0){
            throw new IllegalArgumentException("La distancia recorrida no puede ser negativa.");
        }
        
        //Ahora calculamos el consumo según el tipo de motor usando if else anidados y lo guardamos en la variable que almacena el resultado
        double consumo;
        if (this.tipoMotor.equals("Electrico")){
            consumo = distanciaRecorrida * 1.2;
        } else if (this.tipoMotor.equals("Combustion")){
            consumo = distanciaRecorrida * 2.0;
        } else if (this.tipoMotor.equals("Hibrido")){
            consumo = distanciaRecorrida * 1.5;
        } else {
            throw new IllegalStateException("Tipo de motor incorrecto.");
        }
        
        return consumo;
    }
    
    
    
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------
    
    /**
     * Devuelve una cadena formateada que representa el estado del objeto.
     *
     * @return String Estado del objeto
     */
    @Override
    public String toString() {
        return String.format("[Modelo=%s, Tipo de motor=%s, Altitud=%.2f metros, Posicion en X=%d, Posicion en Y=%d]",
                this.getModelo(),this.getTipoMotor(),this.getAltitudActual(),this.getPosicionX(),this.getPosicionY()
        );
    }
    
}