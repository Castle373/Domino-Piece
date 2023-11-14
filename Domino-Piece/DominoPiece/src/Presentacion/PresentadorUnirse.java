/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloUnirse;
import Observer.Observer;
import Socketss.Cliente;
import Vista.VistaUnirse;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.Acciones;
import dominio_dominodto.JugadorDTO;
import java.awt.Image;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public class PresentadorUnirse implements IPresentadorUnirse, Observer {

    private ModeloUnirse modelo;
    private IPresentacionJuego presentadorJuego;
    private VistaUnirse vista;

    public PresentadorUnirse() {
        vista = new VistaUnirse(this);
        modelo = new ModeloUnirse();
        presentadorJuego = new PresentadorJuego();
    }

    @Override
    public void mostrarPantallaUnirse() {
        vista.setVisible(true);
        Cliente cliente = Cliente.getInstance();
        cliente.agregarObserver((Observer) presentadorJuego);
        cliente.agregarObserver(this);
    }

    @Override
    public void crearJugador() {
        modelo.crearJugador();
        
        mostrarPantallaJuego();
    }

    @Override
    public void mostrarPantallaJuego() {
//        enviarPartida();
//        enviarJugador();

        presentadorJuego.mostrarPantallaJuego();
        vista.dispose();
    }

    @Override
    public void guardarPartida(Partida partida) {
        modelo.guardarPartida(partida);
    }

    @Override
    public void enviarPartida() {
        presentadorJuego.guardarPartida(obtenerPartida());
    }

    @Override
    public Partida obtenerPartida() {
        return modelo.recuperaPartida();
    }

    @Override
    public void enviarJugador() {
        presentadorJuego.guardarJugador(obtenerJugador());
    }

    @Override
    public JugadorDTO obtenerJugador() {
        return modelo.getJugador();
    }

    @Override
    public void verificarAvatar(String avatar) {
        modelo.verificarAvatar(avatar);
    }

    @Override
    public void update(Object loquesea) {
        if (loquesea instanceof Acciones) {
            Acciones a = (Acciones) loquesea;

            if (a == Acciones.AVATAR_SIESTA) {
                vista.muestraMensajeAvatarEnUso();
            }

            if (a == Acciones.AVATAR_NOESTA) {
                this.crearJugador();
            }
        }
    }

    @Override
    public void guardarJugadorTemporal(String nombre, String avatar) {
        modelo.setNombre(nombre);
        modelo.setAvatar(avatar);
    }

}
