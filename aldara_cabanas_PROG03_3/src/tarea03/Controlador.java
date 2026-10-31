package tarea03;
//importamos la clase Velero para poder usarla
import libtarea3.Velero;
// ------------------------------------------------------------
//                   Clase Controlador
// ------------------------------------------------------------
/**
 * <p>
 * Clase que representa al <strong>controlador</strong>,
 * que será la clase que utilizaremos y donde se escribirán las diferentes 
 * operaciones en veleros que se nos pide en el enunciado de la tarea.
 * </p>
 * @author Aldara Maria Cabañas Cuevas
 */
public class Controlador {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        Velero velero1, velero2, velero3, veleroIncorrecto;
        String veleroNavegando,resultadoRegata;//variables auxiliares
        
        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        
        System.out.println("-------------------");
        System.out.println("--Creando Veleros--");
        System.out.println("-------------------");
        System.out.println();
        System.out.printf("Creando veleros con datos correctos...%n");
        
        // Instanciar los tres veleros correctos: velero1, velero2 y velero3
        
        //para el primero usaremos el constructor por defecto (sin parámetros)
        velero1= new Velero();
        //para el velero 2 y 3  usaremos el metodo constructor con los 3 parámetros que se piden
        velero2= new Velero("Poseidón", 3, 6);
        velero3= new Velero("Atlántico", 3, 5 );
        
        System.out.printf("**Veleros creados correctamente**%n");
        System.out.println();
        
        // Intentar instanciar el cuarto velero (incorrecto): veleroIncorrecto
        System.out.printf("Creando veleros con datos incorrectos/nulos...%n");
        /*para los veleros con datos incorrectos vamos a usar bloques try-catch de forma que cuando se intente ejecutar el código con errores
        el programa capture la excepción que se produce en cada caso, mostrando el mensaje de error y continuando su ejecución hasta el final
        */
        try {
            veleroIncorrecto= new Velero(null, 3, 6);
        } catch (NullPointerException ex){ //capturamos la excepcion del valor nulo
            System.out.printf("Error al crear el velero: %s", ex.getMessage());
        }
        try {
            veleroIncorrecto= new Velero("VeleroIncorrecto", -5, 6);
        } catch (IllegalArgumentException ex){ //capturamos la excepcion del valor incorrecto
            System.out.printf("Error al crear el velero: %s%n", ex.getMessage());
        }
        
        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        
        System.out.println("---------------------------");
        System.out.println("--Secuencia instrucciones--");
        System.out.println("---------------------------");
        System.out.println();
        
        //accederemos a los métodos que vamos a usar en la secuencia de instrucciones desde cada objeto instanciado cuya información queramos manipular
        
        // velero1 inicia su navegación con velocidad 10, rumbo ceñida, patrón Carlos Ruiz y tripulación 0
        //usamos el metodo iniciarNavegacion con cada velero que creamos antes introduciendo los datos necesarios en sus parámetros
        velero1.iniciarNavegacion(10, "ceñida", "Carlos Ruiz", 0);
        System.out.printf("El velero1 ha iniciado su navegación%n");//mostramos por pantalla mensaje que indica que se ha iniciado la navegación
        
        // velero2 inicia su navegación con velocidad 15, rumbo empopada, patrón Laura Gómez y tripulación 4
        velero2.iniciarNavegacion(15, "empopada", "Laura Gómez", 4);
        System.out.printf("El velero2 ha iniciado su navegación%n");

        // velero3 inicia su navegación con velocidad 12, rumbo empopada, patrón Pedro Torres y tripulación 2
        velero3.iniciarNavegacion(12, "empopada", "Pedro Torres", 2);
        System.out.printf("El velero3 ha iniciado su navegación%n%n");
        
        // Comprobar si el velero1 está navegando        
        //para esta comprobacion usaremos el metodo isNavegando que devolverá un valor booleano dependiendo del estado del velero
        veleroNavegando = velero1.isNavegando()? "Sí" : "No";
        //he almacenado el resultado del metodo en una variable y usado un ternario para que el valor que se muestre por pantalla sea Sí o No en lugar de true o false
        //he priorizado el ternario sobre un if-else para reducir el codigo de la operacion a una sola línea
        System.out.printf("¿El velero1 está navegando? %s%n%n", veleroNavegando);
        
        // Mostrar el nombre y el número de mástiles de velero2
        //para obtener el nombre del velero vamos a usar el método getNombreBarco que devuelve un string con su nombre
        System.out.printf("El nombre del velero2 es: %s%n", velero2.getNombreBarco());
        //para mostrar el número de mástiles usaremos el método getNumMastiles que devuelve un entero
        System.out.printf("El número de mástiles del velero2 es: %d%n%n", velero2.getNumMastiles());
        
        // Mostrar el patrón y la velocidad de navegación de velero3
        //usamos el metodo getPatron para obtener un string con el nombre del patron
        System.out.printf("El patrón del velero3 es: %s%n", velero3.getPatron());
        //con el metodo getVelocidad obtenemos un entero de la velocidad del barco en nudos
        System.out.printf("La velocidad del velero3 es: %d nudos%n%n", velero3.getVelocidad());
        
        // Modificar el rumbo de velero1 a empopada y mostrarlo
        //primero vamos a comprobar que el barco esta navegando antes de cambiar el rumbo, para esto usaremos un if
        if (velero1.isNavegando()==true){
            //para cambiar el rumbo usaremos el metodo setRumbo y añadiremos el string del nuevo rumbo
            velero1.setRumbo("empopada");
            //por último, para mostrar que el rumbo ha cambiado usaremos el metodo getRumbo que devuelve un string con el rumbo actual
            System.out.printf("El nuevo rumbo del velero1 es: %s%n", velero1.getRumbo());
            System.out.println();
        }
        
        // Parar la navegación de velero1 después de 120 minutos
        /*para parar la navegacion de los veleros usamos el método pararNavegacion al que hay que ponerle un numero entero definiendo el tiempo 
        de navegacion hasta la parada*/
        velero1.pararNavegacion(120);
        System.out.printf("El velero1 ha parado su navegación%n");
        
        // Mostrar el tiempo total de navegación de velero1
        //usamos el metodo getTiempoTotalNavegacionBarco para que nos de un numero entero del tiempo total de navegacion en minutos
        System.out.printf("Tiempo total de navegación del velero1: %d%n%n", velero1.getTiempoTotalNavegacionBarco());
        
        // Iniciar una regata entre velero2 y velero3
        System.out.println("Iniciando regata...");
        //para iniciar la regata usamos el metodo iniciarRegata que devuelve un string con el resultado. 
        //accedemos al metodo desde el velero2 y añadimos el velero3 como parámetro
        resultadoRegata = velero2.iniciarRegata(velero3);//almacenamos el resultado en una variable para mostrarlo por pantalla despues
        System.out.printf("%s%n",resultadoRegata);
        
        // Parar la navegación de velero2 después de 90 minutos
        //volvemos a usar el metodo pararNavegacion para los demás veleros
        velero2.pararNavegacion(90);
        System.out.printf("El velero2 ha parado su navegación%n");
        
        // Parar la navegación de velero3 después de 150 minutos
        velero3.pararNavegacion(150);
        System.out.printf("El velero3 ha parado su navegación%n");

        //----------------------------------------------
        //   Mostrar información de cada velero
        //----------------------------------------------
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("--Información de veleros--");
        System.out.println("--------------------------");
        System.out.println();
        
        //Mostrar toda la información de velero1
        //para mostrar la información de los veleros vamos a usar el metodo toString que devuelve un string formateado con el estado del objeto
        System.out.printf("Velero 1: %s%n", velero1.toString());
        
        //Mostrar toda la información de velero2
        System.out.printf("Velero 2: %s%n", velero2.toString());
        
        //Mostrar toda la información de velero3
        System.out.printf("Velero 3: %s%n", velero3.toString());

        //----------------------------------------------
        //          Llamadas a métodos estáticos
        //----------------------------------------------
        
        System.out.println();
        System.out.println("---------------------");
        System.out.println("--Métodos estáticos--");
        System.out.println("---------------------");
        System.out.println();
        
        //a los metodos estáticos vamos a acceder desde la clase, no desde objetos instanciados, ya que vamos a acceder a información global
        
        // Mostrar el número total de veleros creados
        //en este caso usaremos el metodo getNumBarcos que devuelve un entero con el numero total de objetos instanciados
        System.out.printf("Número total de veleros: %d%n", Velero.getNumBarcos());
        
        // Mostrar el número total de veleros navegando en este momento
        //ahora usamos el metodo getNumBarcosNavegando que devuelve un entero que indica los barcos que estan navegando
        System.out.printf("Número de veleros navegando: %d%n", Velero.getNumBarcosNavegando());
        
        // Mostrar el tiempo total de navegación de todos los veleros (en horas)
        //aquí usamos el método getTiempoTotalNavegacion que devuelve un float con el tiempo de navegacion de los veleros en minutos
        System.out.printf("Tiempo total de navegación de todos los veleros: %.2f horas%n", Velero.getTiempoTotalNavegacion()/60);
        /*para poner el tiempo en horas, al tratarse de una operación muy sencilla, he decidido hacerlo directamente en la linea donde uso el metodo
        y formatearlo con el printf en lugar de crear una variable para guardar el resultado de la operación para reducir las líneas de codigo
        */
    }
}
