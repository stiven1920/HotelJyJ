/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.ConfirmarReserva;

/**
 *
 * @author MI PC
 */
public interface IConfirmarReservaDao {

    /**
     * Metodo para confirmar una reserva ya hecha por un huesped
     * @param idReserva. rescibimos por parametro la confirmacion de la reserva
     */
    public void guardarReserva(ConfirmarReserva idReserva);

    /**
     * Metodo con la cual me busca la reserva para poderla confirma
     * @param idReserva recibimos por parametro el id de la reserva
     * @return nos retorna la reserva, de lo contrario nos retorna null
     */
    public ConfirmarReserva buscarReserva(int idReserva);

    /**
     * Metodo con la cual vamos a darle una modificacion a la reserva, si ahi un error en la reserva
     * @param idReserva y recibimos por parametro el id buscado de la reserva
     */
    public void ModificarReserva(ConfirmarReserva idReserva);
    
    public List<ConfirmarReserva> confirmarReservasActivas(int cedula);
    
}
