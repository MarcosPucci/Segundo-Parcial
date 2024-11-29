/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author marco
 */
public class ReservaRepository implements Repository<Reserva>{
    private List<Reserva> reservas = new ArrayList<>();
    private GestorPersistencia<Reserva> persistencia;
    private String filePath;
    
    @Override
    public void add(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public void remove(int id) {
        for(Reserva r : this.reservas)
        {
            if(r.getIdExcursion() == id)
            {
                this.reservas.remove(r);
            }
        }
    }

    @Override
    public Optional<Reserva> findById(int id) {
        
        return this.reservas.stream().filter(r -> r.getIdExcursion() == id).findFirst();
    }

    @Override
    public List<Reserva> findBy(Predicate<Reserva> criterio) {
        List<Reserva> reservasEncontradas = new ArrayList<>();
        
        for(Reserva r : this.reservas)
        {
            if(criterio.test(r))
            {
                reservasEncontradas.add(r);
            }
        }
        return reservasEncontradas;
    }

    @Override
    public List<Reserva> getAll() {
        return this.reservas;
    }
}
