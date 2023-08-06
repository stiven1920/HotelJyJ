 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.Huesped;

/**
 *
 * @author MI PC
 */
public interface IHuespedDao {
    
    /**
     * Metodo para persistir todos los huesped que se registran al hotel
     * @param huesped por parametro recibimos el objecto completo(atributos)
     */
    public void guardarHuesped(Huesped huesped);  
    
    /**
     * Metodo para buscar el huesped registrado en el hotel
     * @param cedula buscamos por la identificacion del huesped
     * @return nos retorna los datos registrados del huesped
     */
    public Huesped buscarHuesped(int cedula);
   
    /**
     * Metodo para buscar el usuario del huesped
     * @param correo buscamos por el correo
     * @param contrasenia confirmamos el ingreso con la contrasenia
     * @return nos retorna el usuario del huesped a ingresar
     */
    public Huesped buscarLogin(String correo, String contrasenia);
    
    /**
     * Metodo para modificar los datos de un huesped
     * @param huesped por parametro recibimos el objecto del huesped para poderlo modificar
     */
    public void modificarHuesped(Huesped huesped);
    
    /**
     * Metodo para listar todos los huesped registrados en el hotel
     * @return los huesped registrados
     */
    public ArrayList<Huesped> listarHuesped();
    
}
