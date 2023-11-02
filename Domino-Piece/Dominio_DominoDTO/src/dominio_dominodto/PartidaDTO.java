/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.util.List;

/**
 *
 * @author diego
 */
public class PartidaDTO {

    private int numeroFichas;
    private List<JugadorDTO> jugadores;
    private TableroDTO tablero;
    private PozoDTO pozo;
    private int turno;

    public PartidaDTO() {
        
    }

    public PartidaDTO(int numeroFichas) {
        this.numeroFichas = numeroFichas;
    }

    public PartidaDTO(int numeroFichas, List<JugadorDTO> jugadores, TableroDTO tablero, PozoDTO pozo, int turno) {
        this.numeroFichas = numeroFichas;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.pozo = pozo;
        this.turno = turno;
    }
    
    public int getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(int numeroFichas) {
        this.numeroFichas = numeroFichas;
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    public void setTablero(TableroDTO tablero) {
        this.tablero = tablero;
    }

    public PozoDTO getPozo() {
        return pozo;
    }

    public void setPozo(PozoDTO pozo) {
        this.pozo = pozo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    

}
