/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import dominio_dominodto.FichaTableroDTO;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class MovimientoPF<T>implements Evento<T>, Serializable {
    private FichaTableroDTO ficha;
    private int zona;
    
    private T movimiento;

    public MovimientoPF(FichaTableroDTO ficha, int zona) {
        this.ficha = ficha;
        this.zona = zona;
    }

    
    
    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public FichaTableroDTO getFicha() {
        return ficha;
    }

    public void setFicha(FichaTableroDTO ficha) {
        this.ficha = ficha;
    }  
    
    @Override
    public void setData(T movimiento) {
        this.movimiento=movimiento;
    }

    @Override
    public T getData() {
        return movimiento;
    }
    
}
