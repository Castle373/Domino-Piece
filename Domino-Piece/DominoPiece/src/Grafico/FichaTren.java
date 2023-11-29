/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafico;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class FichaTren implements IFichaGrafica {

    List<IFichaGrafica> fichasTrenGraficas;

    public FichaTren() {
            fichasTrenGraficas= new ArrayList<>();
    }

    public void agregarFicha(IFichaGrafica ficha) {
        fichasTrenGraficas.add(ficha);
    }

    public List<IFichaGrafica> getFichasTrenGraficas() {
        return fichasTrenGraficas;
    }

    public void setFichasTrenGraficas(List<IFichaGrafica> fichasTrenGraficas) {
        this.fichasTrenGraficas = fichasTrenGraficas;
    }

    @Override
    public void pintar(Graphics2D g) {

        for (IFichaGrafica iFichaGrafica : fichasTrenGraficas) {

            iFichaGrafica.pintar(g);
        }
    }
}
