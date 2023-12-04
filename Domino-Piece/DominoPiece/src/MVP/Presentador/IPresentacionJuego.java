/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MVP.Presentador;

import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPresentacionJuego {

    public void mostrarPantallaJuego();

    public void realizaMovimiento(FichaTableroDTO ficha, int lado);

    public void guardarJugador(JugadorDTO jugador);

    public List<JugadorDTO> listaJugadores();

    public void robarFicha();

    public JugadorDTO getJugadorDTO();
//    public void eliminarFichaJugador(FichaDTO ficha);

    public void pasarTurno();

    public PartidaDTO getPartida();

    public void salirPartida();

    public boolean isTurno();

    public void iniciarVotacion();

    public void iniciarVotacionTerminarPartida();

    public void respuestaVotacion(boolean respuesta);

}
