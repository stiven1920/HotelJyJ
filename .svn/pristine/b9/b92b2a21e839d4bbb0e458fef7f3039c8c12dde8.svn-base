/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Jopcion
 */
public class HistorialDTO {

    /*
    SELECT p.cedula, p.nombre "Nombre huesped", p.apellido "apellido Huesped", r.idReserva "N° reserva", r.fechaInicio, r.fechaSalida
,h.idHabitacion "N° habitacion", h.tipoHabitacion "habitacion", h.valor,
rp.idRegistroPedido "N° pedido", rp.nombreProducto "producto", rp.valorProducto "valor" 


FROM huesped p JOIN reserva r
ON p.cedula = r.huespedId
JOIN confirmarreserva c
ON r.idReserva = c.reservaId
JOIN habitacion h
ON  h.idHabitacion = r.habitacionId
JOIN registropedido rp
ON  h.idHabitacion = rp.habitacionId
     */
    private int cedula;
    private String nombre;
    private String apellido;
    private int idReserva;
    private Date fechaInicio;
    private Date fechaSalida;
    private int idHabitacion;
    private String tipoHabitacion;
    private int valor;
    private int idRegistroPedido;
    private String nombreProducto;
    private int valorProducto;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

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

    public int getIdRegistroPedido() {
        return idRegistroPedido;
    }

    public void setIdRegistroPedido(int idRegistroPedido) {
        this.idRegistroPedido = idRegistroPedido;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    
}
