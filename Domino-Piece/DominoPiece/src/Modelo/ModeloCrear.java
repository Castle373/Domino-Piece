/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Pipes.Pipe;
import Pipes.PipeCrearPartida;
import Socketss.Cliente;
import Socketss.JugadorConexion;
import dominio_domino.Partida;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class ModeloCrear {

    private Cliente cliente;
    private Partida partida;
 

    public void crearPartida(int fichasIniciales) {
        Pipe pipa = new PipeCrearPartida();
        pipa.ejecutar(fichasIniciales);
       
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Cliente crearConexion() {

        Cliente cliente = Cliente.getInstance();

        return cliente;
    }

  

}
