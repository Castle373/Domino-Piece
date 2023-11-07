/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearPartida;
import dominio_domino.Partida;

/**
 *
 * @author diego
 */
public class PipeCrearPartida<T> implements Pipe<T> {

    @Override
    public void ejecutar(T numeroFicha) {
        Filtro<T> f = new FiltroCrearPartida();
        f.ejecutar(numeroFicha);
    }

}
