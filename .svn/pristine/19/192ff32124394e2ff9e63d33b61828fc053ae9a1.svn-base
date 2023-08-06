/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.Factura;

/**
 *
 * @author MI PC
 */
public interface IFacturaDao {
    
    /**
     * metodo para persistir la factura del huesped
     * @param factura resibimos por parametro la datos de la factura a guardar
     */
    public void guardarFactura(Factura factura);
    
    /**
     * Metodo para buscar una factura realizada por el recepcionista
     * @param id buscamos la factura por el id
     * @return nos retorna una factura de lo contrario nos retorna factura no hecha o no encontrada
     */
    public Factura buscar(int id);
    
    /**
     * Metodo para listar las facturas ya persistidas por el recepcionista o encargado de la facturacion
     * @return la factura del husped
     */
    public ArrayList<Factura> listarFactura();
    
}
