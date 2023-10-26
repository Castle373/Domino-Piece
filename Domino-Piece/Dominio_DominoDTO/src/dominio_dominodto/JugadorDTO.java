/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.awt.Image;

/**
 *
 * @author diego
 */
public class JugadorDTO {
    private String nombre;
    private Image avatar;

    public JugadorDTO(String nombre, Image avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
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
    
}
