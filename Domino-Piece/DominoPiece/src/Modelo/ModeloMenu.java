/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Socketss.Cliente;
import Socketss.JugadorProtocolo;
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

    public Cliente buscarPartida() {

        try {

            socket = new Socket("localhost", 1234);
            Cliente cliente = new Cliente(socket);

        } catch (IOException ex) {
            return null;
        }

        return cliente;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
