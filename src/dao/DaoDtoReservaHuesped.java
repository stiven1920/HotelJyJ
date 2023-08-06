/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DTO.ReservaHuespedDTO;
import conexion.Conexion;
import interfaz.IReservaHuespedDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Factura;

/**
 *
 * @author Jopcion
 */
public class DaoDtoReservaHuesped implements IReservaHuespedDao{

    @Override
    public ArrayList<ReservaHuespedDTO> listarReservaHuesped() {

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT p.cedula, p.nombre, p.apellido, r.huespedId, r.fechaInicio, r.fechaSalida,\n"
                    + "h.tipoHabitacion, h.descripcion, h.valor\n"
                    + "FROM  huesped p join reserva r\n"
                    + "on p.cedula = r.huespedId\n"
                    + "Join habitacion h\n"
                    + "on h.idHabitacion = r.habitacionId;");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<ReservaHuespedDTO> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    ReservaHuespedDTO DTOReserva = new ReservaHuespedDTO();
                    DTOReserva.setCedula(respuesta.getInt("cedula"));
                    DTOReserva.setApellido(respuesta.getString("nombre"));
                    DTOReserva.setApellido(respuesta.getString("apellido"));
                    DTOReserva.setHuespedId(respuesta.getInt("huespedId"));
                    DTOReserva.setFechaInicio(respuesta.getDate("fechaInicio"));
                    DTOReserva.setFechaSalida(respuesta.getDate("fechaSalida"));
                    DTOReserva.setTipoHabitacion(respuesta.getString("tipoHabitacion"));
                    DTOReserva.setDescripcion(respuesta.getString("descripcion"));
                    DTOReserva.setValor(respuesta.getInt("valor"));
                    

                    lista.add(DTOReserva);
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
