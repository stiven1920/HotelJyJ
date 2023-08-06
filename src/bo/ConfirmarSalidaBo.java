/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import interfaz.IConfirmarSalidaDao;
import modelo.ConfirmarSalida;

/**
 *
 * @author STIVEN
 */
public class ConfirmarSalidaBo {

    private IConfirmarSalidaDao dao;

    public ConfirmarSalidaBo() {
        dao = Fabrica.FactoryDAO.getFabrica().confirmarSalida();
    }

    public void guardarSalida(ConfirmarSalida confiSalida) {
        dao.guardarSalida(confiSalida);
    }

    public ConfirmarSalida buscarSalida(int id) {
        return dao.buscarSalida(id);
    }

}
