/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import dominio_domino.Partida;

/**
 *
 * @author marcos
 */
public class ModeloCrear {

    private Partida partida;

    public Partida crearPartida(int fichasIniciales) {
        partida = new Partida(fichasIniciales);
        return partida;
    }

    public Partida recuperarPartida() {
        return partida;
    }
}
