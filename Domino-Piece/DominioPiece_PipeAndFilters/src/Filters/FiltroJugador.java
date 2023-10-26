/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeGuardarJugador;
import Pipes.PipeNumeroFicas;
import dominio_domino.Jugador;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class FiltroJugador implements Filtro<JugadorDTO>{

    @Override
    public void ejecutar(JugadorDTO objeto) {
       Pipe p = new PipeGuardarJugador();
       Jugador j = new Jugador(objeto.getNombre(), objeto.getAvatar());
        p.ejecutar(j);
    }
    
}
