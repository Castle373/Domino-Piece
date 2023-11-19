/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.CrearPartidaPF;
import Evento.Evento;
import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.MovimientoPF;
import Evento.RespuestaVotacionPF;
import Evento.VerificarAvatarPF;
import Pipes.Pipe;
import Pipes.PipeCrearJugador;
import Pipes.PipeCrearPartida;
import Pipes.PipeFin;
import Pipes.PipeIniciarVotacion;
import Pipes.PipeMovimiento;
import Pipes.PipeRespuestaVotacion;
import Pipes.PipeVerificarAvatar;
import dominio_domino.Partida;
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

        if (objeto instanceof JugadorPF) {
            Pipe<T> pipe = new PipeCrearJugador();
            pipe.ejecutar(objeto);
        }
        
        if (objeto instanceof IniciarVotacionPF) {
            Pipe<T> pipe = new PipeIniciarVotacion();
            pipe.ejecutar(objeto);
        }
        
        if (objeto instanceof RespuestaVotacionPF) {
            Pipe<T> pipe = new PipeRespuestaVotacion();
            pipe.ejecutar(objeto);
        }
        
        if (objeto instanceof VerificarAvatarPF) {
            Pipe<T> pipe = new PipeVerificarAvatar();
            pipe.ejecutar(objeto);
        }
        if (objeto instanceof MovimientoPF) {
            Pipe<T> pipe = new PipeMovimiento<>();
            pipe.ejecutar(objeto);
        }
    }

}
