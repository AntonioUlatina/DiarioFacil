/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;
/**
 *
 * @author Pavilion
 */
public class PriceComparator implements Comparator<Producto>{
    
    @Override
    public double compare(final Producto left, final Producto right){
        return -1 * Integer.compare(left.getPrecio(), right.getPrecio());
    }
}
