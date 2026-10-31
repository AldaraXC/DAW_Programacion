package tarea06;

// ------------------------------------------------------------
//                   Clase DronCarreras
// ------------------------------------------------------------
/**
* Clase que representa un dispositivo volador de tipo dron de carreras.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar la información
 * relativa al estado de los drones de carreras y su aceleración.
 * <p>
 * La clase también posee información general (estática), relativa a los
 * diferentes drones de carreras que existen, como la cantidad total de drones de carreras.
 * 
 * @author Aldara Maria Cabañas Cuevas
 */
public final class DronCarreras extends DispositivoVolador{
        

    // ------------------------------------------------------------------------
    // Atributos estáticos públicos (inmutables)
    // Pueden ser accedidos desde fuera de la clase
    // ------------------------------------------------------------------------
    /**
     * Factor de aceleración del dron de carreras: {@value FACTOR_ACELERACION}
     */
    public static final double FACTOR_ACELERACION = 1.5;
    
    // ------------------------------------------------------------------------
    // Atributo de objeto inmutable (privado)
    // Representa el estado del objeto pero no puede cambiar su valor
    // ------------------------------------------------------------------------
    /**Aceleración máxima del dron de carreras*/
    private final double aceleracionMaxima;
    
    // ------------------------------------------------------------------------
    // Atributo estático privado (mutable)
    // No depende de instancias de objetos particulares y sólo puede
    // modificarse desde la propia clase
    // ------------------------------------------------------------------------
    /**Cantidad total de drones de carreras creados*/
    private static int numDronesCarreras = 0;
    
    // =========================
    //     Constructor
    // =========================
    /**
     * Constructor de tres parámetros de la clase DronCarreras. 
     * Crea un objeto DronCarreras y almacena su modelo, tipo de motor y aceleración máxima.
     * 
     * @param modelo Modelo del dron de carreras.
     * @param tipoMotor Tipo de motor del dron de carreras.
     * @param aceleracionMaxima Aceleración máxima del dron de carreras.
     * 
     * @throws NullPointerException Si alguno de los parámetros es nulo
     * @throws IllegalArgumentException Si alguno de los dos parámetros no es válido
     */
    public DronCarreras (String modelo, String tipoMotor, double aceleracionMaxima) throws IllegalArgumentException{
        super (modelo, tipoMotor);
        
        //comprobamos que el parámetro introducido es correcto
        if (aceleracionMaxima < 0){
            throw new IllegalArgumentException("La aceleración máxima no puede ser negativa");
        }
        
        this.aceleracionMaxima = aceleracionMaxima;
        DronCarreras.numDronesCarreras ++;
    }
    
    // =========================
    //     Getters y Setters
    // =========================
    // Getters que consultan el estado en un momento dado
    /**
     * Método de consulta (getter) para obtener la aceleración máxima del dron de carreras.
     * @return Aceleración máxima. 
     */
        public double getAceleracionMaxima() {
        return this.aceleracionMaxima;
    }
    
    // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
    /**
     * Método de consulta (getter) para obtener el número total de drones de carreras creados.
     * @return Numero de drones de carreras creados. 
     */
        public static int getNumDronesCarreras() {
        return DronCarreras.numDronesCarreras;
    }
    
    //En este caso no tenemos setters ya que no hay ningún atributo que nosotros podamos cambiar una vez creado el objeto

    // =========================
    //      Métodos de acción
    // =========================
    /**
     * Método que realiza el cálculo del consumo del dron de carreras.
     * Recibe como parámetro un número entero que indica la distancia recorrida por el dron de carreras. 
     * Devuelve un número real que equivale al consumo del dron de carreras para dicha distancia.
     * 
     * @param distanciaRecorrida Distancia recorrida por el dron de carreras
     * 
     * @return double Consumo del dron.
     * 
     * @throws IllegalArgumentException Si la distancia recorrida es negativa
     * @throws IllegalStateException Si el tipo de motor del dispositivo es incorrecto
     */
    @Override
    public double calcularConsumo(int distanciaRecorrida) throws IllegalArgumentException, IllegalStateException {
        double consumo = super.calcularConsumo(distanciaRecorrida);
        return consumo + (this.getAceleracionMaxima() * DronCarreras.FACTOR_ACELERACION);
    }
    
    // =========================
    // Método Abstracto (sobrescrito)
    // =========================
    /**
     * Método para realizar el manteninimiento al dron de carreras.
     * 
     * Muestra por pantalla un mensaje con el modelo de dron y las tareas de mantenimiento que se están realizando.
     */
    @Override
    public void realizarMantenimiento(){
        System.out.printf("Realizando mantenimiento del dron con modelo %s: calibración de hélices, aerodinámica, motor...", 
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
        return String.format("%s, Aceleración máxima: %.2f",super.toString(), this.getAceleracionMaxima());
    }
    
}