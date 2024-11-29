/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marco
 */
public abstract class Excursion implements Serializable{
    protected int id;
    protected static int contadorConstantes = 1;
    protected String titulo;
    protected double precioBase;
    protected int cupoMaximo;
    protected transient GestorReservas gestorReservas;
    protected List<String> actividades = new ArrayList<>();

    public Excursion(String titulo, double precioBase, int cupoMaximo) {
        this.id = Excursion.contadorConstantes;
        this.setTitulo(titulo);
        this.precioBase = precioBase;
        this.setCupoMaximo(cupoMaximo);
        this.gestorReservas = new GestorReservas(cupoMaximo);
    }
    
    public boolean realizarReserva(String cliente)
    {
        Reserva reserva = new Reserva(this.id, cliente, this.calcularPrecioFinal());
        this.gestorReservas.realizarReserva(reserva);
        
        return false;
    }
    public abstract double calcularPrecioFinal();
    
    public void agregarActividades(String actividad)
    {
        this.actividades.add(actividad);
        System.out.println("Actividad agregada: " + actividad);
    }
    public String mostrarResumen()
    {
        return this.toString();
    }
    
    private String generarFilePath()
    {
        String rutaArchivo = "Reservas_excursion_{" + this.id + "}.dat";
        return rutaArchivo;
    }
    
    public Optional<List<Reserva>> traerReservas()
    {
        return Optional.of(this.gestorReservas.getReservas());
    }

    @Override
    public String toString() {
        return "Excursion{" + "cupoMaximo=" + cupoMaximo + ", actividades=" + actividades + '}';
    }

    public void setTitulo(String titulo) {
        if(titulo.length() > 3)
        {
            this.titulo = titulo;
        }
        else
        {
            throw new IllegalArgumentException("El titulo debe tener mas de 3 caracteres...");
        }
    }

    public void setCupoMaximo(int cupoMaximo) {
        if(cupoMaximo > 0)
        {
            this.cupoMaximo = cupoMaximo;
        }
        else
        {
            throw new IllegalArgumentException("El cupo máximo debe ser mayor que 0.");
        }
    }

    public int getId() {
        return id;
    }
}
