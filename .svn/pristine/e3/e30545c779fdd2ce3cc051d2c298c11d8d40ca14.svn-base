/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.ReservaBo;
import excepciones.ExistenReservasHuespedException;
import java.util.List;
import modelo.Reserva;

/**
 *
 * @author MI PC
 */
public class CtlReserva {

    private ReservaBo bo;
    
    public CtlReserva() {
        bo = new ReservaBo();
    }
    
    public boolean guardar(Reserva reserva) throws Exception, ExistenReservasHuespedException {
        return bo.guardar(reserva);
    }
    
    public List<Reserva> listarReservasHuesped(int cedula) {
        return bo.listarReservasHuesped(cedula);
    }
    
    public boolean  cambiarEstadoReserva(Reserva reserva) {
        return bo.cambiarEstadoReserva(reserva);
    }
    
    public boolean cancelarReserva(int id) {
       return bo.cancelarReserva(id);
   }
    
   public Reserva reservaConfirmada(int reservaId) {
       return bo.reservaConfirmada(reservaId);
   }
}
