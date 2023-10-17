package dominio_domino;

import java.awt.Image;

/**
 *
 * @author IVAN
 */
public class FichaTablero extends Ficha{
    boolean conectarAbajo;
    boolean conectarArriba;
    public FichaTablero() {
    }

    public FichaTablero(Image imagen, int puntoAbajo, int puntoArriba) {
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
