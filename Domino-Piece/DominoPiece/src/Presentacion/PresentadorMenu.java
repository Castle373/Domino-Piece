/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

/**
 *
 * @author eduar
 */
public class PresentadorMenu implements IPresentadorMenu {
    
    private IPresentadorCrear presentadorCrear;
    
    public PresentadorMenu() {
        presentadorCrear = new PresentadorCrear();
    }
    
    
    @Override
    public void crearPartida() {
        presentadorCrear.mostrarPantalla();
    }
    
    
    
}
