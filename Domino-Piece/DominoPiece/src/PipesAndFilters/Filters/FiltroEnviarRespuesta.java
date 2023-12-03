
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
private Pipe pipe;
    @Override
    public void ejecutar(T respuesta) {
       RespuestaDTO r = new RespuestaDTO();

        if (respuesta instanceof RespuestaVotacionPF) {
            RespuestaVotacionPF rpf= (RespuestaVotacionPF) respuesta;
            r = new RespuestaDTO( rpf.isRespuestaP());
            ((RespuestaVotacionPF) respuesta).setData(r);
        }
        
        pipe.ejecutar(respuesta);
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
