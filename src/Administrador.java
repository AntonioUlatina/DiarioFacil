import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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
public final class Administrador extends Usuario implements Searchable{
    private List<Proveedor> lstProveedores = new ArrayList<>(); 
    private List<Pedido> lstPedidos = new ArrayList<>();
    private List<Producto> lstProductos = new ArrayList<>();
    private List<Categoria> lstCategorias = new ArrayList<>();
    private boolean foundObject;
    private Producto producto;
    
    public Administrador (){}
    
    public Administrador(String nombre,String contraseña,String cedula,String telefono,ArrayList<Proveedor> lstProveedores,ArrayList<Pedido> lstPedidos,ArrayList<Producto> lstProductos,ArrayList<Categoria> lstCategorias){
        super(nombre,contraseña,cedula,telefono);
        this.lstProductos = lstProductos;
        this.lstCategorias = lstCategorias;
        this.lstProveedores = lstProveedores;
        this.lstPedidos = lstPedidos;
    }

    protected List<Proveedor> getLstProveedores() {
        return lstProveedores;
    }

    protected List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    protected List<Producto> getLstProductos() {
        return lstProductos;
    }

    protected List<Categoria> getLstCategorias() {
        return lstCategorias;
    }

    protected void setLstProveedores(List<Proveedor> lstProveedores) {
        this.lstProveedores = lstProveedores;
    }

    protected void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    protected void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    protected void setLstCategorias(List<Categoria> lstCategorias) {
        this.lstCategorias = lstCategorias;
    }
    //In this case <T> doesnt work well with varArgs
    
    protected <T> void create(String nuevo, T... varArgs){
        switch (nuevo){
            case "producto":
                if(!search(lstProductos, nuevo)){
                this.lstProductos.add(new Producto((String) varArgs[0],(String) varArgs[1],(Integer) varArgs[2]));
                }else{
                    System.out.println("Este producto ya existe");
                }
                break;
            case "categoria":
                if(!search(lstCategorias, nuevo)){
                this.lstCategorias.add(new Categoria((String) varArgs[0], (List<Producto>) varArgs[1]));
                }else{
                    System.out.println("Esta categoria ya existe");
                }
                break;
            case "proveedor":
                if(!search(lstProveedores, nuevo)){
                this.lstProveedores.add(new Proveedor((String) varArgs[0],(String) varArgs[1], (List<Producto>) varArgs[2]));
                }else{
                    System.out.println("Este proveedor ya existe");
                }
                break;
            case "pedido":
                if(!search(lstPedidos, nuevo)){
                this.lstPedidos.add(new Pedido((String) varArgs[0], (Proveedor) varArgs[1], (List<Producto>) varArgs[2], Date.from(Instant.now())));
                }else{
                    System.out.println("Este pedido ya existe");
                }
                break;
            default:
                System.out.println(nuevo + " is not a valid Class; please insert a valid Class");
        }
        Collections.sort(lstProductos, new PriceComparator());
    }

//Might be unnecesary but I'd like to keep it, to understand the interaction between this method and create.
/*
    protected void add(Object objeto){
        //Inside create():
            //this.add(new Producto((String) varArgs[0],(String) varArgs[1],(int) varArgs[2]));
        if (objeto instanceof Producto)
            this.lstProductos.add((Producto) objeto);
            //add(new Categoria((String) varArgs[0], (List<Producto>) varArgs[1]));
        if (objeto instanceof Categoria)
            this.lstCategorias.add((Categoria) objeto);
            //add(new Proveedor((String) varArgs[0],(String) varArgs[1], (List<Producto>) varArgs[2]));
        if (objeto instanceof Proveedor)
            this.lstProveedores.add((Proveedor) objeto);
            //add(new Pedido((String) varArgs[0], (Proveedor) varArgs[1], (List<Producto>) varArgs[2], Date.from(Instant.now())));
        if (objeto instanceof Pedido)
            this.lstPedidos.add((Pedido) objeto);
    }
*/  
    //Generic should be T(for type) by java convention
    protected <Generic> void addObjects(Generic... Objetos){
        for(Generic objeto: Objetos){
            if(objeto instanceof Producto)
                this.lstProductos.add((Producto) objeto);
            if (objeto instanceof Categoria)
                this.lstCategorias.add((Categoria) objeto);
            if (objeto instanceof Proveedor)
                this.lstProveedores.add((Proveedor) objeto);
            if (objeto instanceof Pedido)
                this.lstPedidos.add((Pedido) objeto);
        }
    }
    protected void modificarCliente(Cliente cliente, String field, String fieldValue){ //El metodo para modificar un usuario.Es void se debe tal vez cambiar
        switch(field){
            case "nombre":
                cliente.setNombre(fieldValue);
                break;
            case "cedula":
                cliente.setCedula(fieldValue);
                break;
            case "direccion":
                cliente.setDireccion(fieldValue);
                break;
            case "telefono":
                cliente.setTelefono(fieldValue);
                break;
            default:
                System.out.println("Please insert a valid field.");
        }
    }
    
    public <T> void modificarProducto(Producto producto, String field, T fieldValue){//El metodo para modificar un producto
        switch(field){
            case "nombre":
                producto.setNombre((String) fieldValue);
                break;
            case "descripcion":
                producto.setDescripcion((String) fieldValue);
                break;
            case "precio":
                producto.setPrecio((Integer) fieldValue);
                break;
            default:
                System.out.println("Please insert a valid field.");
        }
    }
    
    public <T> void modificarCategoria(Categoria categoria, String field, T fieldValue){//El metodo para modificar una categoria
        switch(field){
            case "nombre":
                categoria.setNombre((String) fieldValue);
                break;
            case "productos":
                categoria.setLstProductos((List<Producto>) fieldValue);
                break;
            default:
                System.out.println("Please insert a valid field.");
        }
    }
   
    public <T> void modificarProveedor(Proveedor proveedor, String field, T fieldValue){//El metodo para modificar un proveedor
        switch(field){
            case "nombre":
                proveedor.setNombre((String) fieldValue);
                break;
            case "email":
                proveedor.setEmail((String) fieldValue);
                break;
            case "productos":
                proveedor.setLstProductos((List<Producto>) fieldValue);
                break;
            default:
                System.out.println("Please insert a valid field.");
        }
    }
    
    protected void eliminarCliente(Cliente cliente) throws NullPointerException{//El metodo para eliminar un usuario. Es void pero se debe tal vez cambiar
        cliente = null;
    }
    
    public void eliminarProducto(Producto producto){//El metodo para eliminar un producto
        producto = null;
    }
    
    public void eliminarCategoria(Categoria categoria){//El metodo para eliminar una categoria
       categoria = null;
   }

    public void eliminarProveedor(Proveedor proveedor){//El metodo para eliminar un proveedor
       proveedor = null;
   }
    
protected <T> void delete(T... objectToDelete){//El metodo para eliminar un usuario. Es void pero se debe tal vez cambiar
        objectToDelete = null;
    }
    
    protected <T> T retrieve(List<T> lst){
        for(T object: lst){
            if(object instanceof Producto){
                //((Producto) object).
            }
        }
        return null;
    }
   /* 
    @Override
    public <T> String search(Collection<T> lstObjects, String toSearch) throws NullPointerException{
        String match = "";
        Iterator lstIt;
        for(T object: lstObjects){
            do{
                lstIt.next();
            }while(lstIt.hasNext())
        if(object instanceof Producto){
           if(!toSearch.equals(((Producto) object).getNombre())){
               System.out.println(toSearch + " no fue encontrado.");
               continue;
           }
            match = ("Hay " + toSearch + " disponible.");
        }
        }
        return match;
        }
    */

    public boolean getFoundObject() {
        return foundObject;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setFoundObject(boolean foundObject) {
        this.foundObject = foundObject;
    }
    
    public <T> boolean search(Collection<T> lstObjects, String toSearch) throws NullPointerException{
        try{
        for(T object: lstObjects){
            if((object instanceof Producto && toSearch.equals(((Producto) object).getNombre()))){
                this.foundObject = true;
                this.producto = (Producto) object;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Categoria && toSearch.equals(((Categoria) object).getNombre()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Proveedor && toSearch.equals(((Proveedor) object).getNombre()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Pedido && toSearch.equals(((Pedido) object).getPedidoId()))){
                this.foundObject = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
        }
        
        if(!this.foundObject){
            System.out.println(toSearch + " no esta en la lista");
        }
        return this.foundObject;
        }finally{
        this.foundObject = false;
                }
    }
}
        /*
        System.out.println("Queso".equals("Qeso"));
        
        String temp = null;
        Boolean b = null;
        System.out.println("Boolean " + b + "  ");
       
        for(T object: lstObjects){
        //temp = lstObjects.contains(toSearch) ? object : null;
        System.out.println(((Producto) object).getNombre());
        if(object instanceof Producto){
            //if(((Producto) object).getNombre().contains(toSearch)){
            
            if(toSearch.equals(((Producto) object).getNombre())){
                return (T) ("Hay " + ((Producto) object).getNombre() + " disponible.");
            }
        }else{
                temp = "No esta en la lista";
            }
        //temp = toSearch.equals(((Producto) object).getNombre()) ? ((Producto) object).getNombre() : "No esta en la lista";
        //System.out.print(toSearch.equals(((Producto) object).getNombre()));
        }
        return (T) temp;
    
    }
*/

