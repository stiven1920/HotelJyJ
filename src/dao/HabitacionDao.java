/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
//abra bloc de notas

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Habitacion;
import interfaz.IHabitacionDao;

/**
 *
 * @author MI PC
 */
public class HabitacionDao implements IHabitacionDao {

    /*
create table habitacion(
idHabitacion int primary key,
tipoHabitacion varchar(45) not null,
valor int not null,
estado varchar(5) not null,
descripcion varchar(100) not null
);
     */
    @Override
    public void guardarHabitacion(Habitacion habitacion) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO habitacion"
                    + "(idHabitacion, tipoHabitacion, valor, estado, descripcion, foto)"
                    + " VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, habitacion.getIdHabitacion());
            pstmt.setString(2, habitacion.getTipoHabitacion());
            pstmt.setInt(3, habitacion.getValor());
            pstmt.setString(4, habitacion.getEstado());
            pstmt.setString(5, habitacion.getDescripcion());
            pstmt.setBytes(6, habitacion.getFoto());
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public Habitacion buscarHAbitacion(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT tipoHabitacion, valor, estado, descripcion, foto FROM habitacion WHERE idHabitacion = ?");
            Habitacion habitacion = null;
            pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(id);
                habitacion.setTipoHabitacion(respuesta.getString("tipoHabitacion"));
                habitacion.setValor(respuesta.getInt("valor"));
                habitacion.setEstado(respuesta.getString("estado"));
                habitacion.setDescripcion(respuesta.getString("descripcion"));
                habitacion.setFoto(respuesta.getBytes("foto"));
            }
            return habitacion;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void modificarHabitacion(Habitacion habitacion) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE habitacion SET  "
                    + "tipoHabitacion=?, valor=?, estado=? ,descripcion=? "
                    + " WHERE idHabitacion=?");

            pstmt.setString(1, habitacion.getTipoHabitacion());
            pstmt.setInt(2, habitacion.getValor());
            pstmt.setString(3, habitacion.getEstado());
            pstmt.setString(4, habitacion.getDescripcion());
            pstmt.setInt(5, habitacion.getIdHabitacion());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public boolean eliminarHabitacion(int id) {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM habitacion WHERE idHabitacion = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Hubo un error al eliminar");
        }
        return true;
    }

    @Override
    public ArrayList<Habitacion> listarHabitacion() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM habitacion");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Habitacion> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Habitacion habitacion = new Habitacion();
                    habitacion.setIdHabitacion(respuesta.getInt(1));
                    habitacion.setTipoHabitacion(respuesta.getString(2));
                    habitacion.setValor(respuesta.getInt(3));
                    habitacion.setEstado(respuesta.getString(4));
                    habitacion.setDescripcion(respuesta.getString(5));
                    habitacion.setFoto(respuesta.getBytes(6));
                    lista.add(habitacion);
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
    public void modificarHabitacionFoto(Habitacion habitacion) {
            try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE habitacion SET  "
                    + "tipoHabitacion=?, valor=?, estado=? ,descripcion=?, foto=? "
                    + " WHERE idHabitacion=?");

            pstmt.setString(1, habitacion.getTipoHabitacion());
            pstmt.setInt(2, habitacion.getValor());
            pstmt.setString(3, habitacion.getEstado());
            pstmt.setString(4, habitacion.getDescripcion());
            pstmt.setBytes(5, habitacion.getFoto());
            pstmt.setInt(6, habitacion.getIdHabitacion());
            
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }
}
//abra bloc de notas
