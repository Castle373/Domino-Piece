/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloMenu;
import Vista.VistaMenu;

/**
 *
 * @author eduar
 */
public class PresentadorMenu implements IPresentadorMenu {
    
    private IPresentadorCrear presentadorCrear;
    private VistaMenu vista;
    private ModeloMenu modelo;
    
    public PresentadorMenu() {
        vista= new VistaMenu(this);
        modelo = new ModeloMenu();
        presentadorCrear = new PresentadorCrear();
    }
    
    
    @Override
    public void crearPartida() {
        presentadorCrear.mostrarPantalla();
        vista.dispose();
    }

    @Override
    public void mostrarMenu() {
  
       vista.setVisible(true);
       
    }
    
    
    
}
