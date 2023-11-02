/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion;

import dominio_domino.Partida;
import java.net.Socket;

/**
 *
 * @author marcos
 */
public interface IPresentadorCrear {
    public void mostrarPantalla();
    public void crearPartida(int fichasIniciales);
    public void mostrarPantallaUnirse();
    public Partida obtenerPartida();
    public void enviarPartida();
    public void crearConexion();
}
