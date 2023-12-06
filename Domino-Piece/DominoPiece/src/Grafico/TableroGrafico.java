/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafico;

import MVP.Vista.VistaJuego;

import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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

    private List<JugadorDTO> jugadores = new ArrayList<>();

    private int x, y;
    private Image fondo;
    private PartidaDTO partida;
    private JugadorDTO jugador;

    private JLabel borde1;
    private JLabel borde2;
    private JLabel borde3;
    private JLabel borde4;

    private JLabel nombre1;
    private JLabel nombre2;
    private JLabel nombre3;
    private JLabel nombre4;

    private JLabel fichaJugador1;
    private JLabel fichaJugador2;
    private JLabel fichaJugador3;
    private JLabel fichaJugador4;

    private JLabel iconFichaJugador1;
    private JLabel iconFichaJugador2;
    private JLabel iconFichaJugador3;
    private JLabel iconFichaJugador4;

    public TableroGrafico(VistaJuego vista) {

        nombre1 = new JLabel();
        nombre2 = new JLabel();
        nombre3 = new JLabel();
        nombre4 = new JLabel();
        borde1 = new JLabel();
        borde2 = new JLabel();
        borde3 = new JLabel();
        borde4 = new JLabel();
        fichaJugador1 = new JLabel();
        fichaJugador2 = new JLabel();
        fichaJugador3 = new JLabel();
        fichaJugador4 = new JLabel();
        iconFichaJugador1 = new JLabel();
        iconFichaJugador2 = new JLabel();
        iconFichaJugador3 = new JLabel();
        iconFichaJugador4 = new JLabel();

        nombre1.setForeground(Color.WHITE);
        nombre2.setForeground(Color.WHITE);
        nombre3.setForeground(Color.WHITE);
        nombre4.setForeground(Color.WHITE);
        fichaJugador1.setForeground(Color.WHITE);
        fichaJugador2.setForeground(Color.WHITE);
        fichaJugador3.setForeground(Color.WHITE);
        fichaJugador4.setForeground(Color.WHITE);

        zonaInicial = new Rectangle(630, 250, 23, 48);
        fichasJugador = new FichasMano();
        fichasTren = new FichaTren();
        fondo = new ImageIcon(getClass().getResource("/Grafico/fondo.jpg")).getImage();
        setOpaque(false); // Configura la opacidad del JPanel
        this.add(borde1);
        this.add(borde2);
        this.add(borde3);
        this.add(borde4);
        this.add(nombre1);
        this.add(nombre2);
        this.add(nombre3);
        this.add(nombre4);
        this.add(fichaJugador1);
        this.add(fichaJugador2);
        this.add(fichaJugador3);
        this.add(fichaJugador4);
        this.add(iconFichaJugador1);
        this.add(iconFichaJugador2);
        this.add(iconFichaJugador3);
        this.add(iconFichaJugador4);

//        nombre1.setBounds(130, 30,0,0);
//        botonRobar.setBounds(300, 40, 100, 30);
//        this.add(botonRobar);
    }

    public PartidaDTO getPartida() {
        return partida;
    }

    public void setPartida(PartidaDTO partida) {

        this.partida = partida;
        this.setJugadores(this.partida.getJugadores());
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;

    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
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
    public void repintarFichasJugador() {
        boolean salir = false;
        List<IFichaGrafica> fichasJugador = new ArrayList<>();
        int zona = 100;
        int x = 400;
        int y = 550;
        for (int i = 0; i < jugadores.size(); i++) {

            if (jugador != null) {
                if (jugadores.get(i).getId() == jugador.getId()) {
                    zona = i;
                }
            } else {
                salir = true;
            }
        }
        if (salir) {
            return;
        }
        boolean lado = false;
        if (zona == 0) {
            x = 35;
            y = 126;
        }
        if (zona == 1) {
            x = 1220;
            y = 126;
            lado = true;
        }
        if (zona == 2) {
            x = 35;
            y = 450;
        }
        if (zona == 3) {
            x = 1220;
            y = 450;
            lado = true;
        }
        for (FichaDTO f : jugador.getFichasJugador()) {
            IFichaGrafica fichaGrafica = new FichaManoGrafica(f, x, y, lado);
            fichasJugador.add(fichaGrafica);
        }
        this.fichasJugador.setFichasMano(fichasJugador);
        this.repaint();
    }

//    public void agregarFichasIniciales() {
//        System.out.println("SONOO");
//        for (FichaDTO ficha : jugador.getFichasJugador()) {
//            IFichaGrafica fichaGrafica = new FichaManoGrafica(ficha, 50, 475);
//            fichasJugador.agregarFicha(fichaGrafica);
//        }
//    }
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

    public void colocarInicial(FichaTableroDTO fichatablero) {
//        fichaSeleccionada.setX((int) zonaInicial.getX());
//        fichaSeleccionada.setY((int) zonaInicial.getY() + (fichaSeleccionada.getLargo() / 4));
        FichaManoGrafica fichaColocar = new FichaManoGrafica(fichatablero, 0, 0, true);
        fichaColocar.setX((int) zonaInicial.getX());
        fichaColocar.setY((int) zonaInicial.getY() + (fichaColocar.getLargo() / 4));
        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaColocar.getX(), fichaColocar.getY());
        agregarFichasTren(fichaTren);
//        quitarFichaTren(fichaSeleccionada);
        crearHitboxLados();
//        fichaSeleccionada.setDragging(false);
//        fichaSeleccionada = null;
        repaint();
    }

    public void colocarTrenDerecha(FichaTableroDTO fichatablero) {

//        fichaSeleccionada.setX((int) ladoDerecho.getX());
//        fichaSeleccionada.setY((int) ladoDerecho.getY());
//        // Crear una nueva instancia de FichaTrenGrafica
        FichaManoGrafica fichaColocar = new FichaManoGrafica(fichatablero, 0, 0, true);
        fichaColocar.setX((int) ladoDerecho.getX());
        fichaColocar.setY((int) ladoDerecho.getY());

        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaColocar.getX(), fichaColocar.getY());
        agregarFichasTren(fichaTren);
//        quitarFichaTren(fichaSeleccionada);
        fichaDerecha = fichaTren;
        if (fichaColocar.getFicha().isMula()) {
            ladoDerecho.setLocation((int) ladoDerecho.getX() + (int) ladoDerecho.getHeight(), (int) ladoDerecho.getY());
        } else {
            ladoDerecho.setLocation((int) ladoDerecho.getX() + (int) ladoDerecho.getWidth(), (int) ladoDerecho.getY());
        }
//        fichaSeleccionada.setDragging(false);
//        fichaSeleccionada = null;
        repaint();
    }

    public void colocarTrenIzquierda(FichaTableroDTO fichatablero) {

//        fichaSeleccionada.setX((int) ladoIzquierdo.getX());
//        fichaSeleccionada.setY((int) ladoIzquierdo.getY());
        FichaManoGrafica fichaColocar = new FichaManoGrafica(fichatablero, 0, 0, true);
        fichaColocar.setX((int) ladoIzquierdo.getX());
        fichaColocar.setY((int) ladoIzquierdo.getY());
        if (fichaColocar.getFicha().isMula()) {
            fichaColocar.setX(fichaColocar.getX() + fichaColocar.getAncho());
            ladoIzquierdo.setLocation((int) ladoIzquierdo.getX() - (int) ladoIzquierdo.getHeight(), (int) ladoIzquierdo.getY());
        } else {
            ladoIzquierdo.setLocation((int) ladoIzquierdo.getX() - (int) ladoIzquierdo.getWidth(), (int) ladoIzquierdo.getY());
        }
        FichaTrenGrafica fichaTren = new FichaTrenGrafica(fichatablero, fichaColocar.getX(), fichaColocar.getY());
        agregarFichasTren(fichaTren);
//        quitarFichaTren(fichaSeleccionada);
        fichaIzquierda = fichaTren;
//        fichaSeleccionada.setDragging(false);
//        fichaSeleccionada = null;
        repaint();
    }

    public FichaDTO obtenerFichaSeleccionada() {
        FichaDTO ficha = fichaSeleccionada.getFicha();
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
        if (fichaSeleccionada == null) {
            this.repaint();
            return;
        }
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
        pintarJugadores(g2);
    }

    public void pintarPantalla(Graphics2D g) {
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void reinciarJugadores() {
        borde1.setIcon(null);
        borde2.setIcon(null);
        borde3.setIcon(null);
        borde4.setIcon(null);
        nombre1.setText("");
        nombre2.setText("");
        nombre3.setText("");
        nombre4.setText("");
        fichaJugador1.setText("");
        fichaJugador2.setText("");
        fichaJugador3.setText("");
        fichaJugador4.setText("");
        iconFichaJugador1.setIcon(null);
        iconFichaJugador2.setIcon(null);
        iconFichaJugador3.setIcon(null);
        iconFichaJugador4.setIcon(null);
    }

    public void pintarJugadores(Graphics2D g) {
//        borde1 = new JLabel();
//        borde2 = new JLabel();
//        borde3 = new JLabel();
//        borde4 = new JLabel();
//        nombre1 = new JLabel();
//        nombre2 = new JLabel();
//        nombre3 = new JLabel();
//        nombre4 = new JLabel();
        reinciarJugadores();
        for (int i = 0; i < jugadores.size(); i++) {

            ImageIcon marcoNormal = new ImageIcon(getClass().getResource("/Grafico/marcoNormal.png"));
            ImageIcon marcoTurno = new ImageIcon(getClass().getResource("/Grafico/marco.gif"));

            if (i == 0) {
                nombre1.setText(jugadores.get(i).getNombre());
                nombre1.setBounds(130, 30, 100, 30);
                iconFichaJugador1.setBounds(130, 60, 40, 40);
                iconFichaJugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico/fichaNum.png")));
                fichaJugador1.setText("X " + String.valueOf(jugadores.get(i).getFichasJugador().size()));
                fichaJugador1.setBounds(165, 70, 100, 20);
                fichaJugador1.setVisible(true);
                if (jugadores.get(i) == partida.getJugadores().get(partida.getTurno())) {

                    borde1.setBounds(30, 26, 100, 75);
                    borde1.setIcon(marcoTurno);
                } else {
                    borde1.setBounds(30, 26, 100, 75);
                    borde1.setIcon(marcoNormal);
                }
                Image iconoOriginal = new ImageIcon(getClass().getResource(jugadores.get(i).getAvatar())).getImage();
                g.drawImage(iconoOriginal, 38, 34, 90, 75, null);
            }
            if (i == 1) {
                nombre2.setText(jugadores.get(i).getNombre());
                int xNmobre = jugadores.get(i).getNombre().length() * 7;
                nombre2.setBounds((1149 - xNmobre), 30, 100, 30);
                iconFichaJugador2.setBounds(1111, 60, 40, 40);
                iconFichaJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico/fichaNum.png")));
                fichaJugador2.setText("X " + String.valueOf(jugadores.get(i).getFichasJugador().size()));
                fichaJugador2.setBounds(1087, 69, 100, 30);
                fichaJugador2.setVisible(true);

                if (jugadores.get(i) == partida.getJugadores().get(partida.getTurno())) {
                    borde2.setBounds(1150, 26, 100, 75);
                    borde2.setIcon(marcoTurno);
                } else {
                    borde2.setBounds(1150, 26, 100, 75);
                    borde2.setIcon(marcoNormal);

                }
                Image iconoOriginal = new ImageIcon(getClass().getResource(jugadores.get(i).getAvatar())).getImage();
                g.drawImage(iconoOriginal, 1158, 34, 90, 75, null);
            }
            if (i == 2) {
                nombre3.setText(jugadores.get(i).getNombre());
                nombre3.setBounds(130, 535, 100, 30);
                iconFichaJugador3.setBounds(130, 565, 40, 40);
                iconFichaJugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico/fichaNum.png")));
                fichaJugador3.setBounds(165, 575, 100, 30);
                fichaJugador3.setText("X " + String.valueOf(jugadores.get(i).getFichasJugador().size()));
                fichaJugador3.setVisible(true);

                if (jugadores.get(i) == partida.getJugadores().get(partida.getTurno())) {

                    borde3.setBounds(30, 535, 100, 75);
                    borde3.setIcon(marcoTurno);
                } else {
                    borde3.setBounds(30, 535, 100, 75);
                    borde3.setIcon(marcoNormal);
                }
                Image iconoOriginal = new ImageIcon(getClass().getResource(jugadores.get(i).getAvatar())).getImage();
                g.drawImage(iconoOriginal, 38, 543, 90, 75, null);
            }
            if (i == 3) {
                nombre4.setText(jugadores.get(i).getNombre());
                int xNmobre = jugadores.get(i).getNombre().length() * 7;
                nombre4.setBounds((1149 - xNmobre), 535, 100, 30);
                iconFichaJugador4.setBounds(1111, 565, 40, 40);
                iconFichaJugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico/fichaNum.png")));
                fichaJugador4.setBounds(1087, 575, 100, 30);
                fichaJugador4.setText("X " + String.valueOf(jugadores.get(i).getFichasJugador().size()));
                fichaJugador4.setVisible(true);

                if (jugadores.get(i) == partida.getJugadores().get(partida.getTurno())) {
                    borde4.setBounds(1150, 535, 100, 75);
                    borde4.setIcon(marcoTurno);

                } else {
                    borde4.setBounds(1150, 535, 100, 75);
                    borde4.setIcon(marcoNormal);
                }
                Image iconoOriginal = new ImageIcon(getClass().getResource(jugadores.get(i).getAvatar())).getImage();
                g.drawImage(iconoOriginal, 1158, 543, 90, 75, null);
            }
        }

    }

    public void mostrarBorder() {

    }

    public void pintarFichasJugador(Graphics2D g) {
        List<IFichaGrafica> listFicha = fichasJugador.getFichasMano();
        Iterator<IFichaGrafica> iterator = listFicha.iterator();

        while (iterator.hasNext()) {
            IFichaGrafica ficha = iterator.next();
            if (ficha instanceof FichaManoGrafica) {
                if (!jugador.getFichasJugador().contains(((FichaManoGrafica) ficha).getFicha())) {
                    iterator.remove();
                }
            }
        }

        if (fichasJugador != null) {
            fichasJugador.pintar(g);
        }
//        List<IFichaGrafica> listFicha = fichasJugador.getFichasMano();
//        for (IFichaGrafica ficha : listFicha) {
//            if (ficha instanceof FichaManoGrafica) {
//                if (!jugador.getFichasJugador().contains(((FichaManoGrafica) ficha).getFicha())) {
//                    fichasJugador.removerFicha(ficha);
//                }
//            }
//        }
//        if (fichasJugador != null) {
//            fichasJugador.pintar(g);
//        }

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
