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
import modelo.Pedido;
import interfaz.IPedidoDao;

/**
 *
 * @author MI PC
 */
public class PedidoDao implements IPedidoDao {

    int r;

    /*
create table pedido(
idPedido int primary key,
nombrePedido varchar(45) not null,
cantidad int not null,
valor int
); 
     */
    @Override
    public void guardarPedido(Pedido pedido) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO pedido"
                    + "(idPedido, nombrePedido, cantidad, valor, foto) VALUES (?,?,?,?,?)");
            pstmt.setInt(1, pedido.getIdPedido());
            pstmt.setString(2, pedido.getNombrePedido());
            pstmt.setInt(3, pedido.getCantidad());
            pstmt.setInt(4, pedido.getValor());
            pstmt.setBytes(5, pedido.getFoto());

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public Pedido buscarPedido(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idPedido, nombrePedido, cantidad, valor "
                    + "FROM pedido WHERE idPedido=?");

            pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Pedido pedido = new Pedido();

                pedido.setIdPedido(id);
                pedido.setNombrePedido(respuesta.getString("nombrePedido"));
                pedido.setCantidad(respuesta.getInt("cantidad"));
                pedido.setValor(respuesta.getInt("valor"));

                return pedido;
            }
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;
    }

    @Override
    public void modificarPedido(Pedido pedido) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE pedido SET  "
                    + "nombrePedido=?, cantidad=?, valor=? "
                    + " WHERE idPedido=?");

            pstmt.setString(1, pedido.getNombrePedido());
            pstmt.setInt(2, pedido.getCantidad());
            pstmt.setInt(3, pedido.getValor());
            pstmt.setInt(4, pedido.getIdPedido());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public void modificarPedidoFoto(Pedido pedido) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE pedido SET  "
                    + "nombrePedido=?, cantidad=?, valor=?, foto=?  "
                    + " WHERE idPedido=?");

            pstmt.setString(1, pedido.getNombrePedido());
            pstmt.setInt(2, pedido.getCantidad());
            pstmt.setInt(3, pedido.getValor());
            pstmt.setInt(4, pedido.getIdPedido());
            pstmt.setBytes(5, pedido.getFoto());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
    }

    @Override
    public boolean eliminarPedido(int id) {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM pedido WHERE idPedido = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("pstmt");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Hubo un error al eliminar");
        }
        return true;
    }

    @Override
    public ArrayList<Pedido> listarPedido() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idPedido, nombrePedido, cantidad, valor, foto FROM pedido");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Pedido> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(respuesta.getInt("idPedido"));
                    pedido.setNombrePedido(respuesta.getString("nombrePedido"));
                    pedido.setCantidad(respuesta.getInt("cantidad"));
                    pedido.setValor(respuesta.getInt("valor"));
                    pedido.setFoto(respuesta.getBytes("foto"));
                    lista.add(pedido);
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
    public int actulizarStock(int cantidad, int idProducto) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE pedido SET  "
                    + "cantidad=? WHERE idPedido=?");
            pstmt.setInt(1, cantidad);
            pstmt.setInt(2, idProducto);
            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
        return r;
    }

}
