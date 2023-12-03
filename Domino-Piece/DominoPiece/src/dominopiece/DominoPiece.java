/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dominopiece;

import MVP.Presentador.IPresentadorMenu;
import MVP.Presentador.PresentadorMenu;
import PipesAndFilters.Filters.*;
import PipesAndFilters.Pipes.*;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ivan(LIDER),diego, Adan, Marcos
 */
public class DominoPiece {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Filtro filtroCrearJugador = new FiltroCrearJugador();
        Filtro filtroIniciarVotacionTerminar = new FiltroIniciarVotacionTerminar();
        Filtro filtroIniciarVotacion = new FiltroIniciarVotacion();
        Filtro filtroCrearPartida = new FiltroCrearPartida();
        Filtro filtroBuscarPartida = new FiltroBuscarPartida();
        Filtro filtroEnviarRespuesta = new FiltroEnviarRespuesta();
        Filtro filtroPasaTurno = new FiltroPasaTurno();
        Filtro filtroPozo = new FiltroPozo();
        Filtro filtroMovimiento = new FiltroMovimiento();
        Filtro filtroVerificarAvatar = new FiltroVerificarAvatar();
        
        Pipe pipeCrearPartida = PipeCrearPartida.getInstance();
        Pipe pipeCrearJugador = PipeCrearJugador.getInstance();
        Pipe pipeMovimiento = PipeMovimiento.getInstance();
        Pipe pipeBuscarPartida = new PipeBuscarPartida();
        Pipe pipeIniciarVotacion = new PipeIniciarVotacion();
        Pipe pipeIniciarVotacionTerminar = new PipeIniciarVotacionTerminar();
        Pipe pipePozo = new PipePozo();
        Pipe pipeFin = new PipeFin();
        Pipe pipePasaTurno = new PipePasaTurno();
        Pipe pipeRespuestaVotacion = new PipeRespuestaVotacion();
        Pipe pipeVerificarAvatar = new PipeVerificarAvatar();
        
        //Creacion de Primer PipeLine
        pipeMovimiento.setFiltro(filtroMovimiento);
        filtroMovimiento.setPipe(pipePozo);
        pipePozo.setFiltro(filtroPozo);
        filtroPozo.setPipe(pipePasaTurno);
        pipePasaTurno.setFiltro(filtroPasaTurno);
        filtroPasaTurno.setPipe(pipeIniciarVotacion);
        pipeIniciarVotacion.setFiltro(filtroIniciarVotacion);
        filtroIniciarVotacion.setPipe(pipeIniciarVotacionTerminar);
        pipeIniciarVotacionTerminar.setFiltro(filtroIniciarVotacionTerminar);
        filtroIniciarVotacionTerminar.setPipe(pipeRespuestaVotacion);
        pipeRespuestaVotacion.setFiltro(filtroEnviarRespuesta);
        filtroEnviarRespuesta.setPipe(pipeFin);
        //Creacion de Segundo PipeLine
        pipeCrearJugador.setFiltro(filtroCrearJugador);
        filtroCrearJugador.setPipe(pipeVerificarAvatar);
        pipeVerificarAvatar.setFiltro(filtroVerificarAvatar);
        filtroVerificarAvatar.setPipe(pipeFin);
        //Creacion de tercero PipeLine
        pipeCrearPartida.setFiltro(filtroCrearPartida);
        filtroCrearPartida.setPipe(pipeBuscarPartida);
        pipeBuscarPartida.setFiltro(filtroBuscarPartida);
        filtroBuscarPartida.setPipe(pipeFin);
                System.out.println("s");
        IPresentadorMenu presentador = new PresentadorMenu();
        presentador.mostrarMenu();
        //En la esta Prueba
    }

}
