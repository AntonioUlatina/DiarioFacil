
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
class Proveedor {
    private String nombre;
    private String email;
    private List<Producto> lstProductos = new ArrayList<>();
    
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
    
}
