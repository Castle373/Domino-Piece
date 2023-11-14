/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Socketss.Cliente;
import dominio_domino.Ficha;
import dominio_domino.Jugador;
import dominio_dominodto.FichaDTO;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       Jugador jugadorNormal = new Jugador("Diego", "avatar1");
       
       
       JugadorDTO jugadordto = new JugadorDTO(jugadorNormal.getNombre(), jugadorNormal.getAvatar());
       


    // Se pasa al server para que me agrega a la partida
        Cliente.getInstance().enviarAlServidor(jugadordto);
        
        
    }
    
}
