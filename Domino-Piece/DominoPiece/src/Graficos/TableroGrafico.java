/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import dominio_domino.Ficha;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class TableroGrafico extends JPanel {

    private FichaTren fichasTren;
    private FichasMano fichasJugador;
    private FichaManoGrafica fichaSeleccionada; //Ficha Arrastrada
    private FichaTrenGrafica fichaIzquierda;//Puntero Izquierdo
    private FichaTrenGrafica fichaDerecha;//Puntero Derecho
    private Rectangle zonaInicial = new Rectangle();//Hitbox Inicial
    private Rectangle ladoDerecho = new Rectangle();//Hitbox Lado Derecho
    private Rectangle ladoIzquierdo = new Rectangle();//Hitbox Lado Izquierdo
    private int x, y;
    private Image fondo;

    public TableroGrafico() {
        zonaInicial = new Rectangle(630, 250, 23, 48);
        fichasJugador = new FichasMano();
        fichasTren = new FichaTren();
        fondo = new ImageIcon(getClass().getResource("/img/fondo.jpg")).getImage();
        setOpaque(false); // Configura la opacidad del JPanel

    }

    public FichasMano getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(FichasMano fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

    public void agregarFichaJugador(FichaPozo fichaPozo) {
        IFichaGrafica fichaGrafica = new FichaManoGrafica(fichaPozo, 50, 475);
        fichasJugador.agregarFicha(fichaGrafica);
        this.repaint();
    }

    public FichaTren getFichasTren() {
        return fichasTren;
    }

    public void setFichasTren(FichaTren fichasJugador) {
        this.fichasTren = fichasJugador;
    }

    public void agregarFichasTren(IFichaGrafica ficha) {
        fichasTren.agregarFicha(ficha);
    }

    public void moverFicha(MouseEvent e) {
        for (IFichaGrafica ficha : fichasJugador.getFichasMano()) {
            if (ficha instanceof FichaManoGrafica) {
                FichaManoGrafica fichaMano = (FichaManoGrafica) ficha;
                Point puntoMouse = new Point(e.getX(), e.getX());
                if (fichaMano.getArea().contains(e.getPoint())) {
                    fichaSeleccionada = fichaMano;
                    x = e.getX() - fichaMano.getX();
                    y = e.getY() - fichaMano.getY();
                    fichaMano.setDragging(true);
                    break;
                }
            }
        }
    }

    public void agregarFicha(FichaTrenGrafica fichaTren) {

        fichasTren.agregarFicha(fichaTren);
    }

    public void quitarFicha(FichaManoGrafica fichaMano) {
        fichasJugador.removerFicha(fichaMano);

    }

    public void colocarInicial(FichaTablero fichatablero) {

        fichaSeleccionada.setX((int) zonaInicial.getX());
        fichaSeleccionada.setY((int) zonaInicial.getY() + (fichaSeleccionada.getLargo() / 4));

        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaSeleccionada.getX(), fichaSeleccionada.getY());

        agregarFicha(fichaTren);
        quitarFicha(fichaSeleccionada);
        crearHitboxLados();
        fichaSeleccionada.setDragging(false);
        fichaSeleccionada = null;
        repaint();
    }

    public void colocarTrenDerecha(FichaTablero fichatablero) {

        fichaSeleccionada.setX((int) ladoDerecho.getX());
        fichaSeleccionada.setY((int) ladoDerecho.getY());
        // Crear una nueva instancia de FichaTrenGrafica
        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaSeleccionada.getX(), fichaSeleccionada.getY());
        agregarFicha(fichaTren);
        quitarFicha(fichaSeleccionada);
        fichaDerecha = fichaTren;
        if (fichaSeleccionada.getFicha().isMula()) {
            ladoDerecho.setLocation((int) ladoDerecho.getX() + (int) ladoDerecho.getHeight(), (int) ladoDerecho.getY());
        } else {
            ladoDerecho.setLocation((int) ladoDerecho.getX() + (int) ladoDerecho.getWidth(), (int) ladoDerecho.getY());
        }
        fichaSeleccionada.setDragging(false);
        fichaSeleccionada = null;
        repaint();
    }

    public void colocarTrenIzquierda(FichaTablero fichatablero) {

        fichaSeleccionada.setX((int) ladoIzquierdo.getX());
        fichaSeleccionada.setY((int) ladoIzquierdo.getY());

        if (fichaSeleccionada.getFicha().isMula()) {
            fichaSeleccionada.setX(fichaSeleccionada.getX() + fichaSeleccionada.getAncho());
            ladoIzquierdo.setLocation((int) ladoIzquierdo.getX() - (int) ladoIzquierdo.getHeight(), (int) ladoIzquierdo.getY());
        } else {
            ladoIzquierdo.setLocation((int) ladoIzquierdo.getX() - (int) ladoIzquierdo.getWidth(), (int) ladoIzquierdo.getY());
        }

        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaSeleccionada.getX(), fichaSeleccionada.getY());

        agregarFicha(fichaTren);
        quitarFicha(fichaSeleccionada);

        fichaIzquierda = fichaTren;
        fichaSeleccionada.setDragging(false);
        fichaSeleccionada = null;
        repaint();
    }

    public FichaTablero obtenerFichaTablero() {
        Ficha ficha = fichaSeleccionada.getFicha();
        FichaTablero f = new FichaTablero(ficha.getImagen(), ficha.getPuntoAbajo(), ficha.getPuntoArriba());
        return f;
    }

    public void crearHitboxLados() {
        int xLadoDerecho = (int) zonaInicial.getX() + (int) zonaInicial.getWidth();
        int yLadoDerecho = (int) zonaInicial.getY() + ((int) zonaInicial.getHeight() / 4);
        int xLadoIzquierdo = (int) zonaInicial.getX() - (int) zonaInicial.getHeight();
        int yLadoIzquierdo = (int) zonaInicial.getY() + ((int) zonaInicial.getHeight() / 4);
        ladoDerecho = new Rectangle(xLadoDerecho, yLadoDerecho, (int) zonaInicial.getHeight(), (int) zonaInicial.getWidth());
        ladoIzquierdo = new Rectangle(xLadoIzquierdo, yLadoIzquierdo, (int) zonaInicial.getHeight(), (int) zonaInicial.getWidth());
        zonaInicial = new Rectangle();
    }

    public int validaHitbox(MouseEvent e) {
        if (fichaSeleccionada != null && fichaSeleccionada instanceof FichaManoGrafica) {
            FichaManoGrafica fichaMano = (FichaManoGrafica) fichaSeleccionada;
            if (zonaInicial.contains(e.getPoint())) {
//              moverMulaAZonaInicial(fichaMano);
                return 1;
            } else if (ladoDerecho.contains(e.getPoint())) {
//              conectarFichaDerecha(fichaMano);
                return 2;
            } else if (ladoIzquierdo.contains(e.getPoint())) {
//              conectarFichaIzquierda(fichaMano);
                return 3;
            } else {
                resetearFichaSeleccionada();
                return 0;
            }
        }
       
        return 0;
    }

    public void resetearFichaSeleccionada() {
    
        fichaSeleccionada.resetPosition();
        fichaSeleccionada.setDragging(false);
        fichaSeleccionada = null;
        this.repaint();
        // Restablece las propiedades de las zonas y posiciones relacionadas
    }
//
//    public void validaMovimiento(MouseEvent e) {
//        if (fichaSeleccionada != null) {
//            if (fichaSeleccionada instanceof FichaManoGrafica) {
//                FichaManoGrafica fichaMano = (FichaManoGrafica) fichaSeleccionada;
//                if (zonaInicial.contains(e.getPoint())) {
//
//                } else if (ladoDerecho.contains(e.getPoint())) {
//                    Ficha ficha = fichaMano.getFicha();
//                    FichaTablero fichatablero = new FichaTablero(ficha.getImagen(), ficha.getPuntoAbajo(), ficha.getPuntoArriba());
//
//                    boolean conectar = false;
//                    if (fichaDerecha == null) {
//                        FichaTrenGrafica fichaUnion = (FichaTrenGrafica) fichasTren.getFichasTrenGraficas().get(0);
//                        int punto = fichaUnion.getFicha().getPuntoAbajo();
//
//                        if (punto == fichatablero.getPuntoAbajo()) {
//                            fichatablero.setConectarAbajo(true);
//                            conectar = true;
//                        }
//                        if (punto == fichatablero.getPuntoArriba()) {
//                            fichatablero.setConectarArriba(true);
//                            conectar = true;
//                        }
//                        fichaMano.setFicha(fichatablero);
//
//                    }
//                    if (fichaDerecha != null) {
//                        FichaTrenGrafica fichaUnion = fichaDerecha;
//                        int punto;
//                        if (fichaUnion.getFicha().isConectarArriba()) {
//                            punto = fichaUnion.getFicha().getPuntoAbajo();
//                        } else {
//                            punto = fichaUnion.getFicha().getPuntoArriba();
//                        }
//
//                        if (punto == fichatablero.getPuntoAbajo()) {
//                            fichatablero.setConectarAbajo(true);
//                            conectar = true;
//                        }
//                        if (punto == fichatablero.getPuntoArriba()) {
//                            fichatablero.setConectarArriba(true);
//                            conectar = true;
//                        }
//                        fichaMano.setFicha(fichatablero);
//                    }
//
//                } else if (ladoIzquierdo.contains(e.getPoint())) {
//                    Ficha ficha = fichaMano.getFicha();
//                    FichaTablero fichatablero = new FichaTablero(ficha.getImagen(), ficha.getPuntoAbajo(), ficha.getPuntoArriba());
//
//                    boolean conectar = false;
//                    if (fichaIzquierda == null) {
//                        FichaTrenGrafica fichaUnion = (FichaTrenGrafica) fichasTren.getFichasTrenGraficas().get(0);
//                        int punto = fichaUnion.getFicha().getPuntoAbajo();
//
//                        if (punto == fichatablero.getPuntoAbajo()) {
//                            fichatablero.setConectarArriba(true);
//                            conectar = true;
//                        }
//                        if (punto == fichatablero.getPuntoArriba()) {
//                            fichatablero.setConectarAbajo(true);
//                            conectar = true;
//                        }
//                        fichaMano.setFicha(fichatablero);
//
//                    }
//                    if (fichaIzquierda != null) {
//                        FichaTrenGrafica fichaUnion = fichaIzquierda;
//                        int punto;
//                        if (fichaUnion.getFicha().isConectarArriba()) {
//                            punto = fichaUnion.getFicha().getPuntoArriba();
//                        } else {
//                            punto = fichaUnion.getFicha().getPuntoAbajo();
//                        }
//                        if (punto == fichatablero.getPuntoAbajo()) {
//                            fichatablero.setConectarArriba(true);
//                            conectar = true;
//                        }
//                        if (punto == fichatablero.getPuntoArriba()) {
//                            fichatablero.setConectarAbajo(true);
//                            conectar = true;
//                        }
//                        fichaMano.setFicha(fichatablero);
//                    }
//
//                } else {
//                    fichaSeleccionada.resetPosition();
//
//                }
//            }
//            fichaSeleccionada.setDragging(false);
//            fichaSeleccionada = null;
//            repaint();
//
//        }
//    }

    public void arrastrarFicha(MouseEvent e) {
        if (fichaSeleccionada != null) {
            fichaSeleccionada.setX(e.getX() - x);
            fichaSeleccionada.setY(e.getY() - y);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el área de dibujo

        Graphics2D g2 = (Graphics2D) g;
        pintarPantalla(g2);
        pintarFichasJugador(g2);
        dibujarRectanguloSiVacio(g2);
        pintarFichasTren(g2);
    }

    public void pintarPantalla(Graphics2D g) {
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void pintarFichasJugador(Graphics2D g) {
        fichasJugador.pintar(g);

    }

    public void pintarFichasTren(Graphics2D g) {
        fichasTren.pintar(g);

    }

    public void dibujarRectanguloSiVacio(Graphics2D g) {

        g.setColor(Color.WHITE);
        g.draw(zonaInicial);
        g.draw(ladoDerecho);
        g.draw(ladoIzquierdo);

    }
}
