/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.HabitacionBo;
import excepciones.HabitacionNoEncontradaException;
import java.io.File;
import java.util.List;
import javax.swing.JTable;
import modelo.Habitacion;

/**
 *
 * @author MI PC
 */
public class CtlHabitacion {

    HabitacionBo bo;
    
    public CtlHabitacion() {
        bo = new HabitacionBo();
    }
    
    public void guardarHabitacion(Habitacion habitacion, File file){
        bo.guardarHabitacion(habitacion, file);
    }
    
    public Habitacion buscarHabitacion(int id){
        return bo.buscarHabitacion(id);
    }
    
   public void modificarHabitacion(String tipoHabitacion, int valor, String estado, String descripcion, int id){
       bo.modificarHabitacion(tipoHabitacion, valor, estado, descripcion, id);
   }
   
   public void modificarHabitacionFoto(String tipoHabitacion, int valor, String estado, String descripcion,File file, int id){
       bo.modificarHabitacionFoto(tipoHabitacion, valor, estado, descripcion, file, id);
   }
    public void eliminarHabitacion(int id){
        bo.eliminarHabitacion(id);
    }
    public void listarHabtacion(JTable table){
        bo.visualizarHabitacion(table);
    }
    
    public List<Habitacion> listarHabitaciones() {
        return bo.listarHabitaciones();
    }
    
}
