/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bo.ConfirmarSalidaBo;
import modelo.ConfirmarSalida;

/**
 *
 * @author STIVEN
 */
public class CtlConfirmarSalida {

    private ConfirmarSalidaBo bo;

    public CtlConfirmarSalida() {
        bo = new ConfirmarSalidaBo();
    }

    public void guardarSalida(ConfirmarSalida confiSalida) {
        bo.guardarSalida(confiSalida);
    }

    public ConfirmarSalida buscarSalida(int id) {
        return bo.buscarSalida(id);
    }

}
