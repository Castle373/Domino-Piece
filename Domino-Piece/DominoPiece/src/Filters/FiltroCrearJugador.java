/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.JugadorPF;
import Pipes.Pipe;
import Pipes.PipeFin;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;
import java.util.UUID;

/**
 *
 * @author diego
 */
public class FiltroCrearJugador<T> implements Filtro<T> {

    @Override
    public void ejecutar(T jugador) {
        JugadorDTO j = new JugadorDTO();
        if (jugador instanceof JugadorPF) {
            UUID id = UUID.randomUUID();
            JugadorPF jpf = (JugadorPF) jugador;
            j.setNombre(jpf.getNombre());
            j.setAvatar(jpf.getAvatar());
            j.setId(id);

            ((JugadorPF) jugador).setData(j);
        }

        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(jugador);

    }

}
