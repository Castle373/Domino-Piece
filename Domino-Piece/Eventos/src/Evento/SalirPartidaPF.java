/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class SalirPartidaPF<T> implements Evento<T> , Serializable{
    
   
    
    private T jugador;

    public SalirPartidaPF() {
    }

    public SalirPartidaPF(T jugador) {
        this.jugador = jugador;
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
