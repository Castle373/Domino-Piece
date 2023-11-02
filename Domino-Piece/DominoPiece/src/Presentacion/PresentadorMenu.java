/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloMenu;
import Socketss.JugadorConexion;
import Vista.VistaMenu;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class PresentadorMenu implements IPresentadorMenu {

    private IPresentadorCrear presentadorCrear;
    private IPresentadorUnirse presentadorUnirse;
    private VistaMenu vista;
    private ModeloMenu modelo;

    public PresentadorMenu() {
        vista = new VistaMenu(this);
        modelo = new ModeloMenu();
        presentadorCrear = new PresentadorCrear();
        presentadorUnirse = new PresentadorUnirse();

    }

    @Override
    public void crearPartida() {
        presentadorCrear.mostrarPantalla();
        vista.dispose();
    }

    @Override
    public void unirsePartida() {

        if (modelo.buscarPartida() != null) {
            JOptionPane.showMessageDialog(null, "EncontroPartida");
            presentadorUnirse.mostrarPantallaUnirse();
            vista.dispose();
            
        } else {
            vista.mostrarError("No hay partidas Disponibles");
        }

    }

    @Override
    public void mostrarMenu() {

        vista.setVisible(true);

    }


}
