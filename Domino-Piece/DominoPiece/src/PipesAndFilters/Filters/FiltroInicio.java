/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.BuscarPartidaPF;
import Evento.CrearPartidaPF;
import Evento.Evento;
import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.MovimientoPF;
import Evento.PasarTurnoPF;
import Evento.RespuestaVotacionPF;
import Evento.RobarPozoPF;
import Evento.TerminarVotacionPF;
import Evento.VerificarAvatarPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeBuscarPartida;
import PipesAndFilters.Pipes.PipeCrearJugador;
import PipesAndFilters.Pipes.PipeCrearPartida;
import PipesAndFilters.Pipes.PipeFin;
import PipesAndFilters.Pipes.PipeIniciarVotacion;
import PipesAndFilters.Pipes.PipeMovimiento;
import PipesAndFilters.Pipes.PipeRespuestaVotacion;
import PipesAndFilters.Pipes.PipeVerificarAvatar;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class FiltroInicio<T extends Evento> implements Filtro<T> {

    @Override
    public void ejecutar(T objeto) {

        if (objeto instanceof CrearPartidaPF) {
            Pipe<T> pipe = new PipeCrearPartida();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof BuscarPartidaPF) {
            Pipe<T> pipe = new PipeCrearPartida<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof JugadorPF) {
            Pipe<T> pipe = new PipeCrearJugador();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof VerificarAvatarPF) {
            Pipe<T> pipe = new PipeCrearJugador();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof IniciarVotacionPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof RespuestaVotacionPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof MovimientoPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof RobarPozoPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof PasarTurnoPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof TerminarVotacionPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }

    }

}
