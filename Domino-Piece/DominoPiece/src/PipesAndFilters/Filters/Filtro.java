/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PipesAndFilters.Filters;

import PipesAndFilters.Pipes.Pipe;

/**
 *
 * @author diego
 */
public interface Filtro<T> {
    public void ejecutar(T objeto);
    public Pipe getPipe();
    public void setPipe(Pipe pipe);
}
