/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Reserva implements Serializable{
    private int idExcursion;
    private String cliente;
    private String fechaReserva;
    private double precio;
    private boolean pagoConfirmado;

    public Reserva(int idExcursion, String cliente, double precio) {
        this.idExcursion = idExcursion;
        this.cliente = cliente;
        this.fechaReserva = "29/11/2024";
        this.precio = precio;
        this.pagoConfirmado = false;
    }
    
    public boolean confirmarPago()
    {
        this.pagoConfirmado = true;
        return true;
    }
    
    public String detalleReserva()
    {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Reserva{" + "idExcursion=" + idExcursion + ", cliente=" + 
                cliente + ", fechaReserva=" + fechaReserva + ", precio=" + 
                precio + ", pagoConfirmado=" + pagoConfirmado + '}';
    }

    public double getPrecio() {
        return precio;
    }

    public int getIdExcursion() {
        return idExcursion;
    }

    public String getCliente() {
        return cliente;
    }
}
