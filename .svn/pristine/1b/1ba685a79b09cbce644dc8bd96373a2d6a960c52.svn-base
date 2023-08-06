/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.MultasBo;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Multa;

/**
 *
 * @author MI PC
 */
public class CtlMultas {
    private MultasBo bo;

    public CtlMultas() {
        bo = new MultasBo();
    }
    
    public List<Multa> listarMultasReservaHuesped(int cedula) {
        return bo.listarMultasReservaHuesped(cedula);
    }
    
    public String guardarMultaReserva(Multa multa) {
        return bo.guardarMultaReserva(multa);
    }
    
    public boolean cambiarEstadoCancelada(int idMulta) {
        return bo.cambiarEstadoCancelada(idMulta);
    }
    public void listarPdf(String filePath, int cedula) throws DocumentException, FileNotFoundException{
         bo.listarPdf(filePath,cedula);
    }
}
