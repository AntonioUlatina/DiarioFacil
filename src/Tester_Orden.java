/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Tester_Orden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
         Cliente c1 = new Cliente ("Mateo Marin","vaca94","12345678","84863651","Heredia");
               
         
         Orden o1 = new Orden();
         
         o1.setOrderID("322");
         o1.setCliente(c1);
         
         
        System.out.println(o1);
        
        
        
        
        
        
    }
    
}
