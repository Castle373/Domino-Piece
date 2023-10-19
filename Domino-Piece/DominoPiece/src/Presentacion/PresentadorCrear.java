/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloCrear;
import Vista.VistaCrear;
import Vista.VistaUnirse;
import dominio_domino.Partida;

/**
 *
 * @author marcos
 */
public class PresentadorCrear implements IPresentadorCrear {

    private ModeloCrear modeloCrear;
    private IPresentadorUnirse presentadorUnirse;
    private VistaCrear pantallaCrear;

    public PresentadorCrear() {
        modeloCrear = new ModeloCrear();
        presentadorUnirse = new PresentadorUnirse();
        pantallaCrear = new VistaCrear(this);
    }

    @Override
    public void mostrarPantalla() {
        pantallaCrear.setVisible(true);
    }

    @Override
    public void crearPartida(int fichasIniciales) {
        Partida partida = modeloCrear.crearPartida(fichasIniciales);
        if (partida == null) {
            pantallaCrear.muestraMensajeError();
        } else {
            mostrarPantallaUnirse();
        }
    }

    @Override
    public void mostrarPantallaUnirse() {
        presentadorUnirse.mostrarPantallaUnirse();
        enviarPartida();
        pantallaCrear.dispose();
    }

    @Override
    public void enviarPartida() {
        presentadorUnirse.guardarPartida(obtenerPartida());
    }

    @Override
    public Partida obtenerPartida() {
        return modeloCrear.recuperarPartida();
    }

}
