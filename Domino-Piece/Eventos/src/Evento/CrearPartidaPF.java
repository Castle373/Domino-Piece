/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;
import java.io.Serializable;

/**
 *
 * @author diego
 */
public class CrearPartidaPF<T> implements Evento<T>, Serializable{

    private int numfichas;
    private T partida;

    public CrearPartidaPF() {
    }

    public CrearPartidaPF(int numfichas) {
        this.numfichas = numfichas;
    }

    public int getNumfichas() {
        return numfichas;
    }

    public void setNumfichas(int numfichas) {
        this.numfichas = numfichas;
    }

    @Override
    public T getData() {
        return partida;
    }

    @Override
    public void setData(T partida) {
        this.partida = partida;
    }

}
