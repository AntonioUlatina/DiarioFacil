
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 * @param <T>
 */

public interface Searchable/*<T>*/ {
    
    <T> void search(Collection<T> lstObjects, String toSearch) throws NullPointerException;
    //public Object searchObject(Collection<Object> lstObjects, String toSearch) throws NullPointerException;
}
