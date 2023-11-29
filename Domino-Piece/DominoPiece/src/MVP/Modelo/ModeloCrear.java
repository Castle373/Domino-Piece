/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Modelo;

import Evento.CrearPartidaPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeCrearPartida;
import PipesAndFilters.Pipes.PipeInicio;
import SocketCliente.Cliente;
import SocketCliente.JugadorConexion;
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

    public void crearPartida(int fichasIniciales) {

        Pipe<CrearPartidaPF> pipa = new PipeInicio();
        CrearPartidaPF c = new CrearPartidaPF(fichasIniciales);
        pipa.ejecutar(c);

    }


    public Cliente crearConexion() {
        Cliente cliente = Cliente.getInstance();
        return cliente;
    }

}
