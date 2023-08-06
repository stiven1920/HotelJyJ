/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Fabrica.FactoryDAO;
import dao.HabitacionDao;
import excepciones.HabitacionNoEncontradaException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;
import tabla.Render;
import interfaz.IHabitacionDao;

/**
 *
 * @author MI PC
 */
public class HabitacionBo {

    private IHabitacionDao daoHabitacion;
   // HabitacionDao dao;

    public HabitacionBo() {
     //   dao = new HabitacionDao();
     daoHabitacion=FactoryDAO.getFabrica().CrearHabitacionDao();
    }

    public Habitacion buscarHabitacion(int id){
        return daoHabitacion.buscarHAbitacion(id);
    }

    public void guardarHabitacion(Habitacion habitacion, File file) {
       
         try{
            byte[] icono = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            habitacion.setFoto(icono);
        }catch(Exception ex){
            habitacion.setFoto(null);
        }
        daoHabitacion.guardarHabitacion(habitacion);
    }
    
    public void modificarHabitacion(String tipoHabitacion, int valor, String estado, String descripcion, int id){
        Habitacion h = new Habitacion();
        
        h.setIdHabitacion(id);
        h.setTipoHabitacion(tipoHabitacion);
        h.setValor(valor);
        h.setDescripcion(descripcion);
        h.setEstado(estado);
        
        daoHabitacion.modificarHabitacion(h);
    }
     public void modificarHabitacionFoto(String tipoHabitacion, int valor, String estado, String descripcion, File file, int id){
        Habitacion h = new Habitacion();
        
        h.setIdHabitacion(id);
        h.setTipoHabitacion(tipoHabitacion);
        h.setValor(valor);
        h.setDescripcion(descripcion);
        h.setEstado(estado);
        
         try {
             byte[] icono = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            h.setFoto(icono);
         } catch (Exception e) {
             h.setFoto(null);
         }
        daoHabitacion.modificarHabitacionFoto(h);
    }
     
     public void eliminarHabitacion(int id){
         daoHabitacion.eliminarHabitacion(id);
     }

    public void visualizarHabitacion(JTable table) {
        table.setDefaultRenderer(Object.class, new Render());

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("idHabitacion");
        model.addColumn("tipoHabitacion");
        model.addColumn("valor");
        model.addColumn("estado");
        model.addColumn("descripcion");
        model.addColumn("foto");
        Habitacion habitacion = new Habitacion();
        ArrayList<Habitacion> lista = daoHabitacion.listarHabitacion();
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                Object[] fila = new Object[7];
                habitacion = lista.get(i);
                fila[0] = habitacion.getIdHabitacion();
                fila[1] = habitacion.getTipoHabitacion();
                fila[2] = habitacion.getValor();
                fila[3] = habitacion.getEstado();
                fila[4] = habitacion.getDescripcion();
                try {
                    byte[] bi = habitacion.getFoto();
                    BufferedImage imagen = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    imagen = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(imagen.getScaledInstance(60, 60, 60));
                    fila[5] = new JLabel(imgi);
                } catch (Exception e) {
                    fila[5] = new JLabel("No Imagen");
                }
                model.addRow(fila);
            }
            table.setModel(model);
            table.setRowHeight(60);
        }
    }
    
    public List<Habitacion> listarHabitaciones() {
        return daoHabitacion.listarHabitacion();
    }
}
