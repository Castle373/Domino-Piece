
package PipesAndFilters.Filters;


import Evento.RespuestaVotacionPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import dominio_dominodto.RespuestaDTO;

/**
 *
 * @author IVAN
 */
public class FiltroEnviarRespuesta <T> implements Filtro<T> {

    @Override
    public void ejecutar(T respuesta) {
       RespuestaDTO r = new RespuestaDTO();

        if (respuesta instanceof RespuestaVotacionPF) {
            RespuestaVotacionPF rpf= (RespuestaVotacionPF) respuesta;
            r = new RespuestaDTO( rpf.isRespuestaP());
            ((RespuestaVotacionPF) respuesta).setData(r);
        }
        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(respuesta);
    }
    
}
