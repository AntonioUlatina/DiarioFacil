/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class TesterItem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Item producto = new Producto("enchiladas");
        Item promocion = new Promocion ("2X1");
        Item combo1 = new Combo ("enchiladas supreme");
        
        Carrito carrito = new Carrito();
        carrito.addItem(producto);
        carrito.addItem(promocion);
        carrito.addItem(combo1);
        carrito.addItem(producto);
        
        
    }
    
}
