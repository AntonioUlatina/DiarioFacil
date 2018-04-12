
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
public class Carrito {

    private List<Item> lstItems = new ArrayList<>();
    private List<Promocion> lstPromociones = new ArrayList<>();
    private List<Combo> lstCombos = new ArrayList<>();
    private Cliente cliente;
    private boolean foundItem;
        int i = 0;
    public Carrito() {
    }

    public Carrito(List lstItems, List lstPromociones, List lstCombos, Cliente cliente) {
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

    public void addItem(Item... toAdd) {
        for(Item item: toAdd){
        if(searchItem(item)) {
            System.out.printf("Este %s ya habia sido agregado al carrito\n", item.getClass().getName());
        } else {
            lstItems.add(item);
            System.out.printf("Agregaste %s al carrito\n", item.getClass().getName());
                }
            } 
        }

    public boolean searchItem(Item item) throws ClassCastException, NullPointerException {
                        return lstItems.contains(item);
    }

    public void deleteItem(Collection<Item> lstItems, Item toDelete) {//El metodo para eliminar un producto
        if (searchItem(toDelete)) {
            lstItems.remove(toDelete);
        }
    }

    public void modificarCantidad(String toModify, int cantidad) {
        for (Item item : this.getLstItems()) {
            System.out.println(item.getClass());
        }
    }

}
