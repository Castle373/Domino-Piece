/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class JugadorDTO {
    private String nombre;
    private Image avatar;
    private List<FichaDTO> fichasJugador;

    public JugadorDTO() {
    }
    
    public JugadorDTO(String nombre, Image avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.fichasJugador = new ArrayList<>();
    }

    public JugadorDTO(String nombre, Image avatar, List<FichaDTO> fichasJugador) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.fichasJugador = fichasJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public List<FichaDTO> getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(List<FichaDTO> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }
    
    
    
}
