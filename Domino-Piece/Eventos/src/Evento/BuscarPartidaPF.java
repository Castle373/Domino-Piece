/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import dominio_dominodto.Acciones;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class BuscarPartidaPF<T> implements Evento<T>, Serializable{


    private T buscar;

    public BuscarPartidaPF() {
        
    }

    @Override
    public T getData() {
        return buscar;
    }

    @Override
    public void setData(T buscar) {
        this.buscar = buscar;
    }

}
