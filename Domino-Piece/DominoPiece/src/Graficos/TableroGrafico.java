/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import dominio_domino.Ficha;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
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
    private Partida partida;
    private Jugador jugador;

    public TableroGrafico() {
        zonaInicial = new Rectangle(630, 250, 23, 48);
        fichasJugador = new FichasMano();
        fichasTren = new FichaTren();
        fondo = new ImageIcon(getClass().getResource("/img/fondo.jpg")).getImage();
        setOpaque(false); // Configura la opacidad del JPanel
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
        System.out.println(this.jugador.getNombre());
    }

    public FichasMano getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(FichasMano fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

//    public void agregarFichaJugador(FichaJugador ficha) {
//        jugador.addFichasJugador(ficha);
//        IFichaGrafica fichaGrafica = new FichaManoGrafica(ficha, 50, 475);
//        fichasJugador.agregarFicha(fichaGrafica);
//        this.repaint();
//    }
    public void repintarFichasJugador(){
        List<IFichaGrafica> fichasJugador= new ArrayList<>();
        for (FichaJugador f:jugador.getFichasJugador()) {
             IFichaGrafica fichaGrafica = new FichaManoGrafica(f, 50, 475);
             fichasJugador.add(fichaGrafica);
        }
        this.fichasJugador.setFichasMano(fichasJugador);
        this.repaint();
    }
    public void agregarFichasIniciales() {
        for (FichaJugador ficha : jugador.getFichasJugador()) {
            IFichaGrafica fichaGrafica = new FichaManoGrafica(ficha, 50, 475);
            fichasJugador.agregarFicha(fichaGrafica);
        }

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

    public void agregarFichasTren(IFichaGrafica ficha) {
        fichasTren.agregarFicha(ficha);
    }

    public void quitarFichaTren(FichaManoGrafica fichaMano) {
        fichasJugador.removerFicha(fichaMano);

    }

    public FichaTren getFichasTren() {
        return fichasTren;
    }

    public void setFichasTren(FichaTren fichasJugador) {
        this.fichasTren = fichasJugador;
    }

    public void colocarInicial(FichaTablero fichatablero) {

        fichaSeleccionada.setX((int) zonaInicial.getX());
        fichaSeleccionada.setY((int) zonaInicial.getY() + (fichaSeleccionada.getLargo() / 4));

        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaSeleccionada.getX(), fichaSeleccionada.getY());

        agregarFichasTren(fichaTren);
        quitarFichaTren(fichaSeleccionada);
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
        agregarFichasTren(fichaTren);
        quitarFichaTren(fichaSeleccionada);
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

        agregarFichasTren(fichaTren);
        quitarFichaTren(fichaSeleccionada);

        fichaIzquierda = fichaTren;
        fichaSeleccionada.setDragging(false);
        fichaSeleccionada = null;
        repaint();
    }

    public FichaJugador obtenerFichaSeleccionada() {
        FichaJugador ficha = (FichaJugador) fichaSeleccionada.getFicha();
        return ficha;
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

        for (IFichaGrafica ficha : fichasJugador.getFichasMano()) {
            if (ficha instanceof FichaManoGrafica) {
                if (!jugador.getFichasJugador().contains(((FichaManoGrafica) ficha).getFicha())) {
                    fichasJugador.removerFicha(ficha);
                }
            }
        }

//        List<IFichaGrafica> fichaManoGrafica= new ArrayList<>();
//        System.out.println(jugador.getNombre());
//        for (FichaJugador f : jugador.getFichasJugador()) {
//            IFichaGrafica fichaGrafica = new FichaManoGrafica(f, 50, 475);
//            fichaManoGrafica.add(fichaGrafica);
//        }
//        System.out.println(jugador.toString());
//        fichasJugador.setFichasMano(fichaManoGrafica);
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
