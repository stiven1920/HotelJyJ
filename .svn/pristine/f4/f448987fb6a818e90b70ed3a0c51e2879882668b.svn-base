/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import DTO.MultaDTO;
import java.util.ArrayList;
import java.util.List;
import modelo.Multa;

/**
 *
 * @author MI PC
 */
public interface IMultaDao {
    
    /**
     * Metodo para persistir las multa generadas 
     * @param multa por parametro Persistimos el objeto(atributos)
     */
    public void guardaMulta(Multa multa);
   
    /**
     * Metos la cual buscamos las personas con una Multa
     * @param id buscamos la multa generada
     * @return nos retorna la multa
     */
    public Multa buscarMulta(int id);
    
    /**
     * Metodo para listar las multas 
     * @param cedula
     * @return nos muestra la lista de los huesped multados por el hotel
     */
    public ArrayList<MultaDTO> listarMultaPdf(int cedula);
    
    public List<Multa> listarMultasReservaHuesped(int cedula);
    
    public List<Multa> listarMultasReserva(int idReserva);
    
    public boolean cambiarEstado(int idMulta);
}
