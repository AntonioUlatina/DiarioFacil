
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateo Marin
 */
public class Carrito{
    private List<Item> lstItems = new ArrayList<>();
    private List<Promocion> lstPromociones = new ArrayList<>();
    private List<Combo> lstCombos = new ArrayList<>();
    private Cliente cliente;
    private boolean foundItem;
    
    public Carrito(){}
    
    public Carrito(List lstItems, List lstPromociones,List lstCombos, Cliente cliente){
        this.cliente = cliente;
        this.lstItems = lstItems;
        this.lstCombos = lstCombos;
        this.lstPromociones = lstPromociones;
    }

    public List<Item> getLstItems() {
        return lstItems;
    }

    public List<Promocion> getLstPromociones() {
        return lstPromociones;
    }

    public List<Combo> getLstCombos() {
        return lstCombos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setLstItems(List<Item> lstItems) {
        this.lstItems = lstItems;
    }

    public void setLstPromociones(List<Promocion> lstPromociones) {
        this.lstPromociones = lstPromociones;
    }

    public void setLstCombos(List<Combo> lstCombos) {
        this.lstCombos = lstCombos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
<<<<<<< HEAD
    public <T> void addItem(Collection<Item> lstItems, Item toAdd){
        if(searchItem(lstItems, toAdd)){
            System.out.printf("Este %s ya habia sido anadido al carrito", toAdd);
        }else{
            lstItems.add(toAdd);
        }
=======

    
    public boolean searchItem(Collection<Item> lstItems, Item toSearch) throws NullPointerException{
        try{
        for(Item item: lstItems){
            if(toSearch.equals((item.getProducto().getNombre()))){
                this.foundItem = true;
                System.out.println("El producto " + toSearch + " se encuentra en la lista.");
                break;
            }
            if(toSearch.equals((item.getCombo().getNombre()))){
                this.foundItem = true;
                System.out.println("El combo " + toSearch + " se encuentra en la lista.");
                break;
            }
            if(toSearch.equals((item.getPromocion().getNombre()))){
                this.foundItem = true;
                System.out.println("La promocion " + toSearch + " se encuentra en la lista.");
                break;
            }
        
        if(!this.foundItem){
            System.out.println(toSearch + " no esta en la lista");
        }
    }
        return this.foundItem;
        }finally{
        this.foundItem = false;
                }
}
    
    public void deleteItem(Collection<Item> lstItems, Item toDelete){//El metodo para eliminar un producto
            if(searchItem(lstItems, toDelete))
                lstItems.remove(toDelete);
    }
}
