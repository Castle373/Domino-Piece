/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.MovimientoPF;
import Pipes.Pipe;
import Pipes.PipeFin;
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
        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(movimiento);
    }

}
