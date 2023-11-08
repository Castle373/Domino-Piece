/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import Observer.Observer;
import Socketss.Cliente;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.net.Socket;

/**
 *
 * @author marco
 */
public class ClienteProxy implements IClienteProxy {

    private Cliente clienteReal;

    public ClienteProxy(Socket socket) {
        clienteReal = new Cliente(socket);
    }

    @Override
    public boolean enviarAlServidor(Object objeto) {
        if (objeto instanceof PartidaDTO || objeto instanceof JugadorDTO) {
            return clienteReal.enviarAlServidor(objeto);
        }
        return false;
    }

    @Override
    public void agregarObserver(Observer observer) {
        clienteReal.agregarObserver(observer);
    }

    @Override
    public void eliminarObserver(Observer observer) {
        clienteReal.eliminarObserver(observer);
    }

}
