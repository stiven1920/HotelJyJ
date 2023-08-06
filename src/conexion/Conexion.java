/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MI PC
 */
public class Conexion {
    
   public static Connection getConnection() {
        Connection con = null;
        try {
            // carga el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String bd = "jdbc:mysql://localhost/HotelJyJ?useSSl=false";
            String db = "jdbc:mysql://localhost:3307/hoteljyj?useSSl=false";
            String user = "root";
            //cambiar clave
            String password = "84415971";
            // agrega la libreria
            con = DriverManager.getConnection(db, user, password);
        } catch (ClassNotFoundException e) {
            System.err.print("Hubo un error al buscar la clase");
        } catch (SQLException e) {
            System.err.print("Hubo un error al conectar");
        }
        return con;

    }
    
}
