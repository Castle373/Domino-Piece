/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Modelo;

import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.MovimientoPF;
import Evento.PasarTurnoPF;
import Evento.RespuestaVotacionPF;
import Evento.RobarPozoPF;
import Evento.TerminarVotacionPF;
import Grafico.TableroGrafico;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeInicio;

import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.util.List;

/**
 *
 * @author diego
 */
public class ModeloJuego {

    private PartidaDTO partida2;
    private JugadorDTO jugador;

    public ModeloJuego() {

    }

    public PartidaDTO getPartida2() {
        return partida2;
    }

    public void setPartida2(PartidaDTO partida2) {
        this.partida2 = partida2;
    }


    public JugadorDTO getJugador() {
        return this.jugador;
    }

    public void guardarJugador(JugadorDTO jugador) {

        this.jugador = jugador;
    }



    public List<JugadorDTO> getListJugadoresDTO() {
        return partida2.getJugadores();
    }



    public void validaMovimiento(FichaTableroDTO ficha, int lado) {

        Pipe<MovimientoPF> pipa = new PipeInicio();
        MovimientoPF v = new MovimientoPF(ficha, lado);
        pipa.ejecutar(v);

    }

    public void robarFicha() {
        Pipe<RobarPozoPF> pipa = new PipeInicio();
        RobarPozoPF v = new RobarPozoPF(jugador);
        pipa.ejecutar(v);

    }



    public void pasarTurno() { 
        Pipe<PasarTurnoPF> pipa = new PipeInicio();
        PasarTurnoPF p = new PasarTurnoPF(jugador);
        pipa.ejecutar(p);
    }


    public boolean validarFichas() {
        if (jugador.getFichasJugador().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isTurno() {
        if (partida2.getJugadores().get(partida2.getTurno()).getId().equals(getJugador().getId())) {
            return true;
        }
        return false;
    }

    public void iniciarVotacion() {
        Pipe<IniciarVotacionPF> pipa = new PipeInicio();
        IniciarVotacionPF v = new IniciarVotacionPF();
        pipa.ejecutar(v);
    }
    public void iniciarVotacionTerminar() {
        System.out.println("Entro");
        Pipe<TerminarVotacionPF> pipa = new PipeInicio();
        TerminarVotacionPF v = new TerminarVotacionPF();
        pipa.ejecutar(v);
    }
    public void respuestaVotacion(boolean respuesta) {
        Pipe<RespuestaVotacionPF> pipa = new PipeInicio();
        RespuestaVotacionPF v = new RespuestaVotacionPF(respuesta);
        pipa.ejecutar(v);
    }

}
