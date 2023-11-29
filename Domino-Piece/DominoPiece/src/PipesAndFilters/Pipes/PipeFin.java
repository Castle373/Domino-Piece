/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import Evento.Evento;
import SocketCliente.Cliente;

/**
 *
 * @author diego
 */
public class PipeFin<T extends Evento> implements Pipe<T> {

    @Override
    public void ejecutar(T resultado) {
        
        Cliente cliente = Cliente.getInstance();
        
        cliente.enviarAlServidor(resultado);
    }

}
