/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DTO.ProductoPedidoDTO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pedido;
import modelo.RecepcionHabitacion;

/**
 *
 * @author Jopcion
 */
public class RecepcionDao {
     public void guardarPedido(RecepcionHabitacion recepc) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO recepcion_habitacion"
                    + "(idRecepcionHabitacion, recepcionId, habitacionId, pedidoId, foto) VALUES (?,?,?,?)");
            pstmt.setInt(1, recepc.getIdRecepcionHabitacion());
            pstmt.setInt(2, recepc.getRecepcionId());
            pstmt.setInt(3, recepc.getHabitacionId());
            pstmt.setInt(4, recepc.getPedidoId());
            

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");

        }
    }
    public boolean eliminarCarrito(int Codigo) {
        
           
        
        try(Connection con=Conexion.getConnection()) {
            PreparedStatement pstmt=con.prepareStatement("DELETE from recepcion_habitacion WHERE pedidoId=?");
          
  
            pstmt.setInt(1, Codigo);
          
          int res=  pstmt.executeUpdate();
          
         if(res > 0){
             
         }else{
             
         }
          
        } catch (SQLException ex) {            
            ex.printStackTrace();
            System.err.println("Hubo un error al insertar");
        }
        return true;
    }

        public ArrayList<ProductoPedidoDTO> listarCarrito(int codigo) {
       ArrayList<ProductoPedidoDTO> list ;
        list = new ArrayList<>();
         try(Connection con=Conexion.getConnection()){
             
            PreparedStatement pstmt=con.prepareStatement("SELECT p.codigo, p.nombre, p.valor,"+"ra.cantidad,ra.precio FROM recepcion_habitacion ra"
            +" join pedido p"
            +" on ra.pedidoId = p.idPedido"
            +"WHERE =?");
            
            pstmt.setInt(1, codigo);
            ResultSet respuesta=pstmt.executeQuery();
        
            
            if (respuesta.next()) {
                
                ProductoPedidoDTO pro = new ProductoPedidoDTO();
                
                pro.setCodigo(codigo);
                pro.setCantidad(respuesta.getInt("p.cantidad"));
                pro.setPrecio(respuesta.getInt("p.precio"));
                pro.setPrecioProducto(respuesta.getInt("ra.precio"));
                pro.setNombre(respuesta.getString("p.nombre"));
            
                
                        
                 list.add(pro);
            }
             System.out.println(pstmt);
            }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("hubo un error  al listar ");
     
}
        return list;
         
}
}
