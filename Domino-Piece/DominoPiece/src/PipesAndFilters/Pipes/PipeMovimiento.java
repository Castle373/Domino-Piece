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
public class PipeMovimiento<T> implements Pipe<T>  {
    @Override
    public void ejecutar(T movimiento) {
        Filtro f = new FiltroMovimiento();
        f.ejecutar(movimiento);
      
    }
}
