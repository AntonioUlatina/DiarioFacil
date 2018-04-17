
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
    private String categoria;
    private double precio;
    private static final int STOCKMIN = 5;

    public Producto(String nombre, String categoria, double precio, int cantidad) {
        super(cantidad);
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    Producto (){}
    
    //este es un constructor con proposito de test solamente 
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getSTOCKMIN() {
        return STOCKMIN;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", stockMin=" + STOCKMIN + '}';
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
        for(Producto producto: lstProductos){
            if(toSearch.equals((producto.getNombre()))){
                return producto;
            }
        }
        return null;
    }
}