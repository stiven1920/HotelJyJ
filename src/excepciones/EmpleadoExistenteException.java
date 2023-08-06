/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author MI PC
 */
public class EmpleadoExistenteException extends Exception {

    public EmpleadoExistenteException() {
        super("El empleado esta ya registrado");
    }
    
}
