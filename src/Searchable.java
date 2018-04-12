
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
    
    <T> boolean searchObject(Collection<T> lstObjects, String toSearch) throws ClassCastException, NullPointerException;
    <T> boolean search(Collection lstObjects, T object) throws ClassCastException, NullPointerException;
}
