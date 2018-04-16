import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Mateo Marin
 */
public final class Administrador extends Usuario implements Searchable, Findable{
    public DiarioFacil dF;
    private boolean foundObject;

    public int i = 0;
    {
        dF = new DiarioFacil();
    }
    public Administrador (){}
    
    public Administrador(String nombre,String contraseña,String cedula,String telefono){
        super(nombre,contraseña,cedula,telefono);
    }

    //In this case <T> doesnt work well with varArgs
    
    public <T> void create(String nuevo, T... varArgs){
        switch (nuevo){
            case "producto":
                if(!search(dF.getLstProductos(), nuevo)){
                dF.getLstProductos().add(new Producto((String) varArgs[0],(String) varArgs[1],(Integer) varArgs[2]));
                }else{
                    System.out.println("Este producto ya existe");
                }
                break;
            case "categoria":
                if(!search(dF.getLstCategorias(), nuevo)){
                dF.getLstCategorias().add(new Categoria((String) varArgs[0], (List<Producto>) varArgs[1]));
                }else{
                    System.out.println("Esta categoria ya existe");
                }
                break;
            case "proveedor":
                if(!search(dF.getLstProveedores(), nuevo)){
                dF.getLstProveedores().add(new Proveedor((String) varArgs[0],(String) varArgs[1], (List<Producto>) varArgs[2]));
                }else{
                    System.out.println("Este proveedor ya existe");
                }
                break;
            case "pedido":
                if(!search(dF.getLstPedidos(), nuevo)){
                    
                dF.getLstPedidos().add(new Pedido((String) varArgs[0], (Proveedor) varArgs[1], (List<Producto>) varArgs[2], Date.from(Instant.now())));
                }else{
                    System.out.println("Este pedido ya existe");
                }
                break;
            default:
                System.out.println(nuevo + " is not a valid option; please insert a valid option");
        }
        Collections.sort(dF.getLstProductos(), new PriceComparator());
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
            if(objeto instanceof Producto && !search(dF.getLstProductos(),objeto)){
                dF.getLstProductos().add((Producto) objeto);
            }else if(objeto instanceof Producto && search(dF.getLstProductos(),objeto)){
                System.out.printf("El producto %s ya existe en la lista\n", ((Producto) objeto).getNombre());}
            if(objeto instanceof Categoria && !search(dF.getLstCategorias(),objeto)){
                dF.getLstCategorias().add((Categoria) objeto);
            }else if(objeto instanceof Producto && search(dF.getLstCategorias(),objeto)){
                System.out.printf("La categoria %s ya existe en la lista\n", ((Categoria) objeto).getNombre());}
            if(objeto instanceof Proveedor && !search(dF.getLstProveedores(),objeto)){
                dF.getLstProveedores().add((Proveedor) objeto);
            }else if(objeto instanceof Producto && search(dF.getLstProveedores(),objeto)){
                System.out.printf("El proveedor %s ya existe en la lista\n", ((Proveedor) objeto).getNombre());}
            if(objeto instanceof Pedido && !search(dF.getLstPedidos(),objeto)){
                dF.getLstPedidos().add((Pedido) objeto);
            }else if(objeto instanceof Producto && search(dF.getLstPedidos(),objeto)){
                System.out.printf("El pedido %s ya existe en la lista\n", ((Pedido) objeto).getPedidoId());}
            }
        }

    protected <T> void add_Objects(T... objeto){
        for(int i=0;i<objeto.length;i++){
            if(objeto[i] instanceof Producto){
                System.out.println(search(dF.getLstProductos(),objeto[i]));
                if(!search(dF.getLstProductos(),objeto[i])){
                    dF.getLstProductos().add((Producto) objeto[i]);
                }else{
                    System.out.printf("El producto %s ya existe en la lista\n", ((Producto) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Categoria){
                if(search(dF.getLstCategorias(),objeto[i])){
                    dF.getLstCategorias().add((Categoria) objeto[i]);
                }else{
                    System.out.printf("La categoria %s ya existe en la lista\n", ((Categoria) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Proveedor){
                if(search(dF.getLstProveedores(),objeto[i])){
                    dF.getLstProveedores().add((Proveedor) objeto[i]);
                }else{
                    System.out.printf("El proveedor %s ya existe en la lista\n", ((Proveedor) objeto[i]).getNombre());
            }}if(objeto[i] instanceof Pedido){
                if(search(dF.getLstPedidos(),objeto[i])){
                    dF.getLstPedidos().add((Pedido) objeto[i]);
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
        if(search(dF.getLstProductos(), producto))
            dF.getLstProductos().remove(producto);
        else
            System.out.printf("Este %s no existe en el inventario\n", producto.getNombre());
    }
    
    public void eliminarCategoria(Categoria categoria){//El metodo para eliminar una categoria
        if(search(dF.getLstCategorias(), categoria))
            dF.getLstCategorias().remove(categoria);
        else
            System.out.printf("Esta %s no existe en el sistema\n", categoria.getNombre());
   }

    public void eliminarProveedor(Proveedor proveedor){//El metodo para eliminar un proveedor
        if(search(dF.getLstProveedores(), proveedor))
            dF.getLstProveedores().remove(proveedor);
        else
            System.out.printf("Este %s no existe en el sistema\n", proveedor.getNombre());
   }
    
protected <T> void delete(T... objectToDelete){//El metodo para eliminar un usuario. Es void pero se debe tal vez cambiar
        objectToDelete = null;
    }

    public boolean getFoundObject() {
        return foundObject;
    }

    public void setFoundObject(boolean foundObject) {
        this.foundObject = foundObject;
    }
    
    @Override
    public <T> boolean search(Collection lstObjects, T object) throws ClassCastException, NullPointerException{
        return lstObjects.contains(object);
    }
    
    @Override
    public <T> Boolean found(T objeto){
        return foundObject;
    }
}