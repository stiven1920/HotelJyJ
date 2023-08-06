/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.PedidoBo;
import java.io.File;
import javax.swing.JTable;
import modelo.Pedido;

/**
 *
 * @author MI PC
 */
public class CtlPedido {

    PedidoBo bo;
    int r;
    public CtlPedido() {
        bo = new PedidoBo();
    }

    public void guardarPedido(Pedido pedido, File file) {
        bo.guardarPedido(pedido, file);
    }

    public Pedido buscarPedido(int id) {
        return bo.buscarPedido(id);
    }
    
    public void modificarPedido(String nombre, int cantidad, int valor, File file, int id){
        bo.modificarPedido(nombre, cantidad, valor, file, id);
    }
    
    public void modificarPedidoFoto(Pedido pedido){
        bo.modificarPedidoFoto(pedido);
    }
    
    public int modificarStock(int cantidad, int id){
        bo.actulizarStock(cantidad, id);
        return r;
    }
    
    public void eliminarPedido(int id){
        bo.eliminarPedido(id);
    }
    
    public void listarPedido(JTable table){
        bo.visualizarProducto(table);
    }

}
