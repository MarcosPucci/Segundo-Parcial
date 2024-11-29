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
public class ExcursionRepository implements Repository<Excursion>{
    private List<Excursion> excursiones = new ArrayList<>();
    private GestorPersistencia<Excursion> persistencia;
    private String filePath;
    private int ultimoId;
    
    @Override
    public void add(Excursion excursion) {
        this.excursiones.add(excursion);
        Excursion.contadorConstantes += 1;
    }

    @Override
    public void remove(int id) {
        for(Excursion e : this.excursiones)
        {
            if(e.getId() == id)
            {
                this.excursiones.remove(e);
            }
        }
    }

    @Override
    public Optional<Excursion> findById(int id) {
        
        return this.excursiones.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<Excursion> findBy(Predicate<Excursion> criterio) {
        List<Excursion> excursionesEncontradas = new ArrayList<>();
        
        for(Excursion e : this.excursiones)
        {
            if(criterio.test(e))
            {
                excursionesEncontradas.add(e);
            }
        }
        return excursionesEncontradas;
    }

    @Override
    public List<Excursion> getAll() {
        return this.excursiones;
    }
}
