/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jopcion
 */
public class RecepcionHabitacion {
    //creamos los atributos necesarios para la clase RecepcionHabitacion haciendo el debido mapeo
    private int idRecepcionHabitacion;
    private int recepcionId;
    private int habitacionId;
    private int pedidoId;
    //creamos el constructor
    public RecepcionHabitacion(int idRecepcionHabitacion, int recepcionId, int habitacionId, int pedidoId) {
        this.idRecepcionHabitacion = idRecepcionHabitacion;
        this.recepcionId = recepcionId;
        this.habitacionId = habitacionId;
        this.pedidoId = pedidoId;
    }
    //luego sus respectivos setters y getters
    public int getIdRecepcionHabitacion() {
        return idRecepcionHabitacion;
    }

    public void setIdRecepcionHabitacion(int idRecepcionHabitacion) {
        this.idRecepcionHabitacion = idRecepcionHabitacion;
    }

    public int getRecepcionId() {
        return recepcionId;
    }

    public void setRecepcionId(int recepcionId) {
        this.recepcionId = recepcionId;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }
    
}
