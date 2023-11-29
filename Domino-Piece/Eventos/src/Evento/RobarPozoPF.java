/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import dominio_dominodto.JugadorDTO;
import java.awt.Robot;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class RobarPozoPF <T> implements Evento<T>, Serializable {

    private JugadorDTO jugadorDTO;
 
    private T jugador;

    public RobarPozoPF(JugadorDTO JugadorDTO) {
        this.jugadorDTO = JugadorDTO;
    }

    public JugadorDTO getJugadorDTO() {
        return jugadorDTO;
    }

    public void setJugadorDTO(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    @Override
    public T getData() {
        return jugador;
    }

    @Override
    public void setData(T jugador) {
        this.jugador = jugador;
    }

}
