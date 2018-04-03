
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
public class Cliente extends Usuario {
    private String direccion;
    private List<Orden> lstOrdenes;//El cliente tiene una lista de ordenes para poder ver sus ordenes antiguas
    public Cliente(){}
    
    public Cliente(String direccion,ArrayList<Orden> lstOrdenes, String nombre,String contraseña,String cedula,String telefono){
        super(nombre,contraseña,cedula,telefono);
        this.direccion = direccion;
        this.lstOrdenes = lstOrdenes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Orden> getLstOrdenes() {
        return lstOrdenes;
    }

    public void setLstOrdenes(List<Orden> lstOrdenes) {
        this.lstOrdenes = lstOrdenes;
    }

    @Override
    public String toString() {
        return "Cliente{" + "direccion=" + direccion + ", lstOrdenes=" + lstOrdenes + '}';
    }
    
    
}
