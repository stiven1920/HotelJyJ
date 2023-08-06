/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import modelo.ConfirmarSalida;
import interfaz.IConfirmarSalidaDao;

/**
 *
 * @author STIVEN
 */
public class ConfirmarSalidaDao implements IConfirmarSalidaDao {

    @Override
    public void guardarSalida(ConfirmarSalida confiSali) {
        String sql = "INSERT INTO confirmarSalida(nombreHuesped, apellidoHuesped, fechaSalida, fechaLlegada, confirmarReservaId, recepcionistaId) "
                + "VALUES(?,?,?,?,?,?)";
        try ( Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, confiSali.getNombreHuesped());
            pstmt.setString(2, confiSali.getApellidoHuesped());
            pstmt.setDate(3, confiSali.getFechaSalida());
            pstmt.setDate(4, confiSali.getFechaLlegada());
            pstmt.setInt(5, confiSali.getConfirmarLlegada());
            pstmt.setInt(6, confiSali.getRecepcionistaId());
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
            Logger.getLogger(sql);
        }
    }

    @Override
    public ConfirmarSalida buscarSalida(int idSalida) {
        String sql = "SELECT * FROM confimarSalida";

        try ( Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ConfirmarSalida salida = null;

            pstmt.setInt(1, idSalida);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                salida = new ConfirmarSalida();
                salida.setNombreHuesped(respuesta.getString(2));
                salida.setApellidoHuesped(respuesta.getString(3));
                salida.setFechaSalida(respuesta.getDate(4));
                salida.setFechaLlegada(respuesta.getDate(5));
                salida.setConfirmarLlegada(respuesta.getInt(6));
                salida.setRecepcionistaId(respuesta.getInt(7));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
            Logger.getLogger(sql);
        }
        return null;
    }

}
