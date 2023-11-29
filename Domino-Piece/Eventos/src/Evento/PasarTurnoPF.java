/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import dominio_dominodto.JugadorDTO;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class PasarTurnoPF <T> implements Evento<T>, Serializable{

    private T respuesta;
    private JugadorDTO jugadorDTO;
    public PasarTurnoPF() {
      
    }

    public PasarTurnoPF(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    public JugadorDTO getJugadorDTO() {
        return jugadorDTO;
    }

    public void setJugadorDTO(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    @Override
    public void setData(T respuesta) {
        
      this.respuesta=respuesta;
    }

    @Override
    public T getData() {
        return respuesta;
    }

}