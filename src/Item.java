
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
class Item {
    private int numeroConsecutivo;
    private int cantidad;
    private Producto producto;
    private Combo combo;
    private Promocion promocion;
    private boolean foundProducto;
    private boolean foundCombo;
    private boolean foundPromocion;
    
    public Item(){}
    
    public <T> Item(int numeroConsecutivo, int cantidad, T item){
        this.numeroConsecutivo = numeroConsecutivo;
        this.cantidad = cantidad;
        if(item instanceof Producto){
        this.producto = (Producto) item;
        }
        if(item instanceof Combo){
            this.combo = (Combo) item;
        }
        if(item instanceof Promocion){
            this.promocion = (Promocion) item;
        }
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
    
    public Producto searchProduct(Collection<Producto> lstProductos, String toSearch) throws NullPointerException{
        try{
        System.out.println("El queso " + this.foundProducto);
        for(Producto producto: lstProductos){
            if(toSearch.equals((producto.getNombre()))){
                this.producto = producto;
                this.foundProducto = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundProducto){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return producto;
        }finally{
            this.foundProducto = false;
        }
}
    
    public Combo searchCombo(Collection<Combo> lstCombos, String toSearch) throws NullPointerException{
        try{
        System.out.println("El queso " + this.foundCombo);
        for(Combo combo: lstCombos){
            if(toSearch.equals((combo.getNombre()))){
                this.combo = combo;
                this.foundCombo = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundCombo){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return combo;
        }finally{
            this.foundCombo = false;
        }
}
    
    public Promocion searchPromocion(Collection<Promocion> lstPromociones, String toSearch) throws NullPointerException{
        try{
            System.out.println("El queso " + this.foundProducto);
        for(Promocion promocion: lstPromociones){
            if(toSearch.equals((promocion.getNombre()))){
                this.promocion = promocion;
                this.foundPromocion = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundPromocion){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return promocion;
       }finally{
            this.foundPromocion = false;
        }
}
}
