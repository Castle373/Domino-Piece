/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroMovimiento;
import PipesAndFilters.Filters.FiltroPasaTurno;

/**
 *
 * @author diego
 */
public class PipePasaTurno<T> implements Pipe<T>  {
    @Override
    public void ejecutar(T turno) {
        Filtro f = new FiltroPasaTurno();
        f.ejecutar(turno);
      
    }
}
