
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 */
public interface Foundable extends Searchable{
    <T> Boolean found(T searched);
    //To be passed to an Interface called Modifiable
    <T> T modify(T searched, Collection<T> toModify);
    //public <T> T search(Collection<T> lstObjects, String toSearch) throws NullPointerException;
    //public Object searchObject(Collection<Object> lstObjects, String toSearch) throws NullPointerException;
}
