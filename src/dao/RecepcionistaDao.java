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
import modelo.Recepcionista;
import interfaz.IRecepcionistaDao;

/**
 *
 * @author MI PC
 */
public class RecepcionistaDao implements IRecepcionistaDao {

    @Override
    public void guardarRecepcionesta(Recepcionista recepcion) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO recepcionista"
                    + "(codigo, nombre, apellido, telefono, direccion, usuario, contrasenia) values (?,?,?,?,?,?,?)");
            pstmt.setInt(1, recepcion.getCodigo());
            pstmt.setString(2, recepcion.getNombre());
            pstmt.setString(3, recepcion.getApellido());
            pstmt.setInt(4, recepcion.getTelefono());
            pstmt.setString(5, recepcion.getDireccion());
            pstmt.setString(6, recepcion.getUsuario());
            pstmt.setString(7, recepcion.getContrasenia());

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public Recepcionista buscarRecepcionista(int codigo) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT codigo, nombre, apellido, telefono, direccion, usuario, contrasenia"
                    + "FROM recepcionista WHERE codigo=?");

            pstmt.setInt(1, codigo);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Recepcionista recepcionista = new Recepcionista();

                recepcionista.setCodigo(codigo);
                recepcionista.setNombre(respuesta.getString("nombre"));
                recepcionista.setApellido(respuesta.getString("apellido"));
                recepcionista.setTelefono(respuesta.getInt("telefono"));
                recepcionista.setDireccion(respuesta.getString("direccion"));
                recepcionista.setUsuario(respuesta.getString("usuario"));
                recepcionista.setContrasenia(respuesta.getString("contrasenia"));

                return recepcionista;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void modificarRecepcionista(Recepcionista recepcionista) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE recepcionista SET  "
                    + "nombre=?, apellido=? ,telefono=?, direccion=? "
                    + " WHERE codigo=?");

            pstmt.setString(1, recepcionista.getNombre());
            pstmt.setString(2, recepcionista.getApellido());
            pstmt.setInt(4, recepcionista.getTelefono());
            pstmt.setString(3, recepcionista.getDireccion());
            pstmt.setInt(5, recepcionista.getCodigo());
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public ArrayList<Recepcionista> listarRecepcionista() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT * " + "FROM recepcionista");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Recepcionista> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Recepcionista docente = new Recepcionista();
                    docente.setCodigo(respuesta.getInt("codigo"));
                    docente.setNombre(respuesta.getString("nombre"));
                    docente.setApellido(respuesta.getString("apellido"));
                    docente.setTelefono(respuesta.getInt("telefono"));
                    docente.setDireccion(respuesta.getString("direccion"));
                    lista.add(docente);
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
    public Recepcionista buscarRecepcionistaLogin(String usuario) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT codigo, contrasenia FROM recepcionista WHERE usuario=?");
            pstmt.setString(1, usuario);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setUsuario(usuario);
                recepcionista.setCodigo(respuesta.getInt("codigo"));
                recepcionista.setContrasenia(respuesta.getString("contrasenia"));
                return recepcionista;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }
}
