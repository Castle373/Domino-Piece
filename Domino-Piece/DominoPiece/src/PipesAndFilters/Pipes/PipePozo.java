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
    private Filtro filtro;
    @Override
    public void ejecutar(T pozo) {
        
        filtro.ejecutar(pozo);
      
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