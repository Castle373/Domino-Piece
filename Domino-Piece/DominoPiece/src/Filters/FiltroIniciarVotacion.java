/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.Evento;
import Evento.IniciarVotacionPF;
import Pipes.Pipe;
import Pipes.PipeFin;
import dominio_dominodto.Acciones;


/**
 *
 * @author IVAN
 */
public class FiltroIniciarVotacion <T extends Evento> implements Filtro<T> {
    
    @Override
    public void ejecutar(T objeto) {
       
        if (objeto instanceof IniciarVotacionPF) {

             
            ((IniciarVotacionPF) objeto).setData(Acciones.INICIAR_VOTACION);
        }
        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(objeto);
    }
    
}
