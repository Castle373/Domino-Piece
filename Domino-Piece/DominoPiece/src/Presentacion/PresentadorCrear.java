/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloCrear;
import Vista.vistaCrear;
import Vista.vistaUnirse;
import dominio_domino.Partida;

/**
 *
 * @author marcos
 */
public class PresentadorCrear implements IPresentadorCrear {

    private ModeloCrear modeloCrear;
    private IPresentadorUnirse presentadorUnirse;
    private vistaCrear pantallaCrear;

    public PresentadorCrear() {
        modeloCrear = new ModeloCrear();
        presentadorUnirse = new PresentadorUnirse();
        pantallaCrear = new vistaCrear();
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
            presentadorUnirse.mostrarPantallaUnirse();
        }
    }

    @Override
    public void mostrarPantallaUnirse() {
        presentadorUnirse.mostrarPantallaUnirse();
        pantallaCrear.dispose();
    }

}
