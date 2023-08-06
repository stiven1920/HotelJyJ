/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.RegistroPedido;

/**
 *
 * @author Jopcion
 */
public interface IRegistroPedidoDao {

    public void guardarPedidoHuesped(RegistroPedido pedido);

    public RegistroPedido buscarPedidoHuesped(int idRegistroPedido);
    
    public ArrayList<RegistroPedido> listarCarrito(int idHuesped);
    
    public boolean eliminar(int id);

    public ArrayList<RegistroPedido> listarPedidosHuestedHabitacion(int idHabitacion, int huespedId);
}
