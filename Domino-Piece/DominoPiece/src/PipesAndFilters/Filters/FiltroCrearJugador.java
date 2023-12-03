/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.JugadorPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import PipesAndFilters.Pipes.PipeVerificarAvatar;
import dominio_dominodto.JugadorDTO;
import java.util.UUID;

/**
 *
 * @author diego
 */
public class FiltroCrearJugador<T extends Evento> implements Filtro<T> {

    private Pipe pipe;
    
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

       
        pipe.ejecutar(jugador);

    }

    @Override
    public Pipe getPipe() {
        return pipe;
    }

    @Override
    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }

}
