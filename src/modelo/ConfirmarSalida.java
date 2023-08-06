/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author STIVEN
 */
public class ConfirmarSalida {

    private int idConfirmarSalida;
    private String nombreHuesped;
    private String apellidoHuesped;
    private Date fechaLlegada;
    private Date fechaSalida;
    private int confirmarLlegada;
    private int recepcionistaId;

    public ConfirmarSalida() {
    }

    public ConfirmarSalida(String nombreHuesped, String apellidoHuesped, Date fechaLlegada, Date fechaSalida, int confirmarLlegada, int recepcionistaId) {
        this.nombreHuesped = nombreHuesped;
        this.apellidoHuesped = apellidoHuesped;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.confirmarLlegada = confirmarLlegada;
        this.recepcionistaId = recepcionistaId;
    }

  

    public int getIdConfirmarSalida() {
        return idConfirmarSalida;
    }

    public void setIdConfirmarSalida(int idConfirmarSalida) {
        this.idConfirmarSalida = idConfirmarSalida;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public String getApellidoHuesped() {
        return apellidoHuesped;
    }

    public void setApellidoHuesped(String apellidoHuesped) {
        this.apellidoHuesped = apellidoHuesped;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getConfirmarLlegada() {
        return confirmarLlegada;
    }

    public void setConfirmarLlegada(int confirmarLlegada) {
        this.confirmarLlegada = confirmarLlegada;
    }

    public int getRecepcionistaId() {
        return recepcionistaId;
    }

    public void setRecepcionistaId(int recepcionistaId) {
        this.recepcionistaId = recepcionistaId;
    }

}
