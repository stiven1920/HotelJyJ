/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DTO.MultaDTO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Factura;
import modelo.Multa;
import interfaz.IMultaDao;

/**
 *
 * @author MI PC
 */
public class MultaDao implements IMultaDao {

    /*
create table multa(
idMulta int primary key,
estado varchar(5) not null,
confirmarRecervaId int,
     */
    @Override
    public void guardaMulta(Multa multa) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO multa(idMulta, estado, reservaId, valor) values (?,?,?,?)");
            pstmt.setInt(1, multa.getIdMulta());
            pstmt.setString(2, multa.getEstado());
            pstmt.setInt(3, multa.getConfirmaReservaId());
            pstmt.setInt(4, multa.getValor());
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public Multa buscarMulta(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idMulta, estado, reservaId FROM multa WHERE idMulta=?");
            pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Multa multa = new Multa();
                multa.setIdMulta(id);
                multa.setEstado(respuesta.getString("estado"));
                multa.setConfirmaReservaId(respuesta.getInt("recervaId"));

                return multa;
            }
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;

    }

    @Override
    public ArrayList<MultaDTO> listarMultaPdf(int cedula) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT h.cedula, h.nombre, h.apellido, r.idReserva, r.fechaInicio, hb.idHabitacion, m.valor\n"
                    + "FROM huesped h JOIN reserva r\n"
                    + "ON h.cedula = r.huespedId\n"
                    + "JOIN habitacion hb\n"
                    + "ON hb.idHabitacion = r.habitacionId\n"
                    + "JOIN multa m\n"
                    + "ON r.idReserva = m.reservaId\n"
                    + "WHERE cedula = ?;");
            pstmt.setInt(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<MultaDTO> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    MultaDTO multa = new MultaDTO();
                    multa.setCedula(respuesta.getInt("cedula"));
                    multa.setNombre(respuesta.getString("nombre"));
                    multa.setApellido(respuesta.getString("apellido"));
                    multa.setIdReserva(respuesta.getInt("idReserva"));
                    multa.setFechaInicio(respuesta.getDate("fechaInicio"));
                    multa.setIdHabitacion(respuesta.getInt("idHabitacion"));
                    multa.setValor(respuesta.getInt("valor"));

                    lista.add(multa);
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

    @Override
    public List<Multa> listarMultasReservaHuesped(int cedula) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT m.idMulta, m.estado, m.reservaId, m.valor FROM multa m join reserva r on m.reservaId = r.idReserva "
                    + "WHERE m.estado = 'activo' AND r.huespedId = ?");
            pstmt.setInt(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Multa> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Multa multa = new Multa();
                    multa.setIdMulta(respuesta.getInt("idMulta"));
                    multa.setEstado(respuesta.getString("estado"));
                    multa.setConfirmaReservaId(respuesta.getInt("reservaId"));
                    multa.setValor(respuesta.getInt("valor"));
                    lista.add(multa);
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

    @Override
    public List<Multa> listarMultasReserva(int idReserva) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idMulta, estado, valor FROM multa m WHERE m.reservaId = ? AND estado = 'activo'");
            pstmt.setInt(1, idReserva);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Multa> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Multa multa = new Multa();
                    multa.setIdMulta(respuesta.getInt("idMulta"));
                    multa.setEstado(respuesta.getString("estado"));
                    multa.setConfirmaReservaId(idReserva);
                    multa.setValor(respuesta.getInt("valor"));
                    lista.add(multa);
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

    @Override
    public boolean cambiarEstado(int idMulta) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE multa SET estado =? WHERE idMulta =?");
            pstmt.setString(1, "cancelada");
            pstmt.setInt(2, idMulta);
            pstmt.executeUpdate();
            System.out.println(pstmt);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
        return false;
    }

}
