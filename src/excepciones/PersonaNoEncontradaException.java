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
public class PersonaNoEncontradaException extends Exception {

    public PersonaNoEncontradaException() {
       super("la persona con esta cedula no se encuentra");
    }
    
}
