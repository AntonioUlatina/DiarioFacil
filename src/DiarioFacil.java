
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateo Marin
 */
public class DiarioFacil {
    private static List<Producto> lstProductos;
    private static List<Promocion> lstPromociones;
    private static List<Combo> lstCombos;
    private static List<Orden> lstOrdenes;
    private static List<Usuario> lstUsuarios;
    private static List<Proveedor> lstProveedores;
    private static List<Pedido> lstPedidos;
    
    {
    lstProductos = new ArrayList<>();
    lstPromociones = new ArrayList<>();
    lstCombos = new ArrayList<>();
    lstOrdenes = new ArrayList<>();
    lstUsuarios = new ArrayList<>();
    lstProveedores = new ArrayList<>();
    lstPedidos = new ArrayList<>();
    }

    public DiarioFacil() {}
    
    public void agregarProducto(Producto producto) {
        this.lstProductos.add(producto);
    }
    
    public void agregarPromocion (Promocion promocion){
        this.lstPromociones.add(promocion);
    }
    
    public void agregarCombo (Combo combo){
        this.lstCombos.add(combo);
    }
    public void agregarUsuario (Usuario usuario){
        this.lstUsuarios.add(usuario);
    }
    
    public void agregarOrden (Orden orden){
        this.lstOrdenes.add(orden);
    }

    public void agregarProveedor(Proveedor proveedor){
        this.lstProveedores.add(proveedor);
    }
    public void agregarPedido(Pedido pedido){
        this.lstPedidos.add(pedido);
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public List<Promocion> getLstPromociones() {
        return lstPromociones;
    }

    public void setLstPromociones(List<Promocion> lstPromociones) {
        this.lstPromociones = lstPromociones;
    }

    public List<Combo> getLstCombos() {
        return lstCombos;
    }

    public void setLstCombos(List<Combo> lstCombos) {
        this.lstCombos = lstCombos;
    }

    public List<Orden> getLstOrdenes() {
        return lstOrdenes;
    }

    public void setLstOrdenes(List<Orden> lstOrdenes) {
        this.lstOrdenes = lstOrdenes;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Proveedor> getLstProveedores() {
        return lstProveedores;
    }

    public void setLstProveedores(List<Proveedor> lstProveedores) {
        this.lstProveedores = lstProveedores;
    }

    public List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    @Override
    public String toString() {
        String todos = "";
        for (Usuario lstUsuario : lstUsuarios) {
            todos.concat(lstUsuario.getNombre());
        }
        return "DiarioFacil{" + "lstProductos=" + lstProductos + ", lstPromociones=" + lstPromociones + ", lstCombos=" + lstCombos + ", lstOrdenes=" + lstOrdenes + ", lstUsuarios=" + lstUsuarios + ", lstProveedores=" + lstProveedores + ", lstPedidos=" + lstPedidos + '}';
    }
    

}
