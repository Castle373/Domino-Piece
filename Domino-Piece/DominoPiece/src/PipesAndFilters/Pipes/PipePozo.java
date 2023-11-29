/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroMovimiento;
import PipesAndFilters.Filters.FiltroPozo;

/**
 *
 * @author diego
 */
public class PipePozo<T> implements Pipe<T>  {
    @Override
    public void ejecutar(T pozo) {
        Filtro f = new FiltroPozo();
        f.ejecutar(pozo);
      
    }
}