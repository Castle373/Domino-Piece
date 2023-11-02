/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socketss;

import Observer.Observable;
import Observer.Observer;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;

import dominio_dominodto.PartidaDTO;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Cliente implements Observable{
    
    private volatile static Cliente instance;
    public List<Observer> listaObservable;
    private JugadorConexion j;

    private Cliente() {
    }

    public static synchronized Cliente getInstance() {
        if (instance == null) {
            Socket socket;
            try {
                socket = new Socket("localhost", 1234);
                 instance = new Cliente(socket);
                 
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return instance;
    }

    public Cliente(Socket socket) {
        listaObservable=new ArrayList<>();
        j = new JugadorConexion(socket);
        j.start();
    }

    public boolean enviarAlServidor(Object objecto) {
        if (objecto instanceof Partida) {
            Partida p = (Partida) objecto; 
            try {
                j.enviarAlServidor(p);
            } catch (IOException ex) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void agregarObserver(Observer o) {
        listaObservable.add(o);
    }

    @Override
    public void eliminarObserver(Observer o) {
         listaObservable.remove(o);
    }

    @Override
    public void notificarObservers(Object o) {
        for (Observer observer : listaObservable) {
            observer.update(o);
        }
    }
}
