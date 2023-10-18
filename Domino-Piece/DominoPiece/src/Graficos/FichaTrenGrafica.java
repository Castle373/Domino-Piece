/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import dominio_domino.FichaTablero;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author diego
 */
public class FichaTrenGrafica implements IFichaGrafica {

    private FichaTablero ficha;
    private int x;
    private int y;
    private int xOriginal;
    private int yOriginal;
    private int ancho;
    private int largo;
    private boolean seleccionada;

    public FichaTrenGrafica() {
    }

    public FichaTrenGrafica(FichaTablero ficha, int x, int y) {
        this.ficha = ficha;
        this.x = x;
        this.y = y;
        this.ancho = 23;
        this.largo = 48;
        this.xOriginal = x;
        this.yOriginal = y;
        this.seleccionada = false;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void pintar(Graphics2D g) {
        if (!ficha.isMula()) {
            if (ficha.isConectarAbajo()) {
                g.rotate(Math.toRadians(90), x + (ancho / 2), y + (largo / 2)); // Rotación de 90 grados
                g.drawImage(ficha.getImagen(), (x - (largo / 4)), (y - (ancho / 2))-2, ancho, largo, null); // Intercambia ancho y largo
                g.rotate(-Math.toRadians(90), x + (ancho / 2), y + (largo / 2)); // Restablece la rotación
            } else {
                g.rotate(Math.toRadians(270), x + (ancho / 2), y + (largo / 2)); // Rotación de 270 grados en sentido antihorario
//                 g.drawImage(ficha.getImagen(), x, (y - ((int) largo / 4)), ancho, largo, null);
                g.drawImage(ficha.getImagen(), (x +(largo / 4))-1,  (y + (ancho / 2)) +2, ancho, largo, null); // Intercambia ancho y largo
                g.rotate(-Math.toRadians(270), x + (ancho / 2), y + (largo / 2)); // Restablece la rotación
            }

        } else {

//            g.drawImage(ficha.getImagen(), x, y, ancho, largo, null);
            g.drawImage(ficha.getImagen(), x, (y - ((int) largo / 4)), ancho, largo, null);
        }
    }

    public boolean isDragging() {
        return seleccionada;
    }

    public void setDragging(boolean dragging) {
        seleccionada = dragging;
    }

    public void resetPosition() {
        x = xOriginal;
        y = yOriginal;
    }

    public int getAncho() {
        return ancho;
    }

    public FichaTablero getFicha() {
        return ficha;
    }

    public void setFicha(FichaTablero ficha) {
        this.ficha = ficha;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Shape getArea() {
        return new Rectangle2D.Double(x, y, ancho, largo);
    }
}
