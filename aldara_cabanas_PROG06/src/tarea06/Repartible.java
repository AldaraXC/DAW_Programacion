package tarea06;

/**
 * Interfaz que ofrece a un objeto la capacidad de cargar y repartir paquetes.
 * 
 * @author Aldara María Cabañas Cuevas
 */
public interface Repartible {
    /**
     * Método que realiza la carga del objeto.
     * Recibe por parámetro el número de paquetes a cargar.
     * 
     * @param numPaquetesCarga Número de paquetes que se van a cargar.
     * 
     * @throws IllegalArgumentException Si se intenta cargar el dron con una cantidad inferior a la mínima requerida.
     * @throws IllegalStateException Si se intenta cargar el dron por encima de su capacidad máxima.
     */
    public void cargar(int numPaquetesCarga) throws IllegalArgumentException, IllegalStateException;
    
    /**
     * Método para realizar el reparto de los paquetes cargados en el dron.
     * Recibe por parámetro el número de paquetes a repartir.
     * 
     * @param numPaquetesReparto Número de paquetes que se van a repartir.
     * 
     * @throws IllegalArgumentException Si se intenta repartir menos de un paquete.
     * @throws IllegalStateException Si se intenta repartir más paquetes de los disponibles.
     */
    public void repartir(int numPaquetesReparto) throws IllegalArgumentException, IllegalStateException;
    
}