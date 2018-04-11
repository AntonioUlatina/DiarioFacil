
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
public abstract class Usuario {
    protected String nombre;
    protected String contraseña;
    protected String cedula;
    protected String telefono;
    //protected boolean permisos; //Esto va ser para quien puede ver que cosas pero no lo siento util porque los metodos solo van en adm
    private boolean foundUser;
    
    Usuario(){};
    
    Usuario(String nombre, String contraseña, String cedula, String telefono){
        this.nombre = nombre;
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.telefono = telefono;
        //this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }
    
    //public boolean getPermisos(){
        //return permisos;
    //}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //public void setPermisos(boolean permisos){
        //this.permisos = permisos;
    //}

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", cedula=" + cedula + ", telefono=" + telefono + '}';
    }
    
    public Usuario searchUser(Collection<Usuario> lstProductos, String toSearch) throws NullPointerException{

        for(Usuario user: lstProductos){
            if(toSearch.equals((user.getNombre()))){
                this.foundUser = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundUser){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return null;
}
}
