/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diego
 */
public class TerminarDTO implements Serializable{
    public List<JugadorDTO> jugadoresPuntacion;
    public Acciones motivo;

    public TerminarDTO(List<JugadorDTO> jugadoresPuntacion, Acciones motivo) {
        this.jugadoresPuntacion = jugadoresPuntacion;
        this.motivo = motivo;
    }

    public TerminarDTO() {
    }

    public List<JugadorDTO> getJugadoresPuntacion() {
        return jugadoresPuntacion;
    }

    public void setJugadoresPuntacion(List<JugadorDTO> jugadoresPuntacion) {
        this.jugadoresPuntacion = jugadoresPuntacion;
    }
    
}
