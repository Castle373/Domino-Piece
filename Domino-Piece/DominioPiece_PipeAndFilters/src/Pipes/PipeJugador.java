/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearPartida;
import Filters.FiltroJugador;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class PipeJugador implements Pipe{

    @Override
    public void ejecutar(Object jugador) {
       Filtro f = new FiltroJugador();
        f.ejecutar(f);
    }
    
}
