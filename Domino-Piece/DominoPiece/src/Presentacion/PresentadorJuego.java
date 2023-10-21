/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloJuego;
import Vista.VistaJuego;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import java.util.List;

/**
 *
 * @author diego
 */
public class PresentadorJuego implements IPresentacionJuego {

    private ModeloJuego modelo;

    private VistaJuego vista;

    public PresentadorJuego() {
        vista = new VistaJuego(this);
        modelo = new ModeloJuego();
    }

    @Override
    public void mostrarPantallaJuego() {
        vista.setVisible(true);
       vista.mostrarJugadores();
    }

    @Override
    public boolean realizaMovimiento(FichaTablero ficha, int lado) {
        return modelo.validaMovimiento(ficha, lado);
    }

    @Override
    public void guardarPartida(Partida partida) {
        modelo.guardarPartida(partida);
    }

    @Override
    public void iniciarPartida() {
        crearPozo();
        reparteFichas();
        while (!verificaFichas()) {
            reparteFichasExtras();
        }
        crearTablero();
    }

    @Override
    public void crearPozo() {
        modelo.crearPozo();
    }

    @Override
    public void reparteFichas() {
        modelo.reparteFichas();
    }

    @Override
    public void reparteFichasExtras() {
        modelo.reparteFichasExtras();
    }

    @Override
    public boolean verificaFichas() {
        return modelo.verificaFichas();
    }

    @Override
    public void crearTablero() {
        modelo.crearTablero();
    }

    @Override
    public void robarFicha() {
        FichaPozo f = modelo.robarFicha();
        
        if (f != null) {
            vista.pintarFichas();
        } else {
            vista.mostrarMensajeError("No hay Fichas en el pozo");
        }

    }

    @Override
    public void guardarJugador(Jugador jugador) {
        modelo.guardarJugador(jugador);
        vista.asignarJugadorJugando(jugador);
    }

    @Override
    public void eliminarFichaJugador(FichaJugador ficha) {
       modelo.eliminarFicha(ficha);
    }

    @Override
    public void pasarTurno() {
       modelo.pasarTurno();
    }

    @Override
    public Jugador jugadorTurno() {
        return modelo.obtenerJugadorTurno();
    }

    @Override
    public boolean isTurno() {
       return modelo.isTurno();
    }

    @Override
    public List<Jugador> listaJugadores() {
       return modelo.getListJugadores();
    }
    
}
