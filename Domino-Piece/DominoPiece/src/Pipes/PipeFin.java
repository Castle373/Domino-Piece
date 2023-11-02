/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Socketss.Cliente;
import dominio_domino.Partida;

/**
 *
 * @author diego
 */
public class PipeFin implements Pipe {

    @Override
    public void ejecutar(Object s) {
        Cliente cliente = Cliente.getInstance();
        cliente.enviarAlServidor(s);

    }

}
