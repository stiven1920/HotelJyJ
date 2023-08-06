/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.ConfirmareservaBo;
import java.util.List;
import modelo.ConfirmarReserva;

/**
 *
 * @author MI PC
 */
public class CtlConfirmarreserva {

    private ConfirmareservaBo bo;

    public CtlConfirmarreserva() {
        bo = new ConfirmareservaBo();
    }

    public void guardar(ConfirmarReserva confirmarReserva) {
        bo.guardar(confirmarReserva);
    }

    public ConfirmarReserva buscarReserva(int id) {
        return bo.buscarReserva(id);
    }

    public List<ConfirmarReserva> listarConfirmarReservasActivasHuesped(int cedula) {
        return bo.listarConfirmarReservasActivasHuesped(cedula);
    }
}
