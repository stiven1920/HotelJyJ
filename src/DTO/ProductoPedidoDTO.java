/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jopcion
 */
public class ProductoPedidoDTO {
     int codigo,cantidad,precio,precioProducto;
    String nombre;

    public ProductoPedidoDTO() {
    }

    public ProductoPedidoDTO(int codigo, int cantidad, int precio, int precioProducto, String nombre) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioProducto = precioProducto;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
