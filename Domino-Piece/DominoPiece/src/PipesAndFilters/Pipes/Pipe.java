/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;


/**
 *
 * @author diego
 */
public interface Pipe<T> {
    public void ejecutar(T s);
    public Filtro getFiltro();
    public void setFiltro(Filtro f);
}
