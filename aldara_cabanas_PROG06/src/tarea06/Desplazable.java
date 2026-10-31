package tarea06;

/**
 * Interfaz que ofrece a un objeto la capacidad de desplazarse.
 * 
 * @author Aldara María Cabañas Cuevas
 */
public interface Desplazable {
    /**
     * Método que realiza el desplazamiento del dispositivo.
     * Recibe dos parámetros que corresponderán al número de posiciones que se quiere desplazar el dispositivo en el eje X y el eje Y.
     * 
     * @param desplazamientoEjeX Desplazamiento de posiciones del dispositivo en el eje X.
     * @param desplazamientoEjeY Desplazamiento de posiciones del dispositivo en el eje Y.
     * 
     * @throws IllegalStateException Si el dispositivo se intenta desplazar fuera de su rango de operación en cualquier eje.
     */
    public void desplazar(int desplazamientoEjeX, int desplazamientoEjeY) throws IllegalStateException;
    
}
