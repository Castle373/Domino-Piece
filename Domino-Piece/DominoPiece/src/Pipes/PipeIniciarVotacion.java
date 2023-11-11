/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Evento.Evento;
import Filters.Filtro;
import Filters.FiltroIniciarVotacion;

/**
 *
 * @author IVAN
 */
public class PipeIniciarVotacion <T extends Evento>  implements Pipe<T> {

    @Override
    public void ejecutar(T s) {
       Filtro<T> f = new FiltroIniciarVotacion();
        f.ejecutar(s);
    }
    
}