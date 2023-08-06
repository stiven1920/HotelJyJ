/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.HistorialBo;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jopcion
 */
public class CtlHistorrial {

    HistorialBo bo;

    public CtlHistorrial() {
        bo = new HistorialBo();
    }

    public DefaultTableModel listarHistorial() {
        return bo.ListarHistorial();
    }

    public void ListarPdf(String filePath, int cedula) throws DocumentException, FileNotFoundException {
        bo.listarPdf(filePath, cedula);
    }

}
