/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import interfaz.IRegistroPedidoDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.RegistroPedido;

/**
 *
 * @author Jopcion
 */
public class RegistroPedidoHuespedBo {
    
    private IRegistroPedidoDao dao;

    public RegistroPedidoHuespedBo() {
        dao = Fabrica.FactoryDAO.getFabrica().CrearPeDidoHuesped();
    }
    
    public void guardarPedidoHuesped(RegistroPedido registro){
        dao.guardarPedidoHuesped(registro);
    }
    
    public RegistroPedido buscarPedidoHuesped(int idRegistroPedido){
    return dao.buscarPedidoHuesped(idRegistroPedido);
    }
    public DefaultTableModel listarCarrito(int huespedId) {
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<RegistroPedido> lista = dao.listarCarrito(huespedId);
        model.setColumnIdentifiers(new Object[]{
            "id", "nombreProducto", "cantidad", "valor", "total"
        });

        for (RegistroPedido carrito : lista) {
            model.addRow(new Object[]{
                carrito.getIdRegistroPedido(),
                carrito.getNombreProducto(),
                carrito.getCantidad(),
                carrito.getValor(),
                carrito.getTotal()
            });
        }
        return model;
    }
    
    public boolean eliminar (int id) {
        return dao.eliminar(id);
    }
    
    public List<RegistroPedido> listarPedidoHuespedHabitacion(int huespedId, int habitacionId){
        return dao.listarPedidosHuestedHabitacion(habitacionId, huespedId);
    }
}
