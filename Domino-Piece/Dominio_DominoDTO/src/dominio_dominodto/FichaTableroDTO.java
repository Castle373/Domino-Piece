/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.awt.Image;

/**
 *
 * @author diego
 */
public class FichaTableroDTO extends FichaDTO {

    boolean conectarAbajo;
    boolean conectarArriba;

    public FichaTableroDTO(Image imagen, int puntoAbajo, int puntoArriba) {
        super(imagen, puntoAbajo, puntoArriba);
    }

    public boolean isConectarAbajo() {
        return conectarAbajo;
    }

    public void setConectarAbajo(boolean conectarAbajo) {
        this.conectarAbajo = conectarAbajo;
    }

    public boolean isConectarArriba() {
        return conectarArriba;
    }

    public void setConectarArriba(boolean conectarArriba) {
        this.conectarArriba = conectarArriba;
    }

}
