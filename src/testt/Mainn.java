package testt;
import model.ExcursionAventura;
import model.GestorExcursiones;
import model.Reserva;

public class Mainn {

    public static void main(String[] args) {
        System.out.println("Test 1-1");
        GestorExcursiones gestorExcursiones = new GestorExcursiones();
        ExcursionAventura excursionAventura1 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 10, 3);
        gestorExcursiones.agregarExcursion(excursionAventura1);
        
        System.out.println("Test 1-2");
        try
        {
            ExcursionAventura excursionAventura2 = new ExcursionAventura("Excursión en la Montaña", 800.0, -5, 3);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Test 1-3");
        try
        {
            ExcursionAventura excursionAventura3 = new ExcursionAventura("", 1000.0, 15, 3);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Test 1-4");
        try
        {
            ExcursionAventura excursionAventura4 = new ExcursionAventura("Ra", 800.0, 10, 3);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Test 1-5");
        ExcursionAventura excursionAventura5 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 1, 3, 200);
        System.out.println(excursionAventura5.calcularPrecioFinal());
        
        System.out.println("Test 1-6");
        excursionAventura5.agregarActividades("Navegar el río");
        excursionAventura5.agregarActividades("Instruccion sobre seguridad");
        
        System.out.println("Test 2-1");
        excursionAventura5.realizarReserva("Carlos Perez");
        
        System.out.println("Test 2-2");
        excursionAventura5.realizarReserva("Ana García");
        
        System.out.println("Test 2-3");
        
    }
    
}
