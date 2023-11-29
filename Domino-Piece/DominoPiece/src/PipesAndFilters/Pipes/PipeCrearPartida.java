/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearPartida;


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
