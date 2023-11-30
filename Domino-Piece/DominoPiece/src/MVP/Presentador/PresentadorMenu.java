/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Presentador;

import MVP.Modelo.ModeloMenu;
import SocketCliente.Cliente;
import SocketCliente.JugadorConexion;
import MVP.Vista.VistaMenu;
import dominio_dominodto.Acciones;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class PresentadorMenu implements IPresentadorMenu, Observer {

    private IPresentadorCrear presentadorCrear;
    private IPresentadorUnirse presentadorUnirse;
    private VistaMenu vista;
    private ModeloMenu modelo;

    public PresentadorMenu() {
        vista = new VistaMenu(this);
        modelo = new ModeloMenu();
        presentadorUnirse = new PresentadorUnirse(this);
        presentadorCrear = new PresentadorCrear(this, presentadorUnirse);
        Cliente.getInstance().agregarObserver((Observer) this);
    }

    @Override
    public void crearPartida() {
        presentadorCrear.mostrarPantalla();
        vista.dispose();
    }

    @Override
    public void unirsePartida() {
        modelo.buscarPartida();
    }

    @Override
    public void mostrarMenu() {
        vista.setVisible(true);
    }

    @Override
    public void update(Object loquesea) {
        if (loquesea instanceof Acciones) {
            Acciones a = (Acciones) loquesea;
            if (a == Acciones.SI_HAY_PARTIDA) {
                JOptionPane.showMessageDialog(null, "PARTIDA ENCONTRADA");
                presentadorUnirse.mostrarPantallaUnirse();
                vista.dispose();
            } else if (a == Acciones.NO_HAY_PARTIDA) {
                JOptionPane.showMessageDialog(null, "NO HAY PARTIDAS DISPONIBLES");
            }
        }
    }

}
