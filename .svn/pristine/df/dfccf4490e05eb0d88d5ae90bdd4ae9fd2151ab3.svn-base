/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.Habitacion;

/**
 *
 * @author MI PC
 */
public interface IHabitacionDao {

    /**
     * Metodo para persistir las habitaciones que hayan en el hotel
     * @param habitacion por parametro recibimos el objecto de
     * habitacion(atributos)
     */
    public void guardarHabitacion(Habitacion habitacion);

    /**
     * Metodo para buscar una habitacion persistida en la base de datos
     * @param id buscamos por el id de la habitacion existente
     * @return nos retorna una habitacion, de lo contrario nos va retonar
     * habitacion no encontrada
     */
    public Habitacion buscarHAbitacion(int id);

    /**
     * Metodo para modificar la habitacion ya encontrada
     * @param habitacion por para metro el objecto de la habitacion para poderlo modificar
     */
    public void modificarHabitacion(Habitacion habitacion);

    /**
     * Metodo para modificar la habitacion ya encontrada
     * @param habitacion por parametro llamos los atributos que queremos moficiar incluyendo la foto
     */
    public void modificarHabitacionFoto(Habitacion habitacion);
    
    /**
     * Metodo para eliminar una habitacion, que no se desea ya dar servicio
     * @param id por parametro resibimos el id de la habitacion que deseamos
     * eliminar el servicio
     * @return nos va ah eliminar la habitacion que no queremos que preste servicio
     */
    public boolean eliminarHabitacion(int id);
    
    /**
     * Metodo de listar las habitacion que esten en servicio dentro del hotel
     * @return nos retorna las habitacion persistidas en la base de datos
     */
    public ArrayList<Habitacion> listarHabitacion();

}
