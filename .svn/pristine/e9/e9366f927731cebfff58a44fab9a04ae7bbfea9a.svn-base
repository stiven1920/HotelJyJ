/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.HuespedBo;
import excepciones.PersonaExistenteException;
import excepciones.PersonaNoEncontradaException;
import javax.swing.table.DefaultTableModel;
import modelo.Huesped;

/**
 *
 * @author MI PC
 */
public class CtlHuesped {

    HuespedBo bo;

    public CtlHuesped() {
        bo = new HuespedBo();
    }

    public void guardarHuesped(Huesped huesped) throws PersonaExistenteException, PersonaNoEncontradaException {
        bo.guardarHuesped(huesped);
    }

    public Huesped buscarHuesped(int cedula) throws PersonaNoEncontradaException {
        return bo.buscarHuesped(cedula);
    }
    public Huesped buscarHuespedLogin(String correo, String contrasenia) {
        return bo.buscarLogin(correo, contrasenia);
    }

    public void modificarHuesped(Huesped huesped) {
        bo.modificarHuesped(huesped);
    }

    public DefaultTableModel listarHuesped() {
        return bo.listarHuesped();
    }

}
