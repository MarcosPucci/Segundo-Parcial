/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author marco
 */
public interface Serializer<T> {
    public <T> void guardarDatos(String filePath, List<T> data);
    public <T> List<T> cargarDatos(String filePath);
}
