/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author marco
 */
public class GestorPersistencia<T> implements Serializer<T>{

    @Override
    public void guardarDatos(String filePath, List data) {
        try(ObjectOutputStream cos = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            cos.writeObject(data);
            System.out.println("Datos serializados en el archivo: " + filePath);
        }
        catch(IOException e)
        {
            System.err.println("Error en la serializacion: " + e.getMessage());
        }
    }

    @Override
    public List<T> cargarDatos(String filePath) {
        List<T> guardado = null;
        
        try (ObjectInputStream cis = new ObjectInputStream(new FileInputStream(filePath))) 
        {
            guardado = (List<T>) cis.readObject();
            System.out.println("Datos cargados desde el archivo: " + filePath);
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
        
        return guardado;
    }
}
