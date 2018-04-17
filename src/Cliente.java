
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
public class Cliente extends Usuario {
    private String direccion;
    private List<Orden> lstOrdenes;//El cliente tiene una lista de ordenes para poder ver sus ordenes antiguas
    private int compras;
    private boolean foundCliente;
    public Cliente(){}
    
    public Cliente(String nombre,String contraseña,String cedula,String telefono,String direccion){
        super(nombre,contraseña,cedula,telefono);
        this.direccion = direccion;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "direccion=" + direccion + ", lstOrdenes=" + lstOrdenes + '}';
    }
    
    public Cliente searchClient(Collection<Cliente> lstClientes, String toSearch) throws NullPointerException{
        for(Cliente cliente: lstClientes){
            if(toSearch.equals((cliente.getNombre()))){
                this.foundCliente = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundCliente){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return null;
}
    
}
