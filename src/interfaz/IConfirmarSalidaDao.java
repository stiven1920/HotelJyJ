/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import modelo.ConfirmarSalida;

/**
 *
 * @author STIVEN
 */
public interface IConfirmarSalidaDao {
    
    /**
     * Metodo Para confirmar la salida de un huesped despues de entregar y quedar a paz y salvo
     * @param confiSali Parametro que identifica que el registro de llegda va a salir del hotel
     */
    public void guardarSalida(ConfirmarSalida confiSali);
    
    /**
     * Metodo de que permite buscar una reserva ya confirmada
     * @param idSalida
     * @return todo el objecto de la clase
     */
    public ConfirmarSalida buscarSalida(int idSalida);
    
    
    
}
