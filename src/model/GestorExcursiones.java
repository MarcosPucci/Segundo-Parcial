/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author marco
 */
public class GestorExcursiones {
    private Repository<Excursion> repository;

    public GestorExcursiones() {
        this.repository = new ExcursionRepository();
    }
    
    public boolean agregarExcursion(Excursion excursion)
    {
        this.repository.add(excursion);
        System.out.println("Excursión de tipo Aventura agregada exitosamente con ID: " + excursion.getId());
        return true;
    }
    
    public Optional<Excursion> buscarPorId(int id)
    {
        return this.repository.findById(id);
    }
    
    public List<Excursion> filtrarExcursiones(Predicate<Excursion> criterio)
    {
        List<Excursion> excursionesEncontradas = new ArrayList<>();
        
        for(Excursion e : this.repository.getAll())
        {
            if(criterio.test(e))
            {
                excursionesEncontradas.add(e);
            }
        }
        return excursionesEncontradas;
    }
    
    public List<Excursion> consultarExcursionesPorPrecio(double precioMin)
    {
        Predicate<Excursion> excursionPrecioMin = e -> e.calcularPrecioFinal() <= precioMin;
        
        return this.repository.findBy(excursionPrecioMin);
    }
}
