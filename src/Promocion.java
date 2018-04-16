
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
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
class Promocion extends Item{

    //este es un constructor con proposito de test solamente 
    public Promocion(String nombre) {
        this.nombre = nombre;
    }

    public Promocion(Date diaPromocion, Period periodoOferta, String nombre, int numeroConsecutivo, int cantidad) {
        super(numeroConsecutivo, cantidad);
        this.diaPromocion = diaPromocion;
        this.periodoOferta = periodoOferta;
        this.nombre = nombre;
    }
    private List<Item> lstItems = new ArrayList<>();
    private Date diaPromocion;
    private Period periodoOferta;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Promocion(){}
    
    public Promocion(List lstItems, Date diaPromocion, Period periodoOferta){
        this.lstItems = lstItems;
        this.diaPromocion = diaPromocion;
        this.periodoOferta = periodoOferta;
    }

    public List<Item> getLstItems() {
        return lstItems;
    }

    public void setLstItems(List<Item> lstItems) {
        this.lstItems = lstItems;
    }

    public Date getDiaPromocion() {
        return diaPromocion;
    }

    public void setDiaPromocion(Date diaPromocion) {
        this.diaPromocion = diaPromocion;
    }

    public Period getPeriodoOferta() {
        return periodoOferta;
    }

    public void setPeriodoOferta(Period periodoOferta) {
        this.periodoOferta = periodoOferta;
    }
    
    
    public double Descuento (){
        double montoPromo = 0.0;
        for (Item item : this.lstItems) {
            montoPromo = montoPromo + ((Producto) item).getPrecio();
        }
        return montoPromo;

    }
}
