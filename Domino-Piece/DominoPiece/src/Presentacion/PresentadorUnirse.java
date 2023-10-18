/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloUnirse;
import Vista.vistaUnirse;
import dominio_domino.Partida;
import java.awt.Image;

/**
 *
 * @author marcos
 */
public class PresentadorUnirse implements IPresentadorUnirse {

    private ModeloUnirse modelo;
    private IPresentacionJuego presentadorJuego;
    private vistaUnirse vista;

    public PresentadorUnirse() {
        vista = new vistaUnirse(this);
        modelo = new ModeloUnirse();
        presentadorJuego = new PresentacionJuego();
    }

    @Override
    public void mostrarPantallaUnirse() {
        vista.setVisible(true);
    }

    @Override
    public void crearJugador(String nombre, Image avatar) {
        modelo.crearJugador(nombre, avatar);
        
        if (modelo.recuperaPartida()==null) {
            vista.muestraMensajeError();
        }else{
            mostrarPantallaJuego();
        }   
    }

    @Override
    public void mostrarPantallaJuego() {
        presentadorJuego.mostrarPantallaJuego();
        vista.dispose();
    }
    

}
