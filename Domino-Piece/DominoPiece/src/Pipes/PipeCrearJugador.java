/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearJugador;
import Filters.FiltroCrearPartida;

/**
 *
 * @author diego
 */
public class PipeCrearJugador implements Pipe {

    @Override
    public void ejecutar(Object object) {

        Filtro f = new FiltroCrearJugador();
        f.ejecutar(object);
      
    }
}
