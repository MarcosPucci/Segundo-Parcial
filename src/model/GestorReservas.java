package model;
import java.util.List;
import java.util.function.Predicate;

public class GestorReservas {
    private Repository<Reserva> repository;
    private final int cupoMaximo;

    public GestorReservas(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
        this.repository = new ReservaRepository();
    }
    
    public boolean realizarReserva(Reserva reserva)
    {
        if((this.repository.getAll().size() + 1) <= this.cupoMaximo)
        {
            this.repository.add(reserva);
            System.out.println("Reserva realizada con éxito para el cliente: " + reserva.getCliente());
            return true;
        }
        System.out.println("No hay cupos disponibles para la excursión");
        return false;
    }
    
    public List<Reserva> getReservas()
    {
        return this.repository.getAll();
    }
    
    public double calcularIngresos(Predicate<Reserva> filtro)
    {
        double totalIngresos = 0.0;
        
        for(Reserva r : this.repository.getAll())
        {
            if(filtro.test(r))
            {
                totalIngresos += r.getPrecio();
            }
        }
        
        return totalIngresos;
    }
    
    public double calcularIngresosTotales()
    {
        double ingresosTotales = 0.0;
        
        for(Reserva r : this.repository.getAll())
        {
            ingresosTotales += r.getPrecio();
        }
        
        return ingresosTotales;
    }
}
