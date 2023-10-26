/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socketss;

import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.NumeroFichasDTO;
import dominio_dominodto.PartidaDTO;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class Cliente {
    private JugadorProtocolo j ;

    public Cliente(Socket socket) {
         j = new JugadorProtocolo(socket);
          j.start();
    }
    public boolean enviarAlServidor(Object objecto){
        try {
            if (objecto instanceof Integer) {
                Integer fichas =(Integer)objecto; 
                NumeroFichasDTO p = new NumeroFichasDTO(fichas);
                j.enviarAlServidor(p);
            }
            if (objecto instanceof Jugador) {
                Jugador jugador =(Jugador)objecto; 
                JugadorDTO p = new JugadorDTO(jugador.getNombre(),jugador.getAvatar());
                j.enviarAlServidor(p);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
