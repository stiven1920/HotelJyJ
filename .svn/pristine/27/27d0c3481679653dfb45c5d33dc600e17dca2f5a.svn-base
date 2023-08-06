/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Fabrica.FactoryDAO;
import dao.RecepcionistaDao;
import excepciones.EmpleadoExistenteException;
import excepciones.EmpleadoNoexistenteException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Recepcionista;
import interfaz.IRecepcionistaDao;

/**
 *
 * @author MI PC
 */
public class RecepcionistaBo {
private final IRecepcionistaDao daoRecepcionista;
   // RecepcionistaDao dao;

    public RecepcionistaBo() {
       // dao = new RecepcionistaDao();
   daoRecepcionista= FactoryDAO.getFabrica().CrearRecepcionistaDao();
    }

    public void guardarRecepcionista(Recepcionista recepcion) throws EmpleadoExistenteException, EmpleadoNoexistenteException{
        Recepcionista aux = buscarRecepcionista(recepcion.getCodigo());
        if (aux == null) {
            daoRecepcionista.guardarRecepcionesta(recepcion);
        }else{
           throw new EmpleadoExistenteException();
        }

    }

    public Recepcionista buscarRecepcionista(int codigo) throws EmpleadoNoexistenteException {
        return daoRecepcionista.buscarRecepcionista(codigo);

    }
    
       public Recepcionista buscarRecepcionistaLogin(String usuario){
        return daoRecepcionista.buscarRecepcionistaLogin(usuario);

    }
    
    public void modificarRecepcionista(Recepcionista recepcion){
        daoRecepcionista.modificarRecepcionista(recepcion);
    }
    
    public DefaultTableModel listarRecepcionista(){
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Recepcionista> lista = daoRecepcionista.listarRecepcionista();
        model.setColumnIdentifiers(new Object[]{
            "codigo", "nombre", "apellido", "telefono", "direccion"
        });
        for(Recepcionista recepcion :lista){
            model.addRow(new Object[]{
                recepcion.getCodigo(),
                recepcion.getNombre(),
                recepcion.getApellido(),
                recepcion.getTelefono(),
                recepcion.getDireccion()
            });
        }
        return model;
    }

}
