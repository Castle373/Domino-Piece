/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_domino;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class Tablero {

    private List<FichaTablero> fichasTablero;

    public Tablero() {
        this.fichasTablero = new ArrayList<>();
    }

    public List<FichaTablero> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(List<FichaTablero> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    public void addFichasTablero(FichaTablero fichaT) {
        fichasTablero.add(fichaT);
    }
    public void agregarInicio(FichaTablero fichaT){
        fichasTablero.add(0, fichaT);
    }
    public FichaTablero getExtremoDerecho() {
        if (fichasTablero.isEmpty()) {
            return null;
        }
        return fichasTablero.get(fichasTablero.size() - 1);
    }

    public FichaTablero getExtremoIzquierdo() {
        if (fichasTablero.isEmpty()) {
            return null;
        }
        return fichasTablero.get(0);
    }
    
    public boolean validaZonaInical(FichaTablero ficha){
    
        if (ficha.isMula()) {
                addFichasTablero(ficha);
                return true;
        }
        return false;
    }
            
    public boolean validaLadoDerecho(FichaTablero ficha) {

        FichaTablero fichaExtremo = getExtremoDerecho();
        if (fichaExtremo != null) {
            int puntoExtremo;
            if (fichaExtremo.isConectarArriba()) {
                puntoExtremo = fichaExtremo.getPuntoAbajo();
            } else {
                puntoExtremo = fichaExtremo.getPuntoArriba();
            }

            if (ficha.getPuntoArriba() == puntoExtremo) {
                ficha.setConectarArriba(true);
                addFichasTablero(ficha);
                return true;
            } else if (ficha.getPuntoAbajo()== puntoExtremo) {
                ficha.setConectarAbajo(true);
                addFichasTablero(ficha);
                return true;
            }

        }
        return false;
    }

    public boolean validaLadoIzquierdo(FichaTablero ficha) {
        FichaTablero fichaExtremo = getExtremoIzquierdo();
        if (fichaExtremo != null) {
            int puntoExtremo;
            if (fichaExtremo.isConectarArriba()) {
                puntoExtremo = fichaExtremo.getPuntoArriba();
            } else {
                puntoExtremo = fichaExtremo.getPuntoAbajo();
            }

            if (ficha.getPuntoArriba() == puntoExtremo) {
                ficha.setConectarAbajo(true);
                agregarInicio(ficha);
                return true;
            } else if (ficha.getPuntoAbajo()== puntoExtremo) {
                ficha.setConectarArriba(true);
                agregarInicio(ficha);
                return true;
            }

        }
        return false;
    }
}
