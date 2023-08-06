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
import modelo.Reserva;
import interfaz.IReservaDao;

/**
 *
 * @author MI PC
 */
public class ReservaDao implements IReservaDao {

    /*
create table reserva(
idReserva int primary key auto_increment,
fechaEntrada Date not null,
fechaSalida  Date not null,
huespedId int,
habitacionId int,
     */
    @Override
    public void guardarReserva(Reserva reserva) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO reserva (nombreHuesped, apellidoHuesped, fechaInicio, fechaSalida, huespedId, habitacionId) values (?,?,?,?,?,?)");
            pstmt.setString(1, reserva.getNombreHuesped());
            pstmt.setString(2, reserva.getApellidoHuesped());
            pstmt.setDate(3, reserva.getFechaInicio());
            pstmt.setDate(4, reserva.getFechaSalida());
            pstmt.setInt(5, reserva.getHuespedId());
            pstmt.setInt(6, reserva.getHabitacionId());
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public Reserva buscarReserva(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idReserva, fechaInicio, fechaSalida, huespedId, habitacionId FROM reserva WHERE idReserva =?");
            pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Reserva reserva = new Reserva();

                reserva.setIdReserva(id);
                reserva.setFechaInicio(respuesta.getDate("fechaInicio"));
                reserva.setFechaSalida(respuesta.getDate("fechaSalida"));
                reserva.setHuespedId(respuesta.getInt("huespedId"));
                reserva.setHabitacionId(respuesta.getInt("habitacionId"));

                return reserva;
            }
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void modificarReserva(Reserva reserva) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE reserva SET fechaInicio=?, fechaSalida=?  WHERE idReserva=?");
            pstmt.setDate(1, reserva.getFechaInicio());
            pstmt.setDate(2, reserva.getFechaSalida());
            pstmt.setInt(3, reserva.getIdReserva());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public boolean cancelarReserva(int id) {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM reserva WHERE idReserva = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(pstmt);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Hubo un error al eliminar");
        }
        return false;
    }

    @Override
    public ArrayList<Reserva> listarReserva() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idReserva, fechaInicio, fechaSalida, huespedId, habitacionId FROM reserva");
            ResultSet respuesta = pstmt.executeQuery();
            ArrayList<Reserva> ListaEstudiante = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(respuesta.getInt("idReserva"));
                    reserva.setFechaInicio(respuesta.getDate("fechaInicio"));
                    reserva.setFechaSalida(respuesta.getDate("fechaSalida"));
                    reserva.setHuespedId(respuesta.getInt("huespedId"));
                    reserva.setHabitacionId(respuesta.getInt("habitacionId"));
                    ListaEstudiante.add(reserva);
                } else {
                    condicion = false;
                }
            }
            return ListaEstudiante;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }

    @Override
    public ArrayList<Reserva> validarFechasReserva(Reserva reserva) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idReserva, fechaInicio, fechaSalida, huespedId, habitacionId FROM reserva where fechaInicio <= ? and fechaSalida >= ? and habitacionId = ? and estado = 'sininiciar'");
            pstmt.setDate(1, reserva.getFechaSalida());
            pstmt.setDate(2, reserva.getFechaInicio());
            pstmt.setInt(3, reserva.getHabitacionId());
            ResultSet respuesta = pstmt.executeQuery();
            ArrayList<Reserva> ListaEstudiante = new ArrayList();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Reserva r = new Reserva();
                    r.setIdReserva(respuesta.getInt("idReserva"));
                    r.setFechaInicio(respuesta.getDate("fechaInicio"));
                    r.setFechaSalida(respuesta.getDate("fechaSalida"));
                    r.setHuespedId(respuesta.getInt("huespedId"));
                    r.setHabitacionId(respuesta.getInt("habitacionId"));
                    ListaEstudiante.add(r);
                } else {
                    condicion = false;
                }
            }
            return ListaEstudiante;
        } catch (SQLException e) {
            System.err.println("Hubo un error al listar validar fechas");
        }
        return null;
    }

    @Override
    public List<Reserva> reservasHuesped(int cedula) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idReserva, nombreHuesped, apellidoHuesped, fechaInicio, fechaSalida, habitacionId FROM reserva where huespedId = ? and estado = 'sininiciar'");
            pstmt.setInt(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();
            ArrayList<Reserva> ListaEstudiante = new ArrayList();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Reserva r = new Reserva();
                    r.setIdReserva(respuesta.getInt("idReserva"));
                    r.setNombreHuesped(respuesta.getString("nombreHuesped"));
                    r.setApellidoHuesped(respuesta.getString("apellidoHuesped"));
                    r.setFechaInicio(respuesta.getDate("fechaInicio"));
                    r.setFechaSalida(respuesta.getDate("fechaSalida"));
                    r.setHuespedId(cedula);
                    r.setHabitacionId(respuesta.getInt("habitacionId"));
                    ListaEstudiante.add(r);
                } else {
                    condicion = false;
                }
            }
            return ListaEstudiante;
        } catch (SQLException e) {
            System.err.println("Hubo un error al listar validar fechas");
        }
        return null;
    }

    @Override
    public boolean modificarEstadoReserva(Reserva reserva) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE reserva SET estado =?  WHERE idReserva=?");
            pstmt.setString(1, reserva.getEstado());
            pstmt.setInt(2, reserva.getIdReserva());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
        return false;
    }

    @Override
    public Reserva reservaConfirmada(int reservaid) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idReserva, nombreHuesped, apellidoHuesped, fechaInicio, fechaSalida, huespedId, habitacionId, estado FROM reserva where idReserva = ?");
            pstmt.setInt(1, reservaid);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Reserva r = new Reserva();
                r.setIdReserva(respuesta.getInt("idReserva"));
                r.setNombreHuesped(respuesta.getString("nombreHuesped"));
                r.setApellidoHuesped(respuesta.getString("apellidoHuesped"));
                r.setFechaInicio(respuesta.getDate("fechaInicio"));
                r.setFechaSalida(respuesta.getDate("fechaSalida"));
                r.setHuespedId(respuesta.getInt("huespedId"));
                r.setHabitacionId(respuesta.getInt("habitacionId"));
                r.setEstado(respuesta.getString("estado"));
                return r;
            }
            
        } catch (SQLException e) {
        }
        return null;
    }
}
