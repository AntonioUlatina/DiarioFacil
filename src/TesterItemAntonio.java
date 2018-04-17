/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 */
public class TesterItemAntonio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Item p = new Producto();
        Item c = new Combo();
        Item pr = new Promocion();
        
        Carrito cart = new Carrito();
        
        cart.addItem(p);
        cart.addItem(c);
        cart.addItem(pr);
        cart.addItem(p);
    }
    
}
