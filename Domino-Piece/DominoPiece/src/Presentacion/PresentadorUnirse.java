/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Vista.vistaUnirse;

/**
 *
 * @author marcos
 */
public class PresentadorUnirse implements IPresentadorUnirse {

    @Override
    public void mostrarPantallaUnirse() {
        vistaUnirse pantallaUnirse = new vistaUnirse();
        pantallaUnirse.setVisible(true);
    }

}
