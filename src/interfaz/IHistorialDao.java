/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import DTO.HistorialDTO;
import java.util.ArrayList;

/**
 *
 * @author Jopcion
 */
public interface IHistorialDao {
    
    /**
     * Metodo para listar las personas que se han quedado en el hotel
     * @return nos retorna la consulta desde la base dedatos
     */
    ArrayList<HistorialDTO> listarHistorail();
    
    /**
     * Metodo para listar el pdf
     * @return nos retorna toda la consulta para poderlo imprimir en un pdf
     */
    ArrayList<HistorialDTO> listarPdf(int cedula);
}
