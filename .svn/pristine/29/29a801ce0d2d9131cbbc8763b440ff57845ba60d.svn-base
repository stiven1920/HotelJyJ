/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;

/**
 *
 * @author MI PC
 */
public interface IReservaDao {
    
    /**
     * Metodo para persistir las reservas hechas por el huesped
     * @param reserva por parametro recimos el objeto que deseamos persistir
     */
    public void guardarReserva(Reserva reserva);
    
    /**
     * Metod de buscar reserva
     * @param id por el id buscamos la reserva
     * @return nos retorna los datos de la reserva
     */
    public Reserva buscarReserva(int id);
    
    /**
     * Metodo para modificar los datos de la reserva
     * @param reserva por parametro resivomos la reserva y lo modificamos por el id
     */
    public void modificarReserva(Reserva reserva);
    
    /**
     * Metodo para cancelar reserva
     * @param id por el id de la reserva podemos tumbarla del sistema
     */
    public boolean cancelarReserva(int id);
    
    /**
     * Metodo Listar Reservas
     * @return nos retorna las reservas hechas
     */
    public ArrayList<Reserva> listarReserva();
    
    
    public ArrayList<Reserva> validarFechasReserva(Reserva reserva);
    
    
    public List<Reserva> reservasHuesped(int cedula);
    
    public boolean modificarEstadoReserva(Reserva reserva);
    
    public Reserva reservaConfirmada(int reservaid);
    
}
