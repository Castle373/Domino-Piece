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
public class JugadorPF<T> implements Evento<T> , Serializable{
    
    private String nombre;
    private String avatar;
    
    private T jugador;

    public JugadorPF(String nombre, String avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
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
    
    @Override
    public T getData() {
        return jugador;
    }

    @Override
    public void setData(T jugador) {
       this.jugador=jugador;
    }
    
}
