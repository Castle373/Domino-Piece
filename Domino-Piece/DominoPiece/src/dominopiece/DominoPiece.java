/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dominopiece;

import Presentacion.IPresentadorMenu;
import Presentacion.PresentadorMenu;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ivan(LIDER),diego, Adan, Marcos
 */
public class DominoPiece {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        IPresentadorMenu presentador= new PresentadorMenu();
        presentador.mostrarMenu();
       //En la esta Prueba Se puede crear una partida, cuando la creas
    }
    
}
