/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Graficos.TableroGrafico;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;

/**
 *
 * @author diego
 */
public class ModeloJuego {

    private Partida partida;

    public ModeloJuego() {

    }

    public void guardarPartida(Partida partida) {
        this.partida = partida;
    }

    public Partida recuperaPartida() {
        return partida;
    }

    public boolean validaMovimiento(FichaTablero ficha, int lado) {
        Tablero tablero = partida.getTablero();
        switch (lado) {
            case 1:
                return tablero.validaZonaInical(ficha);
            case 2:
                return tablero.validaLadoDerecho(ficha);
            case 3:
                return tablero.validaLadoIzquierdo(ficha);

        }
        return false;
    }

    public void crearPozo() {
        Pozo pozo = new Pozo();
        partida.setPozo(pozo);
    }

    public void reparteFichas() {

    }

    public void reparteFichasExtras() {

    }

    public void verificaFichas() {

    }

    public void crearTablero() {
        Tablero t = new Tablero();
        partida.setTablero(t);
    }
    public FichaPozo robarFicha(){
        return partida.getPozo().obtenerFichaAleatoria();
    }

}
