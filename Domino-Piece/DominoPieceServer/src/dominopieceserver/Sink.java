/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import dominio_dominodto.PozoDTO;
import dominio_dominodto.TableroDTO;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Sink {

    private volatile static Sink instance;
    public Partida partida;

    public static synchronized Sink getInstance() {
        if (instance == null) {

            instance = new Sink();

        }
        return instance;
    }

    public Sink() {

    }

    public void CrearPartida(PartidaDTO p) {
        partida = new Partida(p.getNumeroFichas());
    }
    public void agregarJugador(JugadorDTO j){
        Jugador juga = new Jugador(j.getNombre(), j.getAvatar());
        partida.addJugador(juga);
    }
    public PartidaDTO getPartidaDTO() {

        PartidaDTO partidaDTO = new PartidaDTO();

        partidaDTO.setNumeroFichas(partida.getNumeroFichas());
        
        
        // Copia la información de los jugadores
        List<JugadorDTO> jugadoresDTO = new ArrayList<>();

        for (Jugador jugador : partida.getJugadores()) {
            JugadorDTO jugadorDTO = new JugadorDTO();
            // Copia los atributos relevantes de Jugador a JugadorDTO
            jugadorDTO.setNombre(jugador.getNombre());
            List<FichaDTO> fichasDTO = new ArrayList<>();

            for (FichaJugador f : jugador.getFichasJugador()) {
                FichaDTO fichaDTO = new FichaDTO(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba());
                fichasDTO.add(fichaDTO);
            }

            jugadorDTO.setFichasJugador(fichasDTO);
            jugadorDTO.setAvatar(jugador.getAvatar());
            // Copia otros atributos necesarios
            jugadoresDTO.add(jugadorDTO);
        }
        partidaDTO.setJugadores(jugadoresDTO);
        
        if (partida.getTablero()==null) {
            return partidaDTO;
        }
        
        // Copia la información del tablero y el pozo
        List<FichaTableroDTO> fichasTableroDTO = new ArrayList<>();
        for (FichaTablero f : partida.getTablero().getFichasTablero()) {
            FichaTableroDTO fichaT = new FichaTableroDTO(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba());
            fichaT.setConectarAbajo(f.isConectarAbajo());
            fichaT.setConectarAbajo(f.isConectarArriba());
            fichasTableroDTO.add(fichaT);
        }
        partidaDTO.setTablero(new TableroDTO(fichasTableroDTO));
        List<FichaDTO> fichasDTO = new ArrayList<>();
        
        
        for (FichaPozo f : partida.getPozo().getFichasPozo()) {
            FichaDTO fichaDTO = new FichaDTO(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba());
            fichasDTO.add(fichaDTO);
        }

        partidaDTO.setPozo(new PozoDTO(fichasDTO));
        partidaDTO.setTurno(partida.getTurno());

        return partidaDTO;
    }

}
