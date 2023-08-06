/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.RegistroPedidoHuespedBo;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.RegistroPedido;

/**
 *
 * @author Jopcion
 */
public class CtlRegistroPedidoHuesped {

    RegistroPedidoHuespedBo bo;

    public CtlRegistroPedidoHuesped() {
        bo = new RegistroPedidoHuespedBo();

    }

    public void guardarPedidoHuesped(RegistroPedido registro) {
        bo.guardarPedidoHuesped(registro);
    }

    public RegistroPedido buscarPedido(int id) {
        return bo.buscarPedidoHuesped(id);
    }

    public DefaultTableModel listarCarrito(int huespedId) {
        return bo.listarCarrito(huespedId);
    }

    public boolean eliminar(int id) {
        return bo.eliminar(id);
    }
    
    public List<RegistroPedido> listarPedidoHuespedHabitacion(int huespedId, int habitacionId){
        return bo.listarPedidoHuespedHabitacion(huespedId, habitacionId);
    }
}
