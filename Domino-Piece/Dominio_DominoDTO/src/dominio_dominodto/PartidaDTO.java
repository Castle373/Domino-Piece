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
    private int numero;
    private List<JugadorDTO> jugador;
    public PartidaDTO(int numero) {
        this.numero = numero;
    }

    public List<JugadorDTO> getJugador() {
        return jugador;
    }

    public void setJugador(List<JugadorDTO> jugador) {
        this.jugador = jugador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
