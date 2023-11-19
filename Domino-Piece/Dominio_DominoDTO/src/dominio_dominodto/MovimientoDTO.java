/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class MovimientoDTO implements Serializable{

    private FichaTableroDTO fichaTablero;
    private int zona;
    private boolean valido;
    
    public MovimientoDTO(){
        valido=false;
    }
    public MovimientoDTO(FichaTableroDTO fichaTablero, int zona) {
        this.fichaTablero = fichaTablero;
        this.zona = zona;
        valido=false;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    

    public FichaTableroDTO getFichaTablero() {
        return fichaTablero;
    }

    public void setFichaTablero(FichaTableroDTO fichaTablero) {
        this.fichaTablero = fichaTablero;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

}

