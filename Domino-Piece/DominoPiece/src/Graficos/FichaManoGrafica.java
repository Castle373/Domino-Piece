/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import dominio_domino.Ficha;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public class FichaManoGrafica implements IFichaGrafica {

    private Ficha ficha;
    private int x;
    private int y;
    private int xOriginal;
    private int yOriginal;
    private int ancho;
    private int largo;
    private boolean seleccionada;
    private Image imagen;

    public FichaManoGrafica(Ficha ficha, int x, int y) {
        this.ficha = ficha;
        this.x = x;
        this.y = y;
        this.ancho = 23;
        this.largo = 48;
        this.xOriginal = x;
        this.yOriginal = y;
        this.seleccionada = false;
        this.imagen = new ImageIcon(getClass().getResource(ficha.getImagen())).getImage();

    }

    public int getxOriginal() {
        return xOriginal;
    }

    public void setxOriginal(int xOriginal) {
        this.xOriginal = xOriginal;
    }

    public int getyOriginal() {
        return yOriginal;
    }

    public void setyOriginal(int yOriginal) {
        this.yOriginal = yOriginal;
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

        g.drawImage(imagen, x, y, null);

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

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
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
