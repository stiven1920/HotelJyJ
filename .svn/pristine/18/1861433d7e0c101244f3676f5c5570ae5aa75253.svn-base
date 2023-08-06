/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.Recepcionista;

/**
 *
 * @author MI PC
 */
public interface IRecepcionistaDao {
    
    /**
     * Metodo para persistir los datos del recepcionista
     * @param recepcion  por parametro nos guarda el objecto(atributos) recepcionista
     */
    public void guardarRecepcionesta(Recepcionista recepcion);
    
    /**
     * Metod para buscar un recepcionista
     * @param codigo nos va a buscar por el codigo los datos del recepcionista
     * @return nos retonar el recepcionista registrado por el administrador
     */
    public Recepcionista buscarRecepcionista(int codigo);
    
    /**
     * Metodo para entrar el usuario del huesped
     * @param usuario por parmetro buscamos el usuario
     * @param contrasenia por parametro buscamos la contraseña
     * @return no retorna el usuario del huesped una ves registrado
     */
    public Recepcionista buscarRecepcionistaLogin(String usuario);
    
    
    /**
     * Metodo de modificar los datos del recepcionista
     * @param recepcionista  por parametro recibimos el objeto del recepcionista para poderlo modificar
     */
    public void modificarRecepcionista(Recepcionista recepcionista);
    
    /**
     * Metodo para listar los recepcionistas que trabajan en el hotel
     * @return nos va retorna la lista de los recepcionistas del hotel
     */
    public ArrayList<Recepcionista> listarRecepcionista();
    
}
