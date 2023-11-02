/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class FichaDTO implements Serializable{
    protected String imagen;
    protected int puntoAbajo;
    protected int puntoArriba;
    protected boolean mula;

    public FichaDTO() {
    }

    public FichaDTO(String imagen, int puntoAbajo, int puntoArriba) {
        this.imagen = imagen;
        this.puntoAbajo = puntoAbajo;
        this.puntoArriba = puntoArriba;
        this.mula = (puntoAbajo == puntoArriba);
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPuntoAbajo() {
        return puntoAbajo;
    }

    public void setPuntoAbajo(int puntoAbajo) {
        this.puntoAbajo = puntoAbajo;
    }

    public int getPuntoArriba() {
        return puntoArriba;
    }

    public void setPuntoArriba(int puntoArriba) {
        this.puntoArriba = puntoArriba;
    }

    public boolean isMula() {
        return mula;
    }

    public void setMula(boolean mula) {
        this.mula = mula;
    }
    
}
