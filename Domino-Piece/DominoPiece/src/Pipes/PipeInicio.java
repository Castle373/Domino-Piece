/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearPartida;
import Filters.FiltroInicio;

/**
 *
 * @author diego
 */
public class PipeInicio implements Pipe {

    @Override
    public void ejecutar(Object object) {

        Filtro f = new FiltroInicio();
        f.ejecutar(object);

    }

}
