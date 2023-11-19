/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloJuego;
import Observer.Observer;
import Vista.VistaJuego;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.Acciones;
import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;

import dominio_dominodto.JugadorDTO;
import dominio_dominodto.MovimientoDTO;
import dominio_dominodto.PartidaDTO;
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
    public void guardarPartida(Partida partida) {
        modelo.guardarPartida(partida);
    }

    @Override
    public void robarFicha() {
        FichaPozo f = modelo.robarFicha();

        if (f != null) {
            vista.pintarFichas();
        } else {
            vista.mostrarMensajeError("No hay Fichas en el pozo");
        }

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
    public Jugador jugadorTurno() {
        return modelo.obtenerJugadorTurno();
    }

    @Override
    public JugadorDTO getJugadorDTO() {
        return modelo.getJugador();
    }

    @Override
    public boolean isTurno() {
        return false;
    }

    @Override
    public List<JugadorDTO> listaJugadores() {
        return modelo.getListJugadoresDTO();
    }

    @Override
    public void setListaJugadores(List<Jugador> jugadores) {
        modelo.setListJugadores(jugadores);
    }

    @Override
    public void update(Object loquesea) {

        if (loquesea instanceof PartidaDTO) {
            PartidaDTO p = (PartidaDTO) loquesea;
            modelo.setPartida2(p);
            vista.mostrarJugadores();
        }
        else if (loquesea instanceof JugadorDTO) {
            JugadorDTO j = (JugadorDTO) loquesea;
            this.guardarJugador(j);
            vista.asignarJugadorJugando(j);
            
        }
        else if (loquesea instanceof MovimientoDTO) {
            MovimientoDTO m = (MovimientoDTO) loquesea;
            if (m.isValido()) {
                vista.colocarFicha(m.getFichaTablero(), m.getZona());
            }else{
                vista.resetearFicha();
            }          
        }
        else if (loquesea instanceof Acciones) {
            Acciones a = (Acciones) loquesea;
            if (a == Acciones.INICIAR_PARTIDA) {
                vista.mostrarJugadores();
                vista.iniciarJuego();
            }
            if (a == Acciones.INICIAR_VOTACION) {
                vista.votacion();
            }

            if (a == Acciones.NO_INICIAR) {
                vista.votacionNoaceptada();
            }

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
}
