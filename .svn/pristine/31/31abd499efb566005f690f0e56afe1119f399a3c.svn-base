/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author MI PC
 */
public interface IPedidoDao {

    /**
     * Metodo para persistir los datos agregados a la base de datos
     *
     * @param pedido por parametro recibimos el objeto(atribustos)
     */
    public void guardarPedido(Pedido pedido);

    /**
     * Metodo para buscar el pedido
     *
     * @param id buscamos por el id del pedido
     * @return nos retorna los datos del pedido
     */
    public Pedido buscarPedido(int id);

    /**
     * Metodo para modificar los datos del pedido
     *
     * @param pedido recibimos por parametro el objeto del huesped para poderlo
     * modificar
     */
    public void modificarPedido(Pedido pedido);

    /**
     * Metodo para modificar los datos del pedido
     *
     * @param pedido recibimos por parametro el objeto del huesped para poderlo
     * modificar junto con la foto
     */
    public void modificarPedidoFoto(Pedido pedido);

    /**
     * Metodo para eliminar o tumbar un pedido
     *
     * @param id eliminamos el pedido por el id
     * @return nos elimina de la persistencia todos los datos que hallan
     */
    public boolean eliminarPedido(int id);

    /**
     * Metodo para actulizar el stock de los productos
     * @param cantidad metemos la cantidad de producto a comprar
     * @param idProducto buscamos por el id producto
     * @return nos retorna el stock atualizado
     */
    public int actulizarStock(int cantidad, int idProducto);

    /**
     * Metodo para listar los pedido
     *
     * @return nos retorna la lista de los pedidos registrados
     */
    public ArrayList<Pedido> listarPedido();

}
