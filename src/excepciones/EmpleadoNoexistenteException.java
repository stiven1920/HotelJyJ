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
public class EmpleadoNoexistenteException extends Exception{

    public EmpleadoNoexistenteException() {
        super("El empleado no se encuentra registrado");
    }
    
}
