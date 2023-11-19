/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.MovimientoPF;
import Evento.RespuestaVotacionPF;
import Graficos.TableroGrafico;
import Pipes.Pipe;
import Pipes.PipeInicio;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;
import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.util.List;

/**
 *
 * @author diego
 */
public class ModeloJuego {

    private Partida partida;
    private PartidaDTO partida2;
    private JugadorDTO jugador;
    private Pozo pozo;

    public ModeloJuego() {

    }

    public PartidaDTO getPartida2() {
        return partida2;
    }

    public void setPartida2(PartidaDTO partida2) {
        this.partida2 = partida2;
    }

    public void guardarPartida(Partida partida) {
        this.partida = partida;
    }

    public JugadorDTO getJugador() {
        return this.jugador;
    }

    public void guardarJugador(JugadorDTO jugador) {

        this.jugador = jugador;
    }

    public Partida recuperaPartida() {
        return partida;
    }

    public List<Jugador> getListJugadores() {
        return partida.getJugadores();
    }
    public List<JugadorDTO> getListJugadoresDTO() {
        return partida2.getJugadores();
    }
    public void setListJugadores(List<Jugador> jugadores) {
         partida.setJugadores(jugadores);
    }
    public void validaMovimiento(FichaTableroDTO ficha, int lado) {
        
        Pipe<MovimientoPF> pipa = new PipeInicio();
        MovimientoPF v = new MovimientoPF(ficha, lado);
        pipa.ejecutar(v);
        
    }



    public FichaPozo robarFicha() {

        FichaPozo f = partida.getPozo().obtenerFichaAleatoria();
        if (f != null) {
            agregarFichaJugador(f);
            return f;
        } else {
            return null;
        }

    }

    public void agregarFichaJugador(FichaPozo f) {
//        FichaJugador fichaJugador = new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba());
//        jugador.addFichasJugador(fichaJugador);
    }

    public void pasarTurno() {
        partida.pasarTurno();

    }

    public Jugador obtenerJugadorTurno() {
        return partida.jugadorTurno();
    }

    public boolean validarFichas() {
        if (jugador.getFichasJugador().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isTurno() {
//        if (obtenerJugadorTurno() == getJugador()) {
//            return true;
//        }
        return false;
    }
    
    public void iniciarVotacion(){
        Pipe<IniciarVotacionPF> pipa = new PipeInicio();
        IniciarVotacionPF v = new IniciarVotacionPF();
        pipa.ejecutar(v);
    }
    
    public void respuestaVotacion(boolean respuesta){
        Pipe<RespuestaVotacionPF> pipa = new PipeInicio();
        RespuestaVotacionPF v = new RespuestaVotacionPF(respuesta);
        pipa.ejecutar(v);
    }
}
