/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Evento.Evento;
import Filters.Filtro;
import Filters.FiltroCrearPartida;
import Filters.FiltroInicio;

/**
 *
 * @author diego
 */
public class PipeInicio<T extends Evento>  implements Pipe<T> {


    @Override
    public void ejecutar(T claseInicial) {
        Filtro<T> f = new FiltroInicio();
        f.ejecutar(claseInicial);

    }

}
