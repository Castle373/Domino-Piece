/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class RobarFichaDTO implements Serializable{
    private JugadorDTO jugador;
    private FichaDTO fichaDTO;

    public RobarFichaDTO(JugadorDTO jugador, FichaDTO fichaDTO) {
        this.jugador = jugador;
        this.fichaDTO = fichaDTO;
    }

    public RobarFichaDTO(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    public FichaDTO getFichaDTO() {
        return fichaDTO;
    }

    public void setFichaDTO(FichaDTO fichaDTO) {
        this.fichaDTO = fichaDTO;
    }
    
}
