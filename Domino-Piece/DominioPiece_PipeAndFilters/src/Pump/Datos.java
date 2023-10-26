/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pump;

import Pipes.Pipe;
import Pipes.PipeCrearPartida;

/**
 *
 * @author diego
 */
public class Datos {
    
    public void CrearPartida(Integer numeroFichas) {
        Pipe p = new PipeCrearPartida();
        p.ejecutar(numeroFichas);
    }
}
