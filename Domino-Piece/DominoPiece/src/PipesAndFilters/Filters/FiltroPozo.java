/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.RobarPozoPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import PipesAndFilters.Pipes.PipePasaTurno;
import dominio_dominodto.RobarFichaDTO;

/**
 *
 * @author diego
 */
public class FiltroPozo <T extends Evento> implements Filtro<T> {
    
    @Override
    public void ejecutar(T objeto) {
        if (objeto instanceof RobarPozoPF) {
            RobarPozoPF robo = (RobarPozoPF) objeto;
            RobarFichaDTO roboDTO = new RobarFichaDTO(robo.getJugadorDTO());
            objeto.setData(roboDTO);
        }
        Pipe<T> pipaPasaTurno = new PipePasaTurno();
        pipaPasaTurno.ejecutar(objeto);
    }
    
}
