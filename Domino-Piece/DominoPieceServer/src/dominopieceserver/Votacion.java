/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import dominio_dominodto.Acciones;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class Votacion extends Thread {

    private List<Boolean> respuestasVotacion;
    private int cantidadNecesaria;
    private Server server;
    private volatile static Votacion instance;

    public Votacion() {
    }

    public Votacion(int cantidadNecesaria, Server server) {
        respuestasVotacion = new ArrayList<>();
        this.cantidadNecesaria = cantidadNecesaria;
        this.server = server;

    }

    public static void setInstance(Votacion instance) {
        Votacion.instance = instance;
    }

    public synchronized void respuestaVotacion(boolean respuesta) {
        respuestasVotacion.add(respuesta);
        this.notifyAll();

    }

    public static synchronized Votacion getInstance() {

        if (instance == null) {

            instance = new Votacion();
        }
        return instance;
    }

    @Override
    public void run() {

        boolean verificar = true;
        respuestasVotacion = new ArrayList<>();
        while (verificar) {
            int votaciones = 0;

            System.out.printf("");
            for (int i = 0; i < respuestasVotacion.size(); i++) {
                votaciones++;

                if (respuestasVotacion.get(i) == false) {
                    verificar = false;
                    server.sendToAll(Acciones.NO_INICIAR);

                } else if (votaciones == cantidadNecesaria) {
                    verificar = false;
                    server.sendToAll(Acciones.INICIAR_PARTIDA);

                }

            }

        }

    }

}
