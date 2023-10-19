/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Modelo.ModeloJuego;
import Vista.VistaJuego;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Partida;

/**
 *
 * @author diego
 */
public class PresentadorJuego implements IPresentacionJuego{

    private ModeloJuego modelo;
    
    private VistaJuego vista;
    public PresentadorJuego(){
        vista= new VistaJuego(this);
        modelo = new ModeloJuego();
    }
    
    @Override
    public void mostrarPantallaJuego() {
      vista.setVisible(true);
    }

    @Override
    public boolean realizaMovimiento(FichaTablero ficha,int lado) {
       return modelo.validaMovimiento(ficha, lado);
    }

    @Override
    public void guardarPartida(Partida partida) {
       modelo.guardarPartida(partida);
    }

    @Override
    public void iniciarPartida() {
       crearPozo();
       crearTablero();
    }

    @Override
    public void crearPozo() {
        modelo.crearPozo();
    }

    @Override
    public void reparteFichas() {
        modelo.reparteFichas();
    }

    @Override
    public void reparteFichasExtras() {
       modelo.reparteFichasExtras();
    }

    @Override
    public void verificaFichas() {
       modelo.verificaFichas();
    }

    @Override
    public void crearTablero() {
       modelo.crearTablero();
    }

    @Override
    public void robarFicha() {
        FichaPozo f = modelo.robarFicha();
        if (f!=null) {
        vista.agregarFichaMano(f);
        }else{
        vista.mostrarMensajeError("No hay Fichas en el pozo");
        }
        
    }
   
    
}
