/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Evento.Evento;
import Filters.Filtro;
import Filters.FiltroCrearJugador;
import Filters.FiltroVerificarAvatar;

/**
 *
 * @author Marcos T.
 */
public class PipeVerificarAvatar  <T extends Evento>  implements Pipe<T> {

    @Override
    public void ejecutar(T avatar) {
        Filtro f = new FiltroVerificarAvatar();
        f.ejecutar(avatar);
    }
}
