/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Graficos.TableroGrafico;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;
import java.util.List;

/**
 *
 * @author diego
 */
public class ModeloJuego {

    private Partida partida;
    private Jugador jugador;
    private Pozo pozo;

    public ModeloJuego() {

    }

    public void guardarPartida(Partida partida) {
        this.partida = partida;
    }
    public Jugador getJugador(){
        return this.jugador;
    }
    public void guardarJugador(Jugador jugador) {

        this.jugador = jugador;
    }

    public Partida recuperaPartida() {
        return partida;
    }

    public boolean validaMovimiento(FichaTablero ficha, int lado) {
        Tablero tablero = partida.getTablero();
        switch (lado) {
            case 1:
                return tablero.validaZonaInical(ficha);
            case 2:
                return tablero.validaLadoDerecho(ficha);
            case 3:
                return tablero.validaLadoIzquierdo(ficha);

        }
        return false;
    }

    public void crearPozo() {
        pozo = new Pozo();
        partida.setPozo(pozo);
    }

    public void reparteFichas() {
        for (int i = 0; i < partida.getNumeroFichas(); i++) {
            for (Jugador jugador : partida.getJugadores()) {
                FichaPozo f = partida.getPozo().obtenerFichaAleatoria();
                jugador.addFichasJugador(new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba()));
            }
        }
    }

    public void reparteFichasExtras() {
        for (int i = 0; i < 1; i++) {
            for (Jugador jugador : partida.getJugadores()) {
                FichaPozo f = partida.getPozo().obtenerFichaAleatoria();
                jugador.addFichasJugador(new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba()));
            }
        }
    }

    public boolean verificaFichas() {
        for (Jugador jugador : partida.getJugadores()) {
            for (FichaJugador f : jugador.getFichasJugador()) {
                if (f.isMula()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void crearTablero() {
        Tablero t = new Tablero();
        partida.setTablero(t);
    }

    public FichaPozo robarFicha() {
        
        FichaPozo f= partida.getPozo().obtenerFichaAleatoria();
        if (f!=null) {
            agregarFichaJugador(f);
            return f;
        }else{
            return null;
        }
        
    }
    
    public void agregarFichaJugador(FichaPozo f){
        FichaJugador fichaJugador = new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba());
        jugador.addFichasJugador(fichaJugador);
    }
    public Jugador eliminarFicha(FichaJugador ficha) {

        jugador.removerFichaJugador(ficha);
        if (validarFichas()) {
            //true todavia tiene
            pasarTurno();

            return obtenerJugadorTurno();
        } else {
            return null;
            //terminar partida
        }

    }

    public void pasarTurno() {
         partida.pasarTurno();
        
    }
    public Jugador obtenerJugadorTurno(){
        return partida.jugadorTurno();
    }
    public boolean validarFichas() {
        if (jugador.getFichasJugador().isEmpty()) {
            return false;
        }
        return true;
    }
    public boolean isTurno(){
        if (obtenerJugadorTurno()==getJugador()) {
          return  true;
        }
        return false;
    }
}
