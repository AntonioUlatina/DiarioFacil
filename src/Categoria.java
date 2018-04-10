
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
class Categoria {

    private String nombre;
    private List<Producto> lstProductos = new ArrayList<>();

    Categoria() {
    }

    Categoria(String nombre, List<Producto> lstProductos) {
        this.nombre = nombre;
        this.lstProductos = lstProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", lstProductos=" + lstProductos + '}';
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
