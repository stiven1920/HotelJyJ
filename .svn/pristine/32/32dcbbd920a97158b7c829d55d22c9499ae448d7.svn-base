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
import modelo.Huesped;
import interfaz.IHuespedDao;

/**
 *
 * @author MI PC
 */
public class HuespedDao implements IHuespedDao {

    /**
     * create table huesped( cedula int primary key, nombre varchar(45) not
     * null, apellido varchar(45) not null, telefono int not null, direccion
     * varchar(45) not null, correo varchar(45) not null );
     */
    @Override
   public void guardarHuesped(Huesped huesped) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO huesped"
                    + "(cedula, nombre, apellido, telefono, direccion, correo, contrasenia) values (?,?,?,?,?,?,?);");
            pstmt.setInt(1, huesped.getCedula());
            pstmt.setString(2, huesped.getNombre());
            pstmt.setString(3, huesped.getApellido());
            pstmt.setInt(4, huesped.getTelefono());
            pstmt.setString(5, huesped.getDireccion());
            pstmt.setString(6, huesped.getCorreo());
            pstmt.setString(7, huesped.getContrasenia());

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public Huesped buscarHuesped(int cedula) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  nombre, apellido, telefono, direccion, correo, contrasenia "
                    + "FROM huesped WHERE cedula=?");
            pstmt.setInt(1, cedula);
            System.out.println("dao cedula "+cedula);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Huesped huesped = new Huesped();
                huesped.setCedula(cedula);
                huesped.setNombre(respuesta.getString("nombre"));
                huesped.setApellido(respuesta.getString("apellido"));
                huesped.setTelefono(respuesta.getInt("telefono"));
                huesped.setDireccion(respuesta.getString("direccion"));
                huesped.setCorreo(respuesta.getString("correo"));
                huesped.setContrasenia(respuesta.getString("contrasenia"));

                return huesped;
            }
            System.out.println(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void modificarHuesped(Huesped huesped) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE huesped SET  "
                    + "nombre=?, apellido=? ,telefono=?, direccion=?, correo=? "
                    + " WHERE cedula=?");

            pstmt.setString(1, huesped.getNombre());
            pstmt.setString(2, huesped.getApellido());
            pstmt.setInt(3, huesped.getTelefono());
            pstmt.setString(4, huesped.getDireccion());
            pstmt.setString(5, huesped.getCorreo());
            pstmt.setInt(6, huesped.getCedula());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (Exception e) {
        }
    }

    @Override
    public ArrayList<Huesped> listarHuesped() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT cedula, nombre, apellido, telefono, direccion, correo " + "FROM huesped");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Huesped> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Huesped huesped = new Huesped();
                    huesped.setCedula(respuesta.getInt(1));
                    huesped.setNombre(respuesta.getString(2));
                    huesped.setApellido(respuesta.getString(3));
                    huesped.setTelefono(respuesta.getInt(4));
                    huesped.setDireccion(respuesta.getString(5));
                    huesped.setCorreo(respuesta.getString(6));
                    lista.add(huesped);
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
    public Huesped buscarLogin(String correo, String contrasenia) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT cedula, correo, contrasenia "
                    + "FROM huesped WHERE correo=? AND contrasenia=?");
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasenia);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Huesped huesped = new Huesped();
                huesped.setCedula(respuesta.getInt("cedula"));
                huesped.setCorreo(correo);
                huesped.setContrasenia(respuesta.getString("contrasenia"));
                return huesped;
            }
            System.out.println(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }
}
