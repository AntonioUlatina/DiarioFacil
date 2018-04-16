
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateo Marin
 */
class Producto extends Item/*implements Searchable*/{
    private String nombre;
    private String descripcion;
    private String categoria;
    private int precio;
    private int stockMin;
    private int stockMax;
    private boolean foundProducto;

    public Producto(String nombre, String descripcion, String categoria, int precio, int stockMin, int numeroConsecutivo, int cantidad) {
        super(numeroConsecutivo, cantidad);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stockMin = stockMin;
    }

    
    Producto (){}
    
    //este es un constructor con proposito de test solamente 
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, String descripcion, Integer precio, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockMax() {
        return stockMax;
    }

    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stockMin=" + stockMin + ", stockMax=" + stockMax + '}';
    }
    
    //@Override
    public Producto search(Collection<Producto> lstObjects, String toSearch) throws NullPointerException{
        Producto tempProduct = null;
        for(Producto object: lstObjects){
        tempProduct = toSearch.equals(object.nombre) ? object : null;
        }
        return tempProduct;
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