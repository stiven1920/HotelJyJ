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
import modelo.Factura;
import interfaz.IFacturaDao;

/**
 *
 * @author MI PC
 */
public class FacturaDao implements IFacturaDao {

    /*
create table factura(
idFactura int primary key,
nit int not null,
fechaFactura Date not null,
valorHabitacion int not null,
valorpedido int not null,
confirmarReservaId int,
recepcionId int,
     */
    @Override
    public void guardarFactura(Factura factura) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO factura"
                    + "(idFactura, nit, fechaFactura, valorHabitacion, valorpedido, confirmarReservaId, recepcionId) values (?,?,?,?,?,?,?)");
            pstmt.setInt(1, factura.getIdFactura());
            pstmt.setInt(2, factura.getNit());
            pstmt.setDate(3, factura.getFechaFactura());
            pstmt.setInt(4, factura.getValorHabitacion());
            pstmt.setInt(5, factura.getValorpedido());
            pstmt.setInt(6, factura.getConfirmarReservaId());
            pstmt.setInt(7, factura.getRecepcionId());

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }

    @Override
    public Factura buscar(int id) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idFactura, nit, fechaFactura, valorHabitacion, valorpedido, confirmarReservaId, recepcionId "
                    + "FROM factura WHERE idFactura=?");

            pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();
            System.out.println(pstmt);
            if (respuesta.next()) {
                Factura factura = new Factura();

                factura.setIdFactura(id);
                factura.setNit(respuesta.getInt("nit"));
                factura.setFechaFactura(respuesta.getDate("fechaFactura"));
                factura.setValorHabitacion(respuesta.getInt("valorHabitacion"));
                factura.setValorpedido(respuesta.getInt("valorpedido"));
                factura.setConfirmarReservaId(respuesta.getInt("confirmarReservaId"));
                factura.setRecepcionId(respuesta.getInt("recepcionId"));

                return factura;
            }
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return null;

    }

    @Override
    public ArrayList<Factura> listarFactura() {

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idFactura, nit, fechaFactura, valorHabitacion, valorpedido, confirmarReservaId, recepcionId " + "FROM factura");
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Factura> lista = new ArrayList<>();
            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Factura factura = new Factura();
                    factura.setIdFactura(respuesta.getInt("idFactura"));
                    factura.setNit(respuesta.getInt("nit"));
                    factura.setFechaFactura(respuesta.getDate("fechaFactura"));
                    factura.setValorHabitacion(respuesta.getInt("valorHabitacion"));
                    factura.setValorpedido(respuesta.getInt("valorpedido"));
                    factura.setConfirmarReservaId(respuesta.getInt("confirmarReservaId"));
                    factura.setRecepcionId(respuesta.getInt("recepcionId"));
                    
                    lista.add(factura);
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
