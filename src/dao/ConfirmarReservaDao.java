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
import java.util.ArrayList;
import java.util.List;
import modelo.ConfirmarReserva;
import interfaz.IConfirmarReservaDao;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 * @author MI PC
 */
public class ConfirmarReservaDao implements IConfirmarReservaDao {

    
    static final Logger log =  Logger.getLogger(ConfirmarReservaDao.class.getName());
    @Override
    public void guardarReserva(ConfirmarReserva Reserva) {
        String sql = "INSERT INTO confirmarreserva (nombreHuesped ,apellidoHuesped ,fechaInicio ,fechaSalida ,fechaLlegada ,reservaId ,recepcionistaId ) "
                + "values (?,?,?,?,?,?,?);";
          try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Reserva.getNombre());
            pstmt.setString(2, Reserva.getApellido());
            pstmt.setDate(3, Reserva.getFechInicio());
            pstmt.setDate(4, Reserva.getFechaSalida());
            pstmt.setDate(5, Reserva.getFechaLlegada());
            pstmt.setInt(6, Reserva.getReservaId());
            pstmt.setInt(7, Reserva.getRecepcionistaId());
            pstmt.executeUpdate();
            System.out.println(pstmt);
            log.info(sql);
        } catch (SQLException ex) {
             ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
     }

    @Override
    public ConfirmarReserva buscarReserva(int idReserva) {
    try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idConfirmarReserva, fechaLlegada, fechaSalida, reservaId "
                    + "FROM confirmarReserva WHERE idConfirmarReserva=?");

            pstmt.setInt(1, idReserva);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                ConfirmarReserva confirmar = new ConfirmarReserva();

                confirmar.setIdConfirmarReserva(idReserva);
                confirmar.setFechaLlegada(respuesta.getDate("fechaLlegada"));
                confirmar.setFechaSalida(respuesta.getDate("fechaSalida"));
                confirmar.setReservaId(respuesta.getInt("reservaId"));
                return confirmar;
            }
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void ModificarReserva(ConfirmarReserva idReserva) {
   try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE confirmarReserva SET  "
                    + "fechaLlegada=?, fechaSalida=? "
                    + " WHERE idConfirmarReserva=?");

            pstmt.setDate(1, idReserva.getFechaLlegada());
            pstmt.setDate(2, idReserva.getFechaSalida());
            pstmt.setInt(3, idReserva.getIdConfirmarReserva());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }

    }

    @Override
    public List<ConfirmarReserva> confirmarReservasActivas(int cedula) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT c.idConfirmarReserva , c.nombreHuesped , c.apellidoHuesped , c.fechaInicio , c.fechaSalida ,"
                    + "c.fechaLlegada ,c.reservaId , c.recepcionistaId FROM confirmarreserva c join reserva r on c.reservaId = r.idReserva "
                    + "where r.estado = 'iniciada' and r.huespedId = ?");
            pstmt.setInt(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();
            ArrayList<ConfirmarReserva> lista = new ArrayList();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    ConfirmarReserva reserva = new ConfirmarReserva();
                    reserva.setIdConfirmarReserva(respuesta.getInt("idConfirmarReserva"));
                    reserva.setNombre(respuesta.getString("nombreHuesped"));
                    reserva.setApellido(respuesta.getString("apellidoHuesped"));
                    reserva.setFechInicio(respuesta.getDate("fechaInicio"));
                    reserva.setFechaSalida(respuesta.getDate("fechaSalida"));
                    reserva.setFechaLlegada(respuesta.getDate("fechaLlegada"));
                    reserva.setReservaId(respuesta.getInt("reservaId"));
                    reserva.setRecepcionistaId(respuesta.getInt("recepcionistaId"));
                    lista.add(reserva);
                } else {
                    condicion = false;
                }
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }
    
}
