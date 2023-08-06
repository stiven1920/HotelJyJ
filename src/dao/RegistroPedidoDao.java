/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaz.IRegistroPedidoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Habitacion;
import modelo.RegistroPedido;

/**
 *
 * @author Jopcion
 */
public class RegistroPedidoDao implements IRegistroPedidoDao {

    @Override
    public void guardarPedidoHuesped(RegistroPedido pedido) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO registropedido( nombreProducto,cantidadProducto,valorProducto,totalProducto, huespedId, habitacionId)"
                    + " VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, pedido.getNombreProducto());
            pstmt.setInt(2, pedido.getCantidad());
            pstmt.setInt(3, pedido.getValor());
            pstmt.setInt(4, pedido.getTotal());
            pstmt.setInt(5, pedido.getHuespedId());
            pstmt.setInt(6, pedido.getHabitacionId());
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public RegistroPedido buscarPedidoHuesped(int idRegistroPedido) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idRegistroPedido, nombreProducto, cantidadProducto, valorProducto, totalProducto, huespedId"
                    + " WHERE idRegistroPedido=?");
            RegistroPedido pedido = null;
            pstmt.setInt(1, idRegistroPedido);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                pedido = new RegistroPedido();
                pedido.setIdRegistroPedido(idRegistroPedido);
                pedido.setNombreProducto(respuesta.getString("tipoHabitacion"));
                pedido.setCantidad(respuesta.getInt("cantidad"));
                pedido.setValor(respuesta.getInt("valor"));
                pedido.setTotal(respuesta.getInt("total"));
                pedido.setHuespedId(respuesta.getInt("huespedId"));
            }
            return pedido;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public ArrayList<RegistroPedido> listarCarrito(int idHuesped) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  idRegistroPedido, nombreProducto, cantidadProducto, valorProducto, totalProducto, huespedId, habitacionId FROM registropedido where huespedId =?");
            pstmt.setInt(1, idHuesped);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<RegistroPedido> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    RegistroPedido registro = new RegistroPedido();
                    registro.setIdRegistroPedido(respuesta.getInt("idRegistroPedido"));
                    registro.setNombreProducto(respuesta.getString(2));
                    registro.setCantidad(respuesta.getInt(3));
                    registro.setValor(respuesta.getInt(4));
                    registro.setTotal(respuesta.getInt(5));
                    registro.setHuespedId(respuesta.getInt(6));
                    registro.setHabitacionId(respuesta.getInt(7));
                    lista.add(registro);
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
    public boolean eliminar(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM registropedido WHERE idRegistroPedido = ?");
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
    public ArrayList<RegistroPedido> listarPedidosHuestedHabitacion(int idHabitacion, int huespedId) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  idRegistroPedido, nombreProducto, cantidadProducto, valorProducto, totalProducto, huespedId, habitacionId FROM registropedido"
                    + " where huespedId = ?  and habitacionId = ?");
            pstmt.setInt(1, huespedId);
            pstmt.setInt(2, idHabitacion);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<RegistroPedido> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    RegistroPedido registro = new RegistroPedido();
                    registro.setIdRegistroPedido(respuesta.getInt("idRegistroPedido"));
                    registro.setNombreProducto(respuesta.getString(2));
                    registro.setCantidad(respuesta.getInt(3));
                    registro.setValor(respuesta.getInt(4));
                    registro.setTotal(respuesta.getInt(5));
                    registro.setHuespedId(respuesta.getInt(6));
                    registro.setHabitacionId(respuesta.getInt(7));
                    lista.add(registro);
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
