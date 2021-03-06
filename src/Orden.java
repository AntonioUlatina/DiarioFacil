
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateo Marin
 */
class Orden {

    private Cliente cliente;
    private Carrito carrito;
    private String orderID;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Item> getLstItems() {
        return lstItems;
    }

    public void setLstItems(List<Item> lstItems) {
        this.lstItems = lstItems;
    }

    public boolean isFoundOrder() {
        return foundOrder;
    }

    public void setFoundOrder(boolean foundOrder) {
        this.foundOrder = foundOrder;
    }
    private Date fechaCreacion;
    //private TreeMap<Item> lstItems;
    private List<Item> lstItems = new ArrayList<>();
    private boolean foundOrder;

    public Orden() {
    }

    public Orden(Cliente cliente, Carrito carrito, Date fechaCreacion) {
        this.cliente = cliente;
        this.carrito = carrito;
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Orden searchOrder(Collection<Orden> lstOrdenes, String toSearch) throws NullPointerException {
        System.out.println("El queso " + this.foundOrder);
        for (Orden order : lstOrdenes) {
            if (toSearch.equals(order.getOrderID())) {
                this.foundOrder = true;
                System.out.println(toSearch + " se encuentra en la lista.");
                break;
            }

            if (!this.foundOrder) {
                System.out.println(toSearch + " no esta en la lista");
            }
        }
        return null;
    }

    /*public double getMontoTotal() {     
        double monto = 0.0;
        for (Item item : this.lstItems) {
            monto = monto + item.subTotal();
        }
        return monto;
    }

    public void setMontoTotal(double montoTotal) {
        this.Total = Total;
    }*/

    public String toString() {
        StringBuffer sb = new StringBuffer(); //El StringBuffer funciona para concatenar las cosas para imprimirlas en ves del to string
        sb.append("Nombre: " + this.getCliente().getNombre() + "\t\t" + "No.Orden: " + this.getOrderID() + "\n");
        sb.append("Telefono: " + this.getCliente().getTelefono() + "\t");
        sb.append("Direccion: " + this.getCliente().getDireccion() + "\n");
        sb.append("================================================================================================\n");
        sb.append("Consecutivo\tCantidad\tDescripcion\tP/U\tDescuento\tSubTotal\n");
        sb.append("================================================================================================\n");
      /*  int consecutivo = 1;
        for (Item item : this.lstItems) {
            String valorDescuento = (item.get().ponerDescuento() * 100) + "%";
            sb.append(consecutivo++ + "\t\t" + item.getCantPro() + "\t\t" + item.getProducto().getNombreProduc() + "\t\t" + item.getProducto().getPrecio() + "\t" + valorDescuento + "\t\t" + item.subTotal() + "\n");//Asi se revisa por lista       
        }
        double montoTotal = this.getMontoTotal();
        sb.append("================================================================================================\n");
        sb.append("\t\t\t\t\t\t\t\tTOTAL:  " + montoTotal + "\n");
        sb.append("================================================================================================\n");  */
        return sb.toString();
    }

}
