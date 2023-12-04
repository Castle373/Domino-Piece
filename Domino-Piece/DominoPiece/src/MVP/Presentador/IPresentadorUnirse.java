/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MVP.Presentador;

import dominio_dominodto.JugadorDTO;
import java.awt.Image;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public interface IPresentadorUnirse {

    public void mostrarPantallaUnirse();

    public void crearJugador();

    public void mostrarPantallaJuego();

//    public void enviarJugador();

    public JugadorDTO obtenerJugador();

    public void verificarAvatar(String avatar);

    public void guardarJugadorTemporal(String nombre, String avatar);
    
    public void regresarMenu();

}
