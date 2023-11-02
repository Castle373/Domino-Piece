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
import dominio_dominodto.JugadorDTO;
import java.awt.Image;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public class PresentadorUnirse implements IPresentadorUnirse {

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
    }

    @Override
    public void crearJugador(String nombre, String avatar) {
        Cliente cliente=Cliente.getInstance();
        cliente.agregarObserver((Observer) presentadorJuego);
        modelo.crearJugador(nombre, avatar);

//        if (modelo.recuperaPartida() == null) {
//            vista.muestraMensajeError();
//        } else {
        mostrarPantallaJuego();
//        }
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

}
