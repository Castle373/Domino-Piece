/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloJuego;
import Vista.VistaJuego;

/**
 *
 * @author diego
 */
public class PresentacionJuego implements IPresentacionJuego{

    private ModeloJuego modelo;
    
    private VistaJuego vista;
    public PresentacionJuego(){
        vista= new VistaJuego(this);
        modelo = new ModeloJuego();
    }
    
    @Override
    public void mostrarPantallaJuego() {
      vista.setVisible(true);
    }

    @Override
    public void realizaMovimiento() {
       
    }
    
}
