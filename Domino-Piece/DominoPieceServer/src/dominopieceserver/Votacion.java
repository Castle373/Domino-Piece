/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

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
    public Votacion() {
    }

    public Votacion(int cantidadNecesaria, Server server) {
        respuestasVotacion= new ArrayList<>();
        this.cantidadNecesaria = cantidadNecesaria;
        this.server = server;
    }
    
     public void respuestaVotacion(boolean respuesta) {
         respuestasVotacion.add(respuesta);
    }

    
    
    @Override
    public void run() {
       boolean verificar = true;
        respuestasVotacion= new ArrayList<>();
        while (verificar) {
            int votaciones = 0;
            for (int i = 0; i < respuestasVotacion.size(); i++) {
                if (respuestasVotacion.get(i) == false) {
                    verificar = false;
//                    sendToAll(i);
                }
                votaciones++;
                if (votaciones == cantidadNecesaria) {
                    verificar = false;
////                    sendToAll(Accii);
                }
                
            }

        }
    }
    
}
