import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mateo Marin
 */
public final class Administrador extends Usuario implements Searchable, Findable{
    private List<Proveedor> lstProveedores = new ArrayList<>(); 
    private List<Pedido> lstPedidos = new ArrayList<>();
    private List<Producto> lstProductos = new ArrayList<>();
    private List<Categoria> lstCategorias = new ArrayList<>();
    private boolean foundObject;
    private Producto producto;
    public int i = 0;
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
            if(objeto instanceof Producto && !search(lstProductos,objeto)){
                this.lstProductos.add((Producto) objeto);
            }else if(objeto instanceof Producto && search(lstProductos,objeto)){
                System.out.printf("El producto %s ya existe en la lista\n", ((Producto) objeto).getNombre());}
            if(objeto instanceof Categoria && !search(lstCategorias,objeto)){
                this.lstCategorias.add((Categoria) objeto);
            }else if(objeto instanceof Producto && search(lstCategorias,objeto)){
                System.out.printf("La categoria %s ya existe en la lista\n", ((Categoria) objeto).getNombre());}
            if(objeto instanceof Proveedor && !search(lstProveedores,objeto)){
                this.lstProveedores.add((Proveedor) objeto);
            }else if(objeto instanceof Producto && search(lstProveedores,objeto)){
                System.out.printf("El proveedor %s ya existe en la lista\n", ((Proveedor) objeto).getNombre());}
            if(objeto instanceof Pedido && !search(lstPedidos,objeto)){
                this.lstPedidos.add((Pedido) objeto);
            }else if(objeto instanceof Producto && search(lstPedidos,objeto)){
                System.out.printf("El pedido %s ya existe en la lista\n", ((Pedido) objeto).getPedidoId());}
            }
        }

    protected <T> void add_Objects(T... objeto){
        for(int i=0;i<objeto.length;i++){
            if(objeto[i] instanceof Producto){
                if(!search(lstProductos,objeto[i])){
                    this.lstProductos.add((Producto) objeto[i]);
                }else{
                    System.out.printf("El producto %s ya existe en la lista\n", ((Producto) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Categoria){
                if(search(lstCategorias,objeto[i])){
                    this.lstCategorias.add((Categoria) objeto[i]);
                }else{
                    System.out.printf("La categoria %s ya existe en la lista\n", ((Categoria) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Proveedor){
                if(search(lstProveedores,objeto[i])){
                    this.lstProveedores.add((Proveedor) objeto[i]);
                }else{
                    System.out.printf("El proveedor %s ya existe en la lista\n", ((Proveedor) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Pedido){
                if(search(lstPedidos,objeto[i])){
                    this.lstPedidos.add((Pedido) objeto[i]);
                }else{
                    System.out.printf("El pedido %s ya existe en la lista\n", ((Pedido) objeto[i]).getPedidoId());
                }
            }
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

    public boolean getFoundObject() {
        return foundObject;
    }

    public String getProducto() {
        return producto.getNombre();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setFoundObject(boolean foundObject) {
        this.foundObject = foundObject;
    }
    
    @Override
    public <T> boolean search(Collection lstObjects, T object) throws ClassCastException, NullPointerException{
        return lstObjects.contains(object);
    }
    
   @Override 
    public <T> boolean searchObject(Collection<T> lstObjects, String toSearch) throws ClassCastException, NullPointerException{
        try{
        for(T object: lstObjects){
            if((object instanceof Producto && toSearch.equals(((Producto) object).getNombre()))){
                this.foundObject = true;
                this.producto = (Producto) object;
//                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Categoria && toSearch.equals(((Categoria) object).getNombre()))){
                this.foundObject = true;
//                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Proveedor && toSearch.equals(((Proveedor) object).getNombre()))){
                this.foundObject = true;
//                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }
            if((object instanceof Pedido && toSearch.equals(((Pedido) object).getPedidoId()))){
                this.foundObject = true;
//                System.out.println(toSearch + " se encuentra en la lista.");
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
    
    @Override
    public <T> Boolean found(T objeto){
        return foundObject;
    }
}