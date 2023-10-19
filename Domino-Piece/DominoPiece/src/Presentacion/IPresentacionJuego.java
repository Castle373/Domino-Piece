/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion;

import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Partida;

/**
 *
 * @author diego
 */
public interface IPresentacionJuego {
    public void mostrarPantallaJuego();
    public boolean realizaMovimiento(FichaTablero ficha,int lado);
    public void guardarPartida(Partida partida);
    
    public void iniciarPartida();
    
    public void crearPozo();
    public void reparteFichas();
    public void reparteFichasExtras();
    public void verificaFichas();
    public void crearTablero();
    public void robarFicha();
    
}
