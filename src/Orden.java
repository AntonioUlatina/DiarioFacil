
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateo Marin
 */
class Orden {

    private Cliente cliente;
    private Carrito carrito;
    private Date fechaCreacion;
    //private TreeMap<Item> lstItems;
    private List<Item> lstItems = new ArrayList<>();
    
    public Orden(){}
    
    public Orden(Cliente cliente, Carrito carrito, Date fechaCreacion){
        this.cliente = cliente;
        this.carrito = carrito;
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
