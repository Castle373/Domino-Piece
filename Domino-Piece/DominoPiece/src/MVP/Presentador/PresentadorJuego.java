/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Presentador;

import Evento.RobarPozoPF;
import MVP.Modelo.ModeloJuego;
import MVP.Vista.VistaJuego;

import dominio_dominodto.Acciones;
import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;

import dominio_dominodto.JugadorDTO;
import dominio_dominodto.MovimientoDTO;
import dominio_dominodto.PartidaDTO;
import dominio_dominodto.TerminarDTO;
import java.util.List;

/**
 *
 * @author diego <3
 */
public class PresentadorJuego implements IPresentacionJuego, Observer {

    private ModeloJuego modelo;

    private VistaJuego vista;

    public PresentadorJuego() {
        vista = new VistaJuego(this);
        modelo = new ModeloJuego();
    }

    @Override
    public void mostrarPantallaJuego() {
        vista.setVisible(true);
//       vista.mostrarJugadores();
    }

    @Override
    public void realizaMovimiento(FichaTableroDTO ficha, int lado) {
        modelo.validaMovimiento(ficha, lado);
    }

    

    @Override
    public void robarFicha() {
        modelo.robarFicha();
    }

    @Override
    public void guardarJugador(JugadorDTO jugador) {
        modelo.guardarJugador(jugador);
        vista.asignarJugadorJugando(jugador);
    }

//    @Override
//    public void eliminarFichaJugador(FichaDTO ficha) {
//        modelo.eliminarFicha(ficha);
//    }
    @Override
    public void pasarTurno() {
        modelo.pasarTurno();
    }


    @Override
    public JugadorDTO getJugadorDTO() {
        return modelo.getJugador();
    }

    @Override
    public boolean isTurno() {
        return modelo.isTurno();
    }

    @Override
    public List<JugadorDTO> listaJugadores() {
        return modelo.getListJugadoresDTO();
    }

    

    @Override
    public void update(Object loquesea) {

        if (loquesea instanceof PartidaDTO) {
            PartidaDTO p = (PartidaDTO) loquesea;
            modelo.setPartida2(p);
            vista.mostrarJugadores();
            if (vista.isVotar()) {
                this.respuestaVotacion(false);
            }
        } else if (loquesea instanceof JugadorDTO) {
            JugadorDTO j = (JugadorDTO) loquesea;
            this.guardarJugador(j);
            vista.asignarJugadorJugando(j);

        } else if (loquesea instanceof MovimientoDTO) {
            MovimientoDTO m = (MovimientoDTO) loquesea;
            if (m.isValido()) {
                vista.colocarFicha(m.getFichaTablero(), m.getZona());
            } else {
                vista.regresaFicha();
            }
        } else if (loquesea instanceof Acciones) {
            Acciones a = (Acciones) loquesea;
            if (a == Acciones.INICIAR_PARTIDA) {
                vista.setVotar(false);
                vista.mostrarJugadores();
                vista.iniciarJuego();
            }
            if (a == Acciones.INICIAR_VOTACION) {
                vista.votacion();
            }

            if (a == Acciones.NO_INICIAR) {
                vista.setVotar(false);
                vista.votacionNoaceptada();
            }

        }
        else if (loquesea instanceof TerminarDTO) {
            TerminarDTO t = (TerminarDTO) loquesea;
            System.out.println("acaba de terminar la partida");
            vista.TerminarPartida();
            vista.mostrarPuntuaciones(t.getJugadoresPuntacion());
        }

    }

    @Override
    public PartidaDTO getPartida() {
        return modelo.getPartida2();
    }

    @Override
    public void iniciarVotacion() {
        if (modelo.getListJugadoresDTO().size() > 1 && modelo.getListJugadoresDTO().size() < 4) {
            modelo.iniciarVotacion();
        } else {
            vista.mostrarMensaje();
        }
    }

    @Override
    public void respuestaVotacion(boolean respuesta) {
        modelo.respuestaVotacion(respuesta);
    }

    @Override
    public void iniciarVotacionTerminarPartida() {
        if (modelo.getListJugadoresDTO().size() > 1 ) {
            modelo.iniciarVotacionTerminar();
        } else {
            vista.mostrarMensaje();
        }
    }
}
