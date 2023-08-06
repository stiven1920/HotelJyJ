/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MI PC
 */
public class Habitacion {
    
    //creamos los atributos necesarios para la clase Habitacion haciendo el debido mapeo
    private int idHabitacion;
    private String tipoHabitacion;
    private int valor;
    private String estado;
    private String descripcion;
    private byte[] foto;
    //creamos el constructor
    
    public Habitacion(){ 
    }
    
    public Habitacion(int idHabitacion, String tipoHabitacion, int valor, String estado, String descripcion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.valor = valor;
        this.estado = estado;
        this.descripcion = descripcion;
    }
    //luego sus respectivos setters y getters
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }   
    
}
