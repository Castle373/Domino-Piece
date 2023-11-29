/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketCliente;

import Grafico.IFichaGrafica;
import MVP.Presentador.Observable;
import MVP.Presentador.Observer;

import dominio_dominodto.Acciones;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.MovimientoDTO;
import dominio_dominodto.PartidaDTO;
import dominio_dominodto.RobarFichaDTO;
import dominio_dominodto.TerminarDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author diego
 */
public class JugadorConexion extends Thread implements Observable {

    public List<Observer> listaObservable;
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream clientOutput;
    private Object objecto;

    ;

    public JugadorConexion(Socket socket) {
        listaObservable = new ArrayList<>();
        this.clientSocket = socket;

        try {
            in = new ObjectInputStream(clientSocket.getInputStream());
            clientOutput = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                objecto = in.readObject();//escuchando al server
                if (objecto instanceof PartidaDTO) {

                    PartidaDTO partida = (PartidaDTO) objecto;
                    notificarObservers(partida);
                }
                if (objecto instanceof Acciones) {

                    Acciones accion = (Acciones) objecto;
                    notificarObservers(accion);

                }
                if (objecto instanceof JugadorDTO) {

                    JugadorDTO juga = (JugadorDTO) objecto;
                    notificarObservers(juga);

                }
                if (objecto instanceof MovimientoDTO) {

                    MovimientoDTO m = (MovimientoDTO) objecto;
                    notificarObservers(m);

                }
                if (objecto instanceof RobarFichaDTO) {

                    RobarFichaDTO r = (RobarFichaDTO) objecto;
                    notificarObservers(r);
                }
                if (objecto instanceof TerminarDTO) {
                    System.out.println("me llego un terminar");
                    TerminarDTO t = (TerminarDTO) objecto;
                    notificarObservers(t);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones
        }
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
        for (Observer observer : new ArrayList<>(listaObservable)) {
            observer.update(o);
        }
//        for (Observer observer : listaObservable) {
//            
//            observer.update(o);
//        }
    }

}
