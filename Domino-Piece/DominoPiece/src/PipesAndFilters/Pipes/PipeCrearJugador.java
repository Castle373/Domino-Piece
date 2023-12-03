/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearJugador;
import PipesAndFilters.Filters.FiltroCrearPartida;

/**
 *
 * @author diego
 */
public class PipeCrearJugador<T> implements Pipe<T> {

    private volatile static PipeCrearJugador instance;

    public static synchronized PipeCrearJugador getInstance() {

        if (instance == null) {

            instance = new PipeCrearJugador();

        }
        return instance;
    }
    private Filtro filtro;

    @Override
    public void ejecutar(T jugador) {

        filtro.ejecutar(jugador);

    }

    @Override
    public Filtro getFiltro() {
        return filtro;
    }

    @Override
    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
}
