/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author MI PC
 */
public interface IFabricaDAO {
    
    public IHuespedDao CrearHuespedDao();
     
    public IRecepcionistaDao CrearRecepcionistaDao();
    
    public IHabitacionDao CrearHabitacionDao();
    
    public IPedidoDao CrearPedidosDao();
    
    public IReservaDao CrearReservaDao();
    
    public IMultaDao CrearMultaDao();
    
    public IConfirmarReservaDao CrearConfirmarReservaDao();
    
    public IRegistroPedidoDao CrearPeDidoHuesped();
    
    public IReservaHuespedDao CrearReservaHuesped();
    
    public IHistorialDao crearHistorial();
    
    public IConfirmarSalidaDao confirmarSalida();
    
}
