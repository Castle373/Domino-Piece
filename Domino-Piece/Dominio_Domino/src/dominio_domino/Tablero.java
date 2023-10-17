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

}
