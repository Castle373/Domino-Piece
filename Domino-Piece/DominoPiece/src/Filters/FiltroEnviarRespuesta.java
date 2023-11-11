
package Filters;


import Evento.RespuestaVotacionPF;
import Pipes.Pipe;
import Pipes.PipeFin;
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
