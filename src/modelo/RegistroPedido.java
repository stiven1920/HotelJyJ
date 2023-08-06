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
public class RegistroPedido {

    private int idRegistroPedido;
    private String nombreProducto;
    private int cantidad;
    private int valor;
    private int total;
    private int huespedId;
    private int habitacionId;


    public RegistroPedido() {
    }

    public RegistroPedido(int idRegistroPedido, String nombrePRoducto, int cantidad, int valor, int total, int huesped, int habitacionId) {
        this.idRegistroPedido = idRegistroPedido;
        this.nombreProducto = nombrePRoducto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = total;
        this.huespedId  = huesped;
        this.habitacionId = habitacionId;
    }
    
    public RegistroPedido(String nombrePRoducto, int cantidad, int valor, int total, int huesped, int habitacionId) {
        this.nombreProducto = nombrePRoducto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = total;
        this.huespedId  = huesped;
        this.habitacionId = habitacionId;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(int huespedId) {
        this.huespedId = huespedId;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

}
