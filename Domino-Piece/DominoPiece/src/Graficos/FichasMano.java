/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class FichasMano implements IFichaGrafica {

    List<IFichaGrafica> fichasMano;

    public FichasMano() {
        fichasMano = new ArrayList<>();
    }

    public List<IFichaGrafica> getFichasMano() {
        return fichasMano;
    }

    public void setFichasMano(List<IFichaGrafica> fichasMano) {
        this.fichasMano = fichasMano;
    }

    public void agregarFicha(IFichaGrafica ficha) {
        fichasMano.add(ficha);
    }

    public void removerFicha(IFichaGrafica ficha) {
        fichasMano.remove(ficha);
    }

    @Override
    public void pintar(Graphics2D g) {
        int desplazmiento = 0;
         int numero=0;
         
        for (IFichaGrafica iFichaGrafica : fichasMano) {
           
            int spacingX = 25 * numero;
            FichaManoGrafica fichaMano = (FichaManoGrafica) iFichaGrafica;
            if (!fichaMano.isDragging()) {
                fichaMano.setX(fichaMano.getxOriginal());
              
            fichaMano.setX(fichaMano.getX()+spacingX);
            }
            fichaMano.pintar(g);
            numero++;
        }
    }
}
