/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.RecepcionistaBo;
import excepciones.EmpleadoExistenteException;
import excepciones.EmpleadoNoexistenteException;
import javax.swing.table.DefaultTableModel;
import modelo.Recepcionista;

/**
 *
 * @author MI PC
 */
public class CtlRecepcion {

    RecepcionistaBo bo;

    public CtlRecepcion() {
        bo = new RecepcionistaBo();
    }

    public void guardarRecepcionista(Recepcionista recepcion) throws EmpleadoExistenteException, EmpleadoNoexistenteException {
        bo.guardarRecepcionista(recepcion);
    }

    public Recepcionista buscarRecepcionista(int codigo) throws EmpleadoNoexistenteException {
        return bo.buscarRecepcionista(codigo);
    }
    
      public Recepcionista buscarRecepcionistaLogin(String usuario) {
        return bo.buscarRecepcionistaLogin(usuario);
    }

    public void modificarRecepcionista(Recepcionista recepcion) {
        bo.modificarRecepcionista(recepcion);
    }

    public DefaultTableModel listarRecepcionista() {
        return bo.listarRecepcionista();
    }

}
