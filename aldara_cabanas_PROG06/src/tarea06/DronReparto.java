package tarea06;

// ------------------------------------------------------------
//                   Clase DronReparto
// ------------------------------------------------------------
/**
* Clase que representa un dispositivo volador de tipo dron de reparto.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar la información
 * relativa al estado de los drones de reparto y su capacidad para transportar paquetes.
 * <p>
 * La clase también posee información general (estática), relativa a los
 * diferentes drones de reparto que existen, como la cantidad total de drones de reparto.
 * 
 * @author Aldara Maria Cabañas Cuevas
 */
public final class DronReparto extends DispositivoVolador implements Repartible{

    // ------------------------------------------------------------------------
    // Atributo de objeto inmutable (privado)
    // Representa el estado del objeto pero no puede cambiar su valor
    // ------------------------------------------------------------------------
    /**Capacidad máxima del dron de reparto*/
    private final int capacidadMaxima;
    
    // ------------------------------------------------------------------------
    // Atributo de objeto variable (privado)
    // Representa el estado del objeto y puede cambiar su valor
    // ------------------------------------------------------------------------
    /**Capacidad actual del dron de reparto*/
    private int capacidadActual;
    
    // ------------------------------------------------------------------------
    // Atributo estático privado (mutable)
    // No depende de instancias de objetos particulares y sólo puede
    // modificarse desde la propia clase
    // ------------------------------------------------------------------------
    /**Cantidad total de drones de reparto creados*/
    private static int numDronesReparto = 0;
    
    // =========================
    //     Constructor
    // =========================
    /**
     * Constructor de tres parámetros de la clase DronReparto. 
     * Crea un objeto DronReparto y almacena su modelo, tipo de motor y capacidad máxima (en paquetes).
     * 
     * @param modelo Modelo del dron de reparto.
     * @param tipoMotor Tipo de motor del dron de reparto.
     * @param capacidadMaxima Capacidad máxima del dron de reparto
     * 
     * @throws NullPointerException Si alguno de los parámetros es nulo
     * @throws IllegalArgumentException Si alguno de los dos parámetros no es válido
     */
    public DronReparto (String modelo, String tipoMotor, int capacidadMaxima) throws IllegalArgumentException{
        super (modelo, tipoMotor);
        
        //comprobamos que el parámetro introducido es correcto
        if (capacidadMaxima < 0){ 
            throw new IllegalArgumentException("La capacidad máxima no puede ser negativa");
        }
        
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = 0;
        DronReparto.numDronesReparto ++;
    }
    

    // =========================
    //     Getters y Setters
    // =========================
    // Getters que consultan el estado en un momento dado
    /**
     * Método de consulta (getter) para obtener la capacidad máxima del dron de reparto.
     * @return Capacidad máxima. 
     */
        public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
        
    /**
     * Método de consulta (getter) para obtener la capacidad actual del dron de reparto.
     * @return Capacidad actual. 
     */
        public int getCapacidad() {
        return this.capacidadActual;
    }
    
    // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
    /**
     * Método de consulta (getter) para obtener el número total de drones de reparto creados.
     * @return Numero de drones de reparto creados. 
     */
        public static int getNumDronesReparto() {
        return DronReparto.numDronesReparto;
    }
    
    // Setters que modifican el estado del objeto
    /**
     * Método que modifica la capacidad actual del dron de reparto.
     * @param capacidadActual Nueva capacidad del dron de reparto.
     */
    public void setCapacidad(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    // =========================
    //      Métodos de acción
    // =========================
    /**
     * Método que realiza el desplazamiento del dron de reparto.
     * Recibe dos parámetros que corresponderán al número de posiciones que se quiere desplazar el dron de reparto en el eje X y el eje Y.
     * 
     * @param desplazamientoEjeX Desplazamiento de posiciones del dron de reparto en el eje X.
     * @param desplazamientoEjeY Desplazamiento de posiciones del dispositivo en el eje Y.
     * 
     * @throws IllegalStateException Si el dron de reparto se intenta desplazar fuera de su rango de operación en cualquier eje.
     */
    @Override
    public void desplazar(int desplazamientoEjeX, int desplazamientoEjeY) throws IllegalStateException{
        //comprobamos que el dron de reparto lleva carga
        if (this.getCapacidad() < 1){
            throw new IllegalStateException("El dron de reparto no se puede desplazar ya que no tiene carga.");
        } else {
            super.desplazar(desplazamientoEjeX, desplazamientoEjeY);
        }
        
    }
    
    
    /**
     * Método que realiza la carga del objeto.
     * Recibe por parámetro el número de paquetes a cargar.
     * 
     * @param numPaquetesCarga Número de paquetes que se van a cargar.
     * 
     * @throws IllegalArgumentException Si se intenta cargar el dron con una cantidad inferior a la mínima requerida.
     * @throws IllegalStateException Si se intenta cargar el dron por encima de su capacidad máxima.
     */
    @Override
    public void cargar(int numPaquetesCarga) throws IllegalArgumentException, IllegalStateException{
        //primero comprobamos si los datos introducidos son correctos para lanzar las excepciones
        if (numPaquetesCarga < 1){
            throw new IllegalArgumentException("No se puede cargar: El mínimo de paquetes a cargar es 1.");
        }
        //comprobamos que la suma de los paquetes que se quieren cargar más los que ya tiene no exceden la capacidad máxima
        if ((numPaquetesCarga + this.getCapacidad()) > this.getCapacidadMaxima()){
            throw new IllegalStateException("No se puede cargar: Se excede la capacidad máxima del dron.");
        }
        
        //sumamos los paquetes que ya tenía el dron a los que se quieren cargar y establecemos la nueva cantidad como cantidad actual con el método setCapacidad
        this.setCapacidad(this.getCapacidad() + numPaquetesCarga);
    }
    
    
    /**
     * Método para realizar el reparto de los paquetes cargados en el dron.
     * Recibe por parámetro el número de paquetes a repartir.
     * 
     * @param numPaquetesReparto Número de paquetes que se van a repartir.
     * 
     * @throws IllegalArgumentException Si se intenta repartir menos de un paquete.
     * @throws IllegalStateException Si se intenta repartir más paquetes de los disponibles.
     */
     @Override
    public void repartir(int numPaquetesReparto) throws IllegalArgumentException, IllegalStateException{
        //primero comprobamos si los datos introducidos son correctos para lanzar las excepciones
        if (numPaquetesReparto < 1){
            throw new IllegalArgumentException("No se puede repartir: El mínimo de paquetes a repartir es 1.");
        }
        //comprobamos que la suma de los paquetes que se quieren cargar más los que ya tiene no exceden la capacidad máxima
        if (numPaquetesReparto > this.getCapacidad()){
            throw new IllegalStateException("No se puede repartir: Se quieren repartir más paquetes de los disponibles.");
        }
        
        //restamos los paquetes a repartir a los que ya tenía el dron y establecemos la nueva cantidad como cantidad actual con el método setCapacidad
        this.setCapacidad(this.getCapacidad() - numPaquetesReparto);
    }
    
    // =========================
    // Método Abstracto (sobrescrito)
    // =========================
    /**
     * Método para realizar el manteninimiento al dron de reparto.
     * 
     * Muestra por pantalla un mensaje con el modelo de dron y las tareas de mantenimiento que se están realizando.
     */
    @Override
    public void realizarMantenimiento(){
        System.out.printf("Realizando mantenimiento del dron con modelo %s: revisión de garras, compartimiento, estabilidad...", 
                super.getModelo());
    }
    
    // =========================
    //      Método toString()
    // =========================
    /**
     * Devuelve una cadena formateada que representa el estado del objeto.
     *
     * @return String Estado del objeto
     */
    @Override
    public String toString() {
        return String.format("%s, Capacidad: %d",super.toString(), this.getCapacidad());
    }
    
}