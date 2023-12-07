/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.RobarPozoPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import dominio_dominodto.RobarFichaDTO;

/**
 *
 * @author diego
 */
public class FiltroPozo <T extends Evento> implements Filtro<T> {
    private Pipe pipe;
    @Override
    public void ejecutar(T objeto) {
        if (objeto instanceof RobarPozoPF) {
            RobarPozoPF robo = (RobarPozoPF) objeto;
            RobarFichaDTO roboDTO = new RobarFichaDTO(robo.getJugadorDTO());
            objeto.setData(roboDTO);
        }
       
        pipe.ejecutar(objeto);
    }
    @Override
    public Pipe getPipe() {
        return pipe;
    }

    @Override
    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }
}
