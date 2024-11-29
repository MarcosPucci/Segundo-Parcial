/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author marco
 */
public class ExcursionAventura extends Excursion{
    private int nivelDificultad;
    private double seguroAdicional = 0.0;

    public ExcursionAventura(String titulo, double precioBase, 
            int cupoMaximo, int nivelDificultad) {
        super(titulo, precioBase, cupoMaximo);
        
        this.nivelDificultad = nivelDificultad;
        this.establecerSeguroAdicional();
    }
    
    public ExcursionAventura(String titulo, double precioBase, 
            int cupoMaximo, int nivelDificultad, double seguroAdicional) {
        super(titulo, precioBase, cupoMaximo);
        
        this.nivelDificultad = nivelDificultad;
        this.seguroAdicional = seguroAdicional;
    }
    
    public void establecerSeguroAdicional()
    {
        switch(this.nivelDificultad)
        {
            case 1:
                this.seguroAdicional += 50.0;
                break;
            case 2:
                this.seguroAdicional += 100.0;
                break;
            case 3:
                this.seguroAdicional += 150.0;
                break;
            case 4:
                this.seguroAdicional += 200.0;
                break;
            case 5:
                this.seguroAdicional += 250.0;
                break;
        }
    }
    
    @Override
    public double calcularPrecioFinal()
    {
        double porcentajeExtra = 0.0;
        
        switch(this.nivelDificultad)
        {
            case 1:
                porcentajeExtra = 0.1;
                break;
            case 2:
                porcentajeExtra = 0.2;
                break;
            case 3:
                porcentajeExtra = 0.3;
                break;
            case 4:
                porcentajeExtra = 0.4;
                break;
            case 5:
                porcentajeExtra = 0.5;
                break;
        }
        
        double precioFinal = this.precioBase + this.seguroAdicional + 
                (this.precioBase * porcentajeExtra);
        
        return precioFinal;
    }
    
    public String consejosSeguridad()
    {
        String consejoDeSeguridad = "";
        switch(this.nivelDificultad)
        {
            case 1:
                consejoDeSeguridad = "";
                break;
            case 2:
                consejoDeSeguridad = "";
                break;
            case 3:
                consejoDeSeguridad = "";
                break;
            case 4:
                consejoDeSeguridad = "";
                break;
            case 5:
                consejoDeSeguridad = "";
                break;
        }
        return consejoDeSeguridad;
    }
}
