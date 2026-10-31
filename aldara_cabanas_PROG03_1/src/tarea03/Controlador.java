
package tarea03;
//primero vamos a importar los paquetes de java que vamos a necesitar para la tarea, incluyendo la clase Aeronave y Aeropuerto
import libtarea3.Aeropuerto;
import libtarea3.Aeronave;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ------------------------------------------------------------
//                   Clase Controlador
// ------------------------------------------------------------
/**
 * <p>
 * Clase que representa al <strong>controlador</strong>,
 * que será la clase que utilizaremos y donde se escribirán las diferentes 
 * operaciones en aeronaves y aeropuertos que se nos pide en 
 * el enunciado de la tarea.</p>
 *
 * @author ALDARA Mª CABAÑAS CUEVAS
 */
public class Controlador {
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        //primero creamos las 3 variables referencia de los aeropuertos
        Aeropuerto prat, barajas, garciaLorca;
        //ahora las 3 variables de los aviones
        Aeronave avion1, avion2, avion3;
        //variables para fecha, hora y su formato
        LocalDateTime fechaHoraActual;
        DateTimeFormatter formato;
        String fechaHoraFormateada; 
        
        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        
        // Instanciar los 3 aeropuertos: Barcelona, Madrid, Granada.
        System.out.println("-----------------------");
        System.out.println("--Creando Aeropuertos--");
        System.out.println("-----------------------");
        
        /* usamos new para llamar al constructor de la clase Aeropuerto y añadimos los parámetros de este,
        que en este caso son dos tipo string para el nombre y la ciudad*/
        prat = new Aeropuerto("El Prat", "Barcelona");
        barajas = new Aeropuerto("Barajas","Madrid");
        garciaLorca = new Aeropuerto("Federico García Lorca", "Granada");
        
        System.out.println("");
        System.out.println("**Aeropuertos creados**");
        System.out.println("");
        
        // Instanciar las 3 aeronaves: Avion1, Avion2, Avion3.
        System.out.println("-----------------------");
        System.out.println("---Creando Aeronaves---");
        System.out.println("-----------------------");
        //para usar el constructor por defecto simplemente no añadimos parámetros en el paréntesis
        avion1 = new Aeronave();
        //para el constructor con dos parámetros usaremos los 2 tipo string que requiere
        avion2 = new Aeronave("EC-123", "Boing747");
        //para el constructor con 3 parámetros, usamos los dos tipo string y el aeropuerto que hemos instanciado antes
        avion3 = new Aeronave("EC-456", "Boing787", barajas);
        
        System.out.println("");
        System.out.println("**Aeronaves creadas**");
        System.out.println("");
        
        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        
        System.out.println("---------------------------");
        System.out.println("--Secuencia instrucciones--");
        System.out.println("---------------------------");
        System.out.println("");
        
        //primero vamos a inicializar las variables que hemos creado para establecer la fecha y hora actual en el formato correcto
        //usando los métodos de las clases LocalDateTime y DateTimeFormatter
        fechaHoraActual = LocalDateTime.now();
        formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        fechaHoraFormateada = fechaHoraActual.format(formato);
        
        //Avion1 despega con velocidad 1500, altitud 1750, rumbo 50 y fechaHora actual
        //para esto vamos a usar el metodo despegar de la clase Aeronave, introduciendo sus parámetros para cada avión
        avion1.despegar(1500, 1750, 50, fechaHoraFormateada);
        //mostraremos un mensaje por pantalla usando printf para indicar que cada avión ha despegado
        System.out.printf("     El Avión 1 ha despegado%n");
        System.out.println("");
        
        //Avion2 despega con velocidad 1500, altitud 1850 y rumbo 75
        avion2.despegar(1500, 1850, 75, fechaHoraFormateada);
        System.out.printf("     El Avión 2 ha despegado%n");
        System.out.println("");
        
        //Avion3 despega con velocidad 1500, altitud 1000 y rumbo 180
        avion3.despegar(1500, 1000, 180, fechaHoraFormateada);
        System.out.printf("     El Avión 3 ha despegado%n");
        System.out.println("");
        
        //Comprobar si Avion1 está volando
        //usaremos el método isVolando
        System.out.printf("¿El Avión 1 está volando? %b%n", avion1.isVolando());
        
        //Mostrar la matrícula del Avion2
        //usaremos el método getMatrícula
        System.out.printf("La matrícula del Avión 2 es: %s%n", avion2.getMatricula());
        
        //Mostrar modelo del Avion3
        //usaremos el método getModelo
        System.out.printf("Modelo del Avión 3 es: %s%n", avion3.getModelo());
        
        //Modificar rumbo del Avion2 a 90º y mostrarlo
        //usaremos los métodos setRumbo y getRumbo y lo sacamos por pantalla con printf
        avion2.setRumbo(90);
        System.out.printf("El rumbo del Avión 2 es: %d%n", avion2.getRumbo());
        System.out.println("");
        
        //Avion3 aterriza en el aeropuerto de Barcelona despues de 75 minutos
        //usaremos el método aterrizar
        avion3.aterrizar(prat, 75);
        System.out.printf("     El Avión 3 ha aterrizado%n");
        System.out.println("");
        
        //Avion2 aterriza en el aeropuerto de Madrid despues de 80 minutos
        avion2.aterrizar(barajas, 80);
        System.out.printf("     El Avión 2 ha aterrizado%n");
        System.out.println("");
        
        //Comprobar si Avion2 está volando
        System.out.printf("¿El Avión 2 está volando? %b%n", avion2.isVolando());
        
        //Modificar altitud del Avion1 a 1250 metros y mostrarlo
        //usaremos los metodos setAltitud y getAltitud
        avion1.setAltitud(1250);
        System.out.printf("La nueva altitud del Avión 1 es: %d%n", avion1.getAltitud());
        
        
        //Mostrar el tiempo total de vuelo del Avion2
        //usaremos el método getTiempoTotalVuelo
        System.out.printf("El tiempo de vuelo del Avión 2 en minutos es: %d%n", avion2.getTiempoTotalVuelo());
        
        //Mostrar el aeropuerto del Avion3
        //usaremos el método getAeropuerto
        System.out.printf("El aeropuerto del Avión 3 es: %s%n", avion3.getAeropuerto());
        
        //Mostrar la fecha y hora de despegue del Avion1
        //usaremos el método getFechaHoraDespegue
        System.out.printf("El despegue del Avión 1 se realizó con fecha: %s%n", avion1.getFechaHoraDespegue());
        System.out.println("");
        
        //Avion3 despega con velocidad 860, altitud 1420 y rumbo 270
        avion3.despegar(860, 1420, 270, fechaHoraFormateada);
        System.out.printf("     El Avión 3 ha despegado%n");
        System.out.println("");
        
        //Avion1 aterriza en el aeropuerto de Granada despues de 260 minutos
        avion1.aterrizar(garciaLorca, 260);
        System.out.printf("     El Avión 1 ha aterrizado%n");
        System.out.println("");
        
        //Modificar velocidad del Avion3 a 950km/h y mostrarlo
        //usaremos los métodos setVelocidad y getVelocidad
        avion3.setVelocidad(950);
        System.out.printf("La nueva velocidad del Avión 3 es : %d%n",avion3.getVelocidad());
        
        //Mostrar el nombre del aeropuerto de Madrid
        //usaremos el método getNombre de la clase aeropuerto
        System.out.printf("El nombre del aeropuerto de Madrid es: %s%n", barajas.getNombre());
        
        //Mostrar el número de aeronaves en este momento en el aeropuerto de Granada
        //usaremos el método getNumeroAeronaves
        System.out.printf("El número de aeronaves en el aeropuerto de Granada es: %d%n", garciaLorca.getNumeroAeronaves());
        
        
        //Mostrar toda la información del Avion1
        //para esto usaremos el método toString con los 3 aviones
        System.out.printf("Avión 1: %s%n", avion1.toString());
        //Mostrar toda la información del Avion2
        System.out.printf("Avión 2: %s%n", avion2.toString());
        //Mostrar toda la información del Avion3
        System.out.printf("Avión 3: %s%n", avion3.toString());
        
        //----------------------------------------------
        //          Llamadas a métodos estáticos
        //----------------------------------------------
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("--Métodos estáticos--");
        System.out.println("---------------------");
        System.out.println("");
        
        
        //Mostrar el número total de aeronaves volando ahora mismo
        //usaremos el método estático de la clase aeronave getNumAeronavesVolando
        System.out.printf("El número total de aeronaves volando ahora mismo es: %d%n", Aeronave.getNumAeronavesVolando());
        
        //Mostrar el tiempo total de aeronaves volando en horas
        //usaremos el método estático getNumHorasVuelo
        System.out.printf("El tiempo total de aeronaves volando es: %f%n", Aeronave.getNumHorasVuelo());
        
        //Mostrar el número total de aeronaves
        //usaremos el método estático getNumAeronaves
        System.out.printf("El número total de aeronaves es: %d%n", Aeronave.getNumAeronaves());
        
        
    }
}
