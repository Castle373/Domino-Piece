/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.MovimientoPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import PipesAndFilters.Pipes.PipePozo;
import dominio_dominodto.MovimientoDTO;

/**
 *
 * @author diego
 */
public class FiltroMovimiento<T> implements Filtro<T> {

    @Override
    public void ejecutar(T movimiento) {
        MovimientoDTO movimientoDto = new MovimientoDTO();
        if (movimiento instanceof MovimientoPF) {
            MovimientoPF movimientopf = (MovimientoPF) movimiento;
            movimientoDto = new MovimientoDTO(movimientopf.getFicha(), movimientopf.getZona());
            ((MovimientoPF) movimiento).setData(movimientoDto);
           
        }
        Pipe<T> pipaPozo = new PipePozo();
        pipaPozo.ejecutar(movimiento);
    }

}
