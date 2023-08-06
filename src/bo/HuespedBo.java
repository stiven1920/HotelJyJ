/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Fabrica.FactoryDAO;
import excepciones.PersonaExistenteException;
import excepciones.PersonaNoEncontradaException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Huesped;
import interfaz.IHuespedDao;

/**
 *
 * @author MI PC
 */
public class HuespedBo {
private  IHuespedDao daoHuesped;
    //HuespedDao dao;

    public HuespedBo() {
        daoHuesped = FactoryDAO.getFabrica().CrearHuespedDao();
     //dao = new HuespedDao();
    }

    public void guardarHuesped(Huesped huesped) throws PersonaExistenteException, PersonaNoEncontradaException {
        Huesped aux = buscarHuesped(huesped.getCedula());
        if (aux == null) {
            daoHuesped.guardarHuesped(huesped);
        }
    }

    public Huesped buscarHuesped(int cedula) throws PersonaNoEncontradaException  {
        return daoHuesped.buscarHuesped(cedula);
    }

    public Huesped buscarLogin(String correo, String contrasenia) {
        return daoHuesped.buscarLogin(correo, contrasenia);
    }

    public void modificarHuesped(Huesped huesped) {
        daoHuesped.modificarHuesped(huesped);
    }

    public DefaultTableModel listarHuesped() {
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Huesped> lista = daoHuesped.listarHuesped();
        model.setColumnIdentifiers(new Object[]{
            "cedula", "nombre", "apellido", "telefono", "direccion", "correo"
        });

        for (Huesped huesped : lista) {
            model.addRow(new Object[]{
                huesped.getCedula(),
                huesped.getNombre(),
                huesped.getApellido(),
                huesped.getTelefono(),
                huesped.getDireccion(),
                huesped.getCorreo()
            });
        }
        return model;
    }

}
