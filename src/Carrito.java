
import java.util.ArrayList;
import java.util.Collection;
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
public class Carrito implements Searchable{
    private List<Item> lstItems = new ArrayList<>();
    private List<Promocion> lstPromociones = new ArrayList<>();
    private List<Combo> lstCombos = new ArrayList<>();
    private Cliente cliente;
    
    public Carrito(){}
    
    public Carrito(List lstItems, List lstPromociones,List ListCombos, Cliente cliente){
        this.cliente = cliente;
        this.lstItems = lstItems;
        this.lstCombos = lstCombos;
        this.lstPromociones = lstPromociones;
    }

    public List<Item> getLstItems() {
        return lstItems;
    }

    public List<Promocion> getLstPromociones() {
        return lstPromociones;
    }

    public List<Combo> getLstCombos() {
        return lstCombos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setLstItems(List<Item> lstItems) {
        this.lstItems = lstItems;
    }

    public void setLstPromociones(List<Promocion> lstPromociones) {
        this.lstPromociones = lstPromociones;
    }

    public void setLstCombos(List<Combo> lstCombos) {
        this.lstCombos = lstCombos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public <T> void search(Collection<T> lstObjects, String toSearch) throws NullPointerException{
        for(T object: lstObjects){
            if((object instanceof Producto && toSearch.equals(((Producto) object).getNombre()))){
                this.foundObject = true;
                this.item = (Item) object;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Categoria && toSearch.equals(((Categoria) object).getNombre()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Proveedor && toSearch.equals(((Proveedor) object).getNombre()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Pedido && toSearch.equals(((Pedido) object).getPedidoId()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        }
    @Override
    public String toString() {
        return "Carrito{" + "lstItems=" + lstItems + ", lstPromociones=" + lstPromociones + ", lstCombos=" + lstCombos + ", cliente=" + cliente + '}';
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
