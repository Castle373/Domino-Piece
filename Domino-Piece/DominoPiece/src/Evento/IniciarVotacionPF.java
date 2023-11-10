/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

/**
 *
 * @author IVAN
 */
public class IniciarVotacionPF <T> implements Evento<T> {
    
    private T acciones;
    @Override
    public void setData(T acciones) {
     this.acciones=acciones;
    }

    @Override
    public T getData() {
       return acciones;
    }
    
}
