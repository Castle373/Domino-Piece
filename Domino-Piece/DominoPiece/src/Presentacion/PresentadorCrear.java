/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloCrear;
import Observer.Observer;
import Vista.VistaCrear;
import Vista.VistaUnirse;
import dominio_domino.Partida;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public class PresentadorCrear implements IPresentadorCrear,Observer{

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
        crearConexion();
        modeloCrear.crearPartida(fichasIniciales);  
        mostrarPantallaUnirse();
        
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
        return modeloCrear.getPartida();
    }

    @Override
    public Socket crearConexion() {
        modeloCrear.crearConexion();
     return crearConexion();
    }

    @Override
    public void update(Object loquesea) {
        if (loquesea instanceof Partida) {
            Partida p= (Partida) loquesea;
            modeloCrear.setPartida(p);
        }
    }
    
}
