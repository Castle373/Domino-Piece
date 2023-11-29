/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import Evento.Evento;
import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearPartida;
import PipesAndFilters.Filters.FiltroInicio;

/**
 *
 * @author diego
 */
public class PipeInicio<T extends Evento>  implements Pipe<T> {


    @Override
    public void ejecutar(T claseInicial) {
        Filtro<T> f = new FiltroInicio();
        f.ejecutar(claseInicial);

    }

}
