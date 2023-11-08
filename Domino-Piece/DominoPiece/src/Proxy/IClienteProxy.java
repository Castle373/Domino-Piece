/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proxy;

import Observer.Observer;

/**
 *
 * @author marco
 */
public interface IClienteProxy {

    public boolean enviarAlServidor(Object objeto);

    public void agregarObserver(Observer observer);

    public void eliminarObserver(Observer observer);
}
