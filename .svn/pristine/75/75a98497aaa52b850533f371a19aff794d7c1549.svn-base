/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;
import modelo.ConfirmarReserva;
import interfaz.IConfirmarReservaDao;

/**
 *
 * @author MI PC
 */
public class ConfirmareservaBo {
    private IConfirmarReservaDao dao;

    public ConfirmareservaBo() {
        dao = Fabrica.FactoryDAO.getFabrica().CrearConfirmarReservaDao();
    }
    
    public void guardar(ConfirmarReserva confirmarReserva) {
        dao.guardarReserva(confirmarReserva);
    }
    
    public ConfirmarReserva buscarReserva(int id){
      return  dao.buscarReserva(id);
    }
    
    public List<ConfirmarReserva> listarConfirmarReservasActivasHuesped(int cedula) {
        return dao.confirmarReservasActivas(cedula);
    }
}
