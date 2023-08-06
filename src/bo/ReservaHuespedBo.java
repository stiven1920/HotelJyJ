/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import DTO.ReservaHuespedDTO;
import Fabrica.FactoryDAO;
import interfaz.IReservaHuespedDao;
import java.util.List;

/**
 *
 * @author Jopcion
 */
public class ReservaHuespedBo {
    private IReservaHuespedDao daoResHuesped;
    
    public ReservaHuespedBo(){
        daoResHuesped = FactoryDAO.getFabrica().CrearReservaHuesped();
    }
   public List<ReservaHuespedDTO> listarReservasHuesped() {
        return daoResHuesped.listarReservaHuesped();
    }
}
