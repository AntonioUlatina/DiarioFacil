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
        Administrador a = new Administrador();
        //Producto p1 = new Producto();
        //Producto p2 = new Producto();
        //Producto p3 = new Producto();
        //Categoria c = new Categoria("wines", a.getLstProductos());
        //a.addObjects(p1, p2, p3, c);
        a.create("producto", "Queso", "Galleta", 3);
        a.create("producto", "milk", "lacteo", 10);
        a.create("categoria", "Lacteos", a.getLstProductos());
        //System.out.println(a.getLstCategorias());
        a.search(a.getLstCategorias(), "Lacteos");
        a.search(a.getLstProductos(), "milk");
        System.out.println(a.getProducto());
        a.search(a.getLstProductos(), "Queso");
        System.out.println(a.getProducto());
        a.search(a.getLstCategorias(), "Lacteos");
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
    }
}
