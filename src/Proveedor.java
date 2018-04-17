
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
class Proveedor {
    private String nombre;
    private String email;
    private List<Producto> lstProductos = new ArrayList<>();
    private boolean foundProveedor;
    
    Proveedor(){}
    Proveedor(String nombre,String email, List<Producto> lstProductos){
        this.nombre = nombre;
        this.email = email;
        this.lstProductos = lstProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nombre=" + nombre + ", email=" + email + ", lstProductos=" + lstProductos + '}';
    }
    
    public Proveedor searchProvider(Collection<Proveedor> lstProveedores, String toSearch) throws NullPointerException{
        
        for(Proveedor provider: lstProveedores){
            if(toSearch.equals((provider.getNombre()))){
                this.foundProveedor = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundProveedor){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return null;
}
    
        public void agregarProducto(Producto... productos){
        for(Producto producto: productos){
            if(!search(this.getLstProductos(),producto)){
                this.getLstProductos().add (producto);
            }else{
                System.out.printf("El producto %s ya existe en la lista\n", producto.getNombre());}
        }
}

    private <Generic> boolean search(List<Producto> lstProductos, Generic objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
