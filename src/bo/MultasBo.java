/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import DTO.HistorialDTO;
import DTO.MultaDTO;
import Fabrica.FactoryDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import modelo.Multa;
import interfaz.IMultaDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MI PC
 */
public class MultasBo {

    private IMultaDao dao;

    public MultasBo() {
        dao = FactoryDAO.getFabrica().CrearMultaDao();
    }

    public List<Multa> listarMultasReservaHuesped(int cedula) {
        return dao.listarMultasReservaHuesped(cedula);
    }

    public String guardarMultaReserva(Multa multa) {
        List<Multa> multas = dao.listarMultasReserva(multa.getConfirmaReservaId());
        if (multas.size() > 0) {
            return "El huesped tiene una multa por esta reserva de el valor:" + multas.get(0).getValor();
        } else {
            dao.guardaMulta(multa);
            return "Se le hizo una multa al huesped de valor:" + multa.getValor();
        }
    }

    public boolean cambiarEstadoCancelada(int idMulta) {
        return dao.cambiarEstado(idMulta);
    }

    public void listarPdf(String filePath, int cedula) throws DocumentException, FileNotFoundException {
        ArrayList<MultaDTO> lista = dao.listarMultaPdf(cedula);
        String fileName = filePath;

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            //Abrimos el documento
            document.open();
            /**
             * Cada Paragraph es equivalente a cada una de las líneas que vamos
             * a poner en el documento
             *
             */
            Font tamaño = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            Font tamaño2 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.BLUE);
            Font tamaño3 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);

            Paragraph p = new Paragraph("PAZ Y SALVO CON EL  HOTELJ&J", tamaño);

            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);

            document.add(Chunk.NEWLINE);

            p = new Paragraph();
            p.add(Image.getInstance("firma_hotel.jpg"));
            document.add(p);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            p = new Paragraph();
            /*Se le indica la propiedad de tabulado*/
            p.setTabSettings(new TabSettings(56f));
            /*Se añade la línea por Chunks, es decir por trozos
             *Aquí se añade un tabulado
             */
            p.add(Chunk.TABBING);

            p.add(new Chunk("cedula", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("nombre", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("apellido", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("idReserva", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("fechaInicio", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("idHabitacion", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("estado", tamaño2));
            p.add(Chunk.TABBING);
            p.add(new Chunk("Valor", tamaño2));

            document.add(p);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            for (MultaDTO historial : lista) {
                p = new Paragraph();
                p.setTabSettings(new TabSettings(56f));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getCedula() + "", tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getNombre(), tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getApellido(), tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getIdReserva() + "", tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk((Date) historial.getFechaInicio() + "", tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getIdHabitacion() + "", tamaño3));
                p.add(Chunk.TABBING);
                 p.add(new Chunk(historial.getEstado()+ "", tamaño3));
                p.add(Chunk.TABBING);
                p.add(new Chunk(historial.getValor() + "", tamaño3));
                document.add(p);

                document.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
