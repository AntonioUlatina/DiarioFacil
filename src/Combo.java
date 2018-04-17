
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
class Combo extends Item{

    private Date diaPromocion;
    private Period periodoOferta;
    private int descuento;
    private int precioCombo;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Combo(){}
    
    //este es un constructor con proposito de test solamente 
    public Combo(String nombre) {
        this.nombre = nombre;
    }

    public Combo(Date diaPromocion, Period periodoOferta, int descuento, int precioCombo, String nombre, int cantidad) {
        super(cantidad);
        this.diaPromocion = diaPromocion;
        this.periodoOferta = periodoOferta;
        this.descuento = descuento;
        this.precioCombo = precioCombo;
        this.nombre = nombre;
    }
    
    public Combo(Date diaPromocion,Period periodoOferta, int descuento, int precioCombo){
        this.diaPromocion = diaPromocion;
        this.periodoOferta = periodoOferta;
        this.descuento = descuento;
        this.precioCombo = precioCombo;
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

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPrecioCombo() {
        return precioCombo;
    }

    public void setPrecioCombo(int precioCombo) {
        this.precioCombo = precioCombo;
    }

    @Override
    public String toString() {
        return "Combo{" + ", diaPromocion=" + diaPromocion + ", periodoOferta=" + periodoOferta + ", descuento=" + descuento + ", precioCombo=" + precioCombo + '}';
    }
    
}
