
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
 
public class PrincipalExecutor {
 
    public static void main(String[] args) {
 
        Stream<String> flujo = Stream.of("tarea1", "tarea2", "tarea3");
 
        ExecutorService servicio = Executors.newScheduledThreadPool(1);
     
        flujo.map(t->new Tarea(t)).forEach(servicio::execute);
    }
 
}

class Tarea implements Runnable {
 
    private String nombre;
 
    public Tarea(String nombre) {
        super();
        this.nombre = nombre;
    }
 
    @Override
    public void run() {
 System.out.println(nombre);
        
 
    }
 
}
