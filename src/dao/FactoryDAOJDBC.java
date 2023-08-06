/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaz.IFabricaDAO;
import interfaz.IHistorialDao;
import interfaz.IRegistroPedidoDao;
import interfaz.IReservaHuespedDao;
import interfaz.IConfirmarReservaDao;
import interfaz.IConfirmarSalidaDao;
import interfaz.IHabitacionDao;
import interfaz.IHuespedDao;
import interfaz.IMultaDao;
import interfaz.IPedidoDao;
import interfaz.IRecepcionistaDao;
import interfaz.IReservaDao;

/**
 *
 * @author MI PC
 */
public class FactoryDAOJDBC implements IFabricaDAO {

    @Override
    public IHuespedDao CrearHuespedDao() {
        return new HuespedDao();
    }

    @Override
    public IRecepcionistaDao CrearRecepcionistaDao() {
        return new RecepcionistaDao();
    }

    @Override
    public IHabitacionDao CrearHabitacionDao() {
        return new HabitacionDao();
    }

    @Override
    public IPedidoDao CrearPedidosDao() {
        return new PedidoDao();
    }

    @Override
    public IReservaDao CrearReservaDao() {
        return new ReservaDao();
    }

    @Override
    public IMultaDao CrearMultaDao() {
        return new MultaDao();
    }

    @Override
    public IConfirmarReservaDao CrearConfirmarReservaDao() {
        return new ConfirmarReservaDao();
    }

    @Override
    public IRegistroPedidoDao CrearPeDidoHuesped() {
        return new RegistroPedidoDao();
    }

    @Override
    public IReservaHuespedDao CrearReservaHuesped() {
        return new DaoDtoReservaHuesped();
    }

    @Override
    public IHistorialDao crearHistorial() {
        return new HistorialDao();
    }

    @Override
    public IConfirmarSalidaDao confirmarSalida() {
        return new ConfirmarSalidaDao();
    }

}
