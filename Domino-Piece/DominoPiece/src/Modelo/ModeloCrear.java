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
    
    public Partida crearPartida(int fichasIniciales){
        Partida partida = new Partida(fichasIniciales);
        return partida;
    }
}
