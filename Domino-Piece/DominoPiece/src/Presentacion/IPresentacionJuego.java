/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion;

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
public interface IPresentacionJuego {
    public void mostrarPantallaJuego();
    public boolean realizaMovimiento(FichaTablero ficha,int lado);
    public void guardarPartida(Partida partida);
    public void guardarJugador(Jugador jugador);
    public void iniciarPartida();
    public List<Jugador> listaJugadores();
    public void setListaJugadores(List<Jugador> jugadores);
    public void crearPozo();
    public void reparteFichas();
    public void crearTablero();
    public void robarFicha();
  
    public void eliminarFichaJugador(FichaJugador ficha);
    public void pasarTurno();
    public Jugador jugadorTurno();
    public boolean isTurno();
}
