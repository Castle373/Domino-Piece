/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Presentador;

import MVP.Modelo.ModeloCrear;
import MVP.Vista.VistaCrearPartida;
import MVP.Vista.VistaMenu;
import MVP.Vista.VistaUnirse;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public class PresentadorCrear implements IPresentadorCrear {

    private ModeloCrear modeloCrear;
    private IPresentadorUnirse presentadorUnirse;
    private VistaCrearPartida pantallaCrear;
    private IPresentadorMenu menu;

    public PresentadorCrear(IPresentadorMenu menu, IPresentadorUnirse presentadorUnirse) {
        this.menu = menu;
        modeloCrear = new ModeloCrear();
        this.presentadorUnirse = presentadorUnirse;
        pantallaCrear = new VistaCrearPartida(this);
    }

    @Override
    public void mostrarPantalla() {
        pantallaCrear.setVisible(true);

    }

    @Override
    public void crearPartida(int fichasIniciales) {
        crearConexion();
        modeloCrear.crearPartida(fichasIniciales);
        mostrarPantallaUnirse();

    }

    @Override
    public void mostrarPantallaUnirse() {
        presentadorUnirse.mostrarPantallaUnirse();
        pantallaCrear.dispose();
    }

    @Override
    public void crearConexion() {
        modeloCrear.crearConexion();

    }

    @Override
    public void regresarMenu() {
        menu.mostrarMenu();
    }

}
