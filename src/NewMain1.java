/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 */
public class NewMain1 {

   public static void printStar(int n){
    while(n > 0){
        System.out.print("\t");
        n--;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //printStar(10);
        DiarioFacil dF = new DiarioFacil();
        Administrador a = new Administrador();
        Producto p1 = new Producto("n");
        Producto p2 = new Producto("u");
        Producto p3 = new Producto("t");
        Categoria c = new Categoria("wines", dF.getLstProductos());
        System.out.println(a.search(dF.getLstProductos(), p1));
        a.addObjects(p1, p2, p3, c);
        System.out.println(a.search(dF.getLstProductos(), p1));
        a.create("producto", "Queso", "Galleta", 3, "lacteos");
        a.create("producto", "milk", "lacteo", 10, "lacteos");
        a.create("categoria", "Lacteos", dF.getLstProductos());
        a.addObjects(p2, p3);
        //System.out.println(a.getLstCategorias());
        a.search(dF.getLstCategorias(), "Lacteos");
        a.search(dF.getLstProductos(), "milk");
        a.search(dF.getLstProductos(), "Queso");
        //System.out.println(a.getProducto());
        //System.out.println(a.search(a.getLstCategorias(), "Lacteos"));
        //System.out.println(a.getFoundObject());
        /*
        for(Producto p: a.getLstProductos()){
            System.out.println(p);
            System.out.println(a.getLstCategorias());
        }
        a.addObjects(p1,p2,p3);
        a.search(a.getLstProductos(), "null");
        //System.out.println(a.getFoundObject());
        a.search(a.getLstCategorias(), "Lacteos");
                //System.out.println(a.getFoundObject());
        System.out.println(a.getLstProductos());
        //a.delete(a.getLstProductos().get(0));
        //System.out.println(a.getLstProductos());
        //a.delete(a.getLstProductos().get(0),a.getLstCategorias().get(0));
        //System.out.println(a.getLstProductos());
    }   
    */
       Usuario cliente1 = new Cliente ();
        cliente1.setCedula("12345678");
        cliente1.setNombre("Mateo Marin");
        cliente1.setTelefono("84863651");
        cliente1.setContraseña("vaca94");
        
       
                
        Usuario cliente2 = new Cliente ();
        cliente2.setCedula("117580729");
        cliente2.setNombre("Luis Fernandez");
        cliente2.setTelefono("83730387");
        cliente2.setContraseña("reloj123");
        
        Usuario cliente3 = new Cliente ();
        cliente3.setCedula("115689435");
        cliente3.setNombre("Antonio Alvarez");
        cliente3.setTelefono("88987432");
        cliente3.setContraseña("gallina23");
        
        Usuario administrador1 = new Administrador();
        administrador1.setNombre("Jaime");
        administrador1.setCedula("123456789");
        administrador1.setTelefono("22253625");
        administrador1.setContraseña("chirulo76");
        
        Usuario administrador2 = new Administrador();
        administrador2.setNombre("Pedro");
        administrador2.setCedula("987654321");
        administrador2.setTelefono("88988754");
        administrador2.setContraseña("pedro123"); 
        
        
    }
}
