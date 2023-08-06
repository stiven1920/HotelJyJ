/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Fabrica.FactoryDAO;
import excepciones.ExistenReservasHuespedException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;
import interfaz.IReservaDao;

/**
 *
 * @author MI PC
 */
public class ReservaBo {

    private IReservaDao dao;

    public ReservaBo() {
        this.dao = FactoryDAO.getFabrica().CrearReservaDao();
    }

    public boolean guardar(Reserva reserva) throws Exception, ExistenReservasHuespedException {
        List<Reserva> lis = dao.validarFechasReserva(reserva);
        if (lis != null) {
            if (lis.size() > 0) {
                throw new Exception("la habitacion ya esta ocupada en esa fechas debe cambiarlas");
            } else {
                List<Reserva> reservas = dao.reservasHuesped(reserva.getHuespedId());
                if (reservas.size() > 0) {
                    throw new ExistenReservasHuespedException();
                }else{
                    dao.guardarReserva(reserva);
                    return true;
                }
            }
        }
        return false;
    }
    
    public List<Reserva> listarReservasHuesped(int cedula) {
        return dao.reservasHuesped(cedula);
    }
    
    public boolean  cambiarEstadoReserva(Reserva reserva) {
        return dao.modificarEstadoReserva(reserva);
    }
    
   public boolean cancelarReserva(int id) {
       return dao.cancelarReserva(id);
   } 
   
   public Reserva reservaConfirmada(int reservaId) {
       return dao.reservaConfirmada(reservaId);
   }
}
