
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 */
public class lst {
    static Integer[] a = {0,1,2,3,4,5,6};
    static Integer[] b = {};
    
    static List n = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> u = new ArrayList<>();
        u = Arrays.asList(a);
        //n.addAll(u);
        System.out.print(Collections.EMPTY_LIST.contains(2));
    }
    
}
