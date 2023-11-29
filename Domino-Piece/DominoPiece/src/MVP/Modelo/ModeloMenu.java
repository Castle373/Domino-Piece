/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVP.Modelo;

import Evento.BuscarPartidaPF;
import Evento.MovimientoPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeInicio;
import SocketCliente.Cliente;
import SocketCliente.JugadorConexion;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class ModeloMenu {

    private Cliente cliente;
    private Socket socket;

    public Cliente conexion() {

        Cliente cliente = Cliente.getInstance();

        return cliente;
    }

    public void buscarPartida() {
        Pipe<BuscarPartidaPF> pipa = new PipeInicio();
        BuscarPartidaPF v = new BuscarPartidaPF();
        pipa.ejecutar(v);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
