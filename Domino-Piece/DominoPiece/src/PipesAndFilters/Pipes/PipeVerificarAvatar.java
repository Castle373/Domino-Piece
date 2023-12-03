/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import Evento.Evento;
import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearJugador;
import PipesAndFilters.Filters.FiltroVerificarAvatar;

/**
 *
 * @author Marcos T.
 */
public class PipeVerificarAvatar  <T extends Evento>  implements Pipe<T> {
private Filtro filtro;
    @Override
    public void ejecutar(T avatar) {
        
        filtro.ejecutar(avatar);
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
