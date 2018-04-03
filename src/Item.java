
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
class Item {
    private int numeroConsecutivo;
    private int cantidad;
    private Producto producto;
    
    public Item(){}
    
    public Item(int numeroConsecutivo, int cantidad, Producto producto){
        this.numeroConsecutivo = numeroConsecutivo;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getNumeroConsecutivo() {
        return numeroConsecutivo;
    }

    public void setNumeroConsecutivo(int numeroConsecutivo) {
        this.numeroConsecutivo = numeroConsecutivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Item{" + "numeroConsecutivo=" + numeroConsecutivo + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }
    
}
