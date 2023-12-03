/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearJugador;
import PipesAndFilters.Filters.FiltroMovimiento;

/**
 *
 * @author diego
 */
public class PipeMovimiento<T> implements Pipe<T> {

    private volatile static PipeMovimiento instance;

    public static synchronized PipeMovimiento getInstance() {

        if (instance == null) {

            instance = new PipeMovimiento();

        }
        return instance;
    }
    private Filtro filtro;

    @Override
    public void ejecutar(T movimiento) {

        filtro.ejecutar(movimiento);

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
