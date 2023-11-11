/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socketss;

import Evento.CrearPartidaPF;
import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.RespuestaVotacionPF;
import Evento.VerificarAvatarPF;
import Observer.Observable;
import Observer.Observer;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.Acciones;
import dominio_dominodto.JugadorDTO;

import dominio_dominodto.PartidaDTO;
import dominio_dominodto.RespuestaDTO;
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
public class Cliente {

    private volatile static Cliente instance;
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
                System.out.println("ssss");
                return null;
            }

        }
        return instance;
    }

    public Cliente(Socket socket) {

        j = new JugadorConexion(socket);
        j.start();
    }

    public boolean enviarAlServidor(Object objecto) {
        //Acciones de Crear Partida
        if (objecto instanceof CrearPartidaPF) {
            CrearPartidaPF p = (CrearPartidaPF) objecto;
            try {
                j.enviarAlServidor(p);
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        //Acciones de Crear Jugador
        if (objecto instanceof JugadorPF) {
            JugadorPF p = (JugadorPF) objecto;
            try {
                j.enviarAlServidor(p);
                return true;
            } catch (IOException ex) {
                System.out.println(ex);
                return false;
            }
        }
        //Acciones de Validar avatar
        if (objecto instanceof VerificarAvatarPF) {
            VerificarAvatarPF p = (VerificarAvatarPF) objecto;
            try {
                j.enviarAlServidor(p);
                return true;
            } catch (IOException ex) {
                System.out.println(ex);
                return false;
            }
        }
        //Acciones de RespuestaVotacion
        if (objecto instanceof RespuestaVotacionPF) {
            RespuestaVotacionPF r = (RespuestaVotacionPF) objecto;
            try {
                j.enviarAlServidor(r);
                return true;
            } catch (IOException ex) {
                System.out.println(ex);
                return false;
            }
        }
        //Acciones  de IniciarVotacion
        if (objecto instanceof IniciarVotacionPF) {
            IniciarVotacionPF a = (IniciarVotacionPF) objecto;

            try {
                j.enviarAlServidor(a);
                return true;
            } catch (IOException ex) {
                System.out.println(ex);
                return false;
            }

        }
        return false;
    }

    public void agregarObserver(Observer o) {
        j.agregarObserver(o);
    }

    public void eliminarObserver(Observer o) {
        j.eliminarObserver(o);
    }
}
