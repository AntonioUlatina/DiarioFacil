
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
class Pedido {
    private String pedidoId;
    private Proveedor proveedor;
    private List<Producto> lstProductos = new ArrayList<>();
    private Date fecha;
    private boolean foundProducto;

    public Pedido(String pedidoId, Proveedor proveedor, Date fecha) {
        this.pedidoId = pedidoId;
        this.proveedor = proveedor;
        this.fecha = fecha;
    }
    
    Pedido(){}
    Pedido(String pedidoId, Proveedor proveedor, List<Producto> lstProductos, Date fecha){
        this.pedidoId = pedidoId;
        this.proveedor = proveedor;
        this.lstProductos = lstProductos;
        this.fecha = fecha;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedido{" + "pedidoId=" + pedidoId + ", proveedor=" + proveedor + ", lstProductos=" + lstProductos + ", fecha=" + fecha + '}';
    }
    
    public Producto searchProduct(Collection<Producto> lstProductos, String toSearch) throws NullPointerException{
        System.out.println("El queso " + this.foundProducto);
        for(Producto producto: lstProductos){
            if(toSearch.equals((producto.getNombre()))){
                this.foundProducto = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundProducto){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return null;
}
}
