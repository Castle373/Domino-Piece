/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author diego
 */
public class JugadorDTO implements Serializable {

    private UUID id;
    private String nombre;
    private String avatar;
    private List<FichaDTO> fichasJugador;

    public JugadorDTO() {
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public JugadorDTO(String nombre, String avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.fichasJugador = new ArrayList<>();
    }

    public JugadorDTO(String nombre, String avatar, List<FichaDTO> fichasJugador) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<FichaDTO> getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(List<FichaDTO> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

}
