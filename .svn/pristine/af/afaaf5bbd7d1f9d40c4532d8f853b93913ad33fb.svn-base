/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DTO.HistorialDTO;
import conexion.Conexion;
import interfaz.IHistorialDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jopcion
 */
public class HistorialDao implements IHistorialDao {

    @Override
    public ArrayList<HistorialDTO> listarHistorail() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT p.cedula, p.nombre , p.apellido , r.idReserva , r.fechaInicio, r.fechaSalida\n"
                    + ",h.idHabitacion , h.tipoHabitacion , h.valor,\n"
                    + "rp.idRegistroPedido , rp.nombreProducto , rp.valorProducto  \n"
                    + "FROM huesped p JOIN reserva r\n"
                    + "ON p.cedula = r.huespedId\n"
                    + "JOIN confirmarreserva c\n"
                    + "ON r.idReserva = c.reservaId\n"
                    + "JOIN habitacion h\n"
                    + "ON  h.idHabitacion = r.habitacionId\n"
                    + "JOIN registropedido rp\n"
                    + "ON  h.idHabitacion = rp.habitacionId ");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<HistorialDTO> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    HistorialDTO historialDto = new HistorialDTO();
                    historialDto.setCedula(respuesta.getInt(1));
                    historialDto.setNombre(respuesta.getString(2));
                    historialDto.setApellido(respuesta.getString(3));
                    historialDto.setIdReserva(respuesta.getInt(4));
                    historialDto.setFechaInicio(respuesta.getDate(5));
                    historialDto.setFechaSalida(respuesta.getDate(6));
                    historialDto.setIdHabitacion(respuesta.getInt(7));
                    historialDto.setTipoHabitacion(respuesta.getString(8));
                    historialDto.setValor(respuesta.getInt(9));
                    historialDto.setIdRegistroPedido(respuesta.getInt(10));
                    historialDto.setNombreProducto(respuesta.getString(12));
                    historialDto.setValorProducto(respuesta.getInt(12));

                    lista.add(historialDto);
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
    public ArrayList<HistorialDTO> listarPdf(int cedula) {
     try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT p.cedula, p.nombre , p.apellido , r.idReserva , r.fechaInicio, r.fechaSalida\n"
                    + ",h.idHabitacion , h.tipoHabitacion , h.valor,\n"
                    + "rp.idRegistroPedido , rp.nombreProducto , rp.valorProducto  \n"
                    + "FROM huesped p JOIN reserva r\n"
                    + "ON p.cedula = r.huespedId\n"
                    + "JOIN confirmarreserva c\n"
                    + "ON r.idReserva = c.reservaId\n"
                    + "JOIN habitacion h\n"
                    + "ON  h.idHabitacion = r.habitacionId\n"
                    + "JOIN registropedido rp\n"
                    + "ON  h.idHabitacion = rp.habitacionId "
                    + "WHERE  cedula = ?");
            pstmt.setInt(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<HistorialDTO> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    HistorialDTO historialDto = new HistorialDTO();
                    historialDto.setCedula(respuesta.getInt(1));
                    historialDto.setNombre(respuesta.getString(2));
                    historialDto.setApellido(respuesta.getString(3));
                    historialDto.setIdReserva(respuesta.getInt(4));
                    historialDto.setFechaInicio(respuesta.getDate(5));
                    historialDto.setFechaSalida(respuesta.getDate(6));
                    historialDto.setIdHabitacion(respuesta.getInt(7));
                    historialDto.setTipoHabitacion(respuesta.getString(8));
                    historialDto.setValor(respuesta.getInt(9));
                    historialDto.setIdRegistroPedido(respuesta.getInt(10));
                    historialDto.setNombreProducto(respuesta.getString(12));
                    historialDto.setValorProducto(respuesta.getInt(12));

                    lista.add(historialDto);
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
