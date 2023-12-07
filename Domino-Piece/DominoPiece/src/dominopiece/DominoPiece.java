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
        
    
        
        Pipe pipeFin = new PipeFin();
 
        
        //Creacion de Primer PipeLine
        pipeMovimiento.setFiltro(filtroMovimiento);
        Pipe pipeBasico = new PipeBasico(filtroPozo);
        filtroMovimiento.setPipe(pipeBasico);
        pipeBasico = new PipeBasico(filtroPasaTurno);
        filtroPozo.setPipe(pipeBasico);
        pipeBasico = new PipeBasico(filtroIniciarVotacion);
        filtroPasaTurno.setPipe(pipeBasico);
        pipeBasico = new PipeBasico(filtroIniciarVotacionTerminar);
        filtroIniciarVotacion.setPipe(pipeBasico);
        pipeBasico = new PipeBasico(filtroEnviarRespuesta);
        filtroIniciarVotacionTerminar.setPipe(pipeBasico);
        filtroEnviarRespuesta.setPipe(pipeFin);
        
        
        
        
        
//        pipeIniciarVotacion.setFiltro(filtroIniciarVotacion);
//        filtroIniciarVotacion.setPipe(pipeIniciarVotacionTerminar);
//        pipeIniciarVotacionTerminar.setFiltro(filtroIniciarVotacionTerminar);
//        filtroIniciarVotacionTerminar.setPipe(pipeRespuestaVotacion);
//        pipeRespuestaVotacion.setFiltro(filtroEnviarRespuesta);
//        filtroEnviarRespuesta.setPipe(pipeFin);


//        //Creacion de Segundo PipeLine
          
          pipeCrearJugador.setFiltro(filtroCrearJugador);
          pipeBasico = new PipeBasico(filtroVerificarAvatar);
          filtroCrearJugador.setPipe(pipeBasico);
          filtroVerificarAvatar.setPipe(pipeFin);
//        pipeCrearJugador.setFiltro(filtroCrearJugador);
//        filtroCrearJugador.setPipe(pipeVerificarAvatar);
//        pipeVerificarAvatar.setFiltro(filtroVerificarAvatar);
//        filtroVerificarAvatar.setPipe(pipeFin);
//        //Creacion de tercero PipeLine
          
          pipeCrearPartida.setFiltro(filtroCrearPartida);
          pipeBasico = new PipeBasico(filtroBuscarPartida);
          filtroCrearPartida.setPipe(pipeBasico);
          filtroBuscarPartida.setPipe(pipeFin);
          
//        pipeCrearPartida.setFiltro(filtroCrearPartida);
//        filtroCrearPartida.setPipe(pipeBuscarPartida);
//        pipeBuscarPartida.setFiltro(filtroBuscarPartida);
//        filtroBuscarPartida.setPipe(pipeFin);
                System.out.println("s");
        IPresentadorMenu presentador = new PresentadorMenu();
        presentador.mostrarMenu();
        //En la esta Prueba
    }

}
