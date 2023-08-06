/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Fabrica.FactoryDAO;
import dao.PedidoDao;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import tabla.Render;
import interfaz.IPedidoDao;

/**
 *
 * @author MI PC
 */
public class PedidoBo {

    private IPedidoDao daoPedido;
    //PedidoDao dao;
    int r=0;

    public PedidoBo() {
        // dao = new PedidoDao();
        daoPedido = FactoryDAO.getFabrica().CrearPedidosDao();

    }

    public Pedido buscarPedido(int id) {
        return daoPedido.buscarPedido(id);
    }

    public void guardarPedido(Pedido pedido, File file) {
        try {
            byte icono[] = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            pedido.setFoto(icono);
        } catch (Exception e) {
            pedido.setFoto(null);
        }
        daoPedido.guardarPedido(pedido);
    }

    public void modificarPedido(String nombre, int cantidad, int valor, File file, int id) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(cantidad);
        pedido.setNombrePedido(nombre);
        pedido.setCantidad(cantidad);
        pedido.setValor(valor);
        try {
            byte icono[] = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            pedido.setFoto(icono);
        } catch (Exception e) {
            pedido.setFoto(null);
        }
        daoPedido.modificarPedido(pedido);
    }

    public void modificarPedidoFoto(Pedido pedido) {
        daoPedido.modificarPedidoFoto(pedido);
    }

    public int actulizarStock(int cantidad, int idPedido) {
        daoPedido.actulizarStock(cantidad, idPedido);
        return r;

    }

    public boolean eliminarPedido(int id) {
        return daoPedido.eliminarPedido(id);
    }

    public void visualizarProducto(JTable table) {
        table.setDefaultRenderer(Object.class, new Render());

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("cantidad");
        model.addColumn("valor");
        model.addColumn("foto");

        daoPedido = new PedidoDao();
        Pedido pedido = new Pedido();
        ArrayList<Pedido> lista = daoPedido.listarPedido();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                Object fila[] = new Object[6];
                pedido = lista.get(i);
                fila[0] = pedido.getIdPedido();
                fila[1] = pedido.getNombrePedido();
                fila[2] = pedido.getCantidad();
                fila[3] = pedido.getValor();
                try {
                    byte[] bi = pedido.getFoto();
                    BufferedImage imagen = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    imagen = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(imagen.getScaledInstance(60, 60, 60));
                    fila[4] = new JLabel(imgi);
                } catch (Exception e) {
                    fila[4] = new JLabel("No Imagen");
                }
                model.addRow(fila);
            }
            table.setModel(model);
            table.setRowHeight(60);
        }
    }
    
    
}
