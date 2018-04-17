
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
    abstract class Item {
    protected static int cantidad;
    
    public Item(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Item(){}
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    /*
    public Producto searchProduct(Collection<Producto> lstProductos, String toSearch) throws NullPointerException{
        try{
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
}*/

     public double subTotalProducto() {
         return this.getCantidad() * ((Producto) this).getPrecio();
     }
     
    public double subTotal() {
        double sub = 0;
        if(this instanceof Producto){
        sub = this.getCantidad() * ((Producto) this).getPrecio();
        }if(this instanceof Promocion){
         sub = this.getCantidad() * (((Promocion) this).getPrecioPromocion() - ((Promocion) this).getPrecioPromocion() * ((Promocion) this).Descuento());
        }if(this instanceof Combo){
          sub = this.getCantidad() * (((Combo) this).getPrecioCombo()- ((Combo) this).getDescuento()* ((Combo) this).Descuento());  //creo que hay que hacer metodo descuento en combo
        }
        return sub;
    }
    
    public void reducirCantidad(int cantidad){
        this.setCantidad(this.getCantidad() - cantidad);
    }
    
    @Override
    public String toString() {
        return "Item{" + "cantidad=" + cantidad + '}';
    }
}
