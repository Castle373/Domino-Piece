/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Graficos.TableroGrafico;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;

/**
 *
 * @author diego
 */
public class ModeloJuego {
    private TableroGrafico tableroG;
    public ModeloJuego(){
        Pozo pozo = new Pozo();
        Tablero t = new Tablero();
        Partida p = new Partida(3, t, pozo);
//        tableroG= new TableroGrafico(p);
    }
    
    
}
