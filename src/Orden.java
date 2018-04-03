
import java.util.ArrayList;
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
    private Date fechaCreacion;
    //private TreeMap<Item> lstItems;
    private List<Item> lstItems = new ArrayList<>();
    
    public Orden(){}
    
    public Orden(Cliente cliente, Carrito carrito, Date fechaCreacion){
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
    
    public double getMontoTotal() {
        double monto = 0.0;
        for (Item item : this.lstItems) {
            monto = monto + item.subTotal();
        }
        return monto;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void mensajeOrden() throws ChiquitinasException {

        if (this.getMontoTotal() > 700) {
            throw new ChiquitinasException("Eres V.I.P.");
        } else {
            throw new ChiquitinasException("Gracias por preferirnos");
        }
    }

 
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(); //El StringBuffer funciona para concatenar las cosas para imprimirlas en ves del to string
        sb.append("Nombre: " + this.getCliente().getNombre() + "\t\t" + "No.Orden: " + this.getNumeroOrden() + "\n");
        sb.append("Telefono: " + this.getCliente().getTelefono() + "\t" + "Fecha: " + this.getFechaCreacion() + "\n");
        sb.append("Direccion: " + this.getCliente().getDireccion() + "\n");
        sb.append("Representante: " + this.getCliente().demeTipoCliente() + "\n");
        sb.append("================================================================================================\n");
        sb.append("Consecutivo\tCantidad\tDescripcion\tP/U\tDescuento\tSubTotal\n");
        sb.append("================================================================================================\n");
        int consecutivo = 1;
        for (Item item : this.lstItems) {
            String valorDescuento = (item.getProducto().demeDescuentoProducto() * 100) + "%";
            sb.append(consecutivo++ + "\t\t" + item.getCantidad() + "\t\t" + item.getProducto().getNombreProducto() + "\t\t" + item.getProducto().getPrecio() + "\t" + valorDescuento + "\t\t" + item.subTotal() + "\n");//Asi se revisa por lista       
        }
        double montoTotal = this.getMontoTotal();
        sb.append("================================================================================================\n");
        sb.append("\t\t\t\t\t\t\t\tTOTAL:  " + montoTotal + "\n");
        sb.append("================================================================================================\n");

        try {
            this.mensajeOrden();
        } catch (Exception e) {
            sb.append(e.getMessage());
        }

        return sb.toString();

    }
    
}
