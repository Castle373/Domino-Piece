/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

/**
 *
 * @author Marcos T.
 */
public class VerificarAvatarPF<T> implements Evento<T> {

    private String avatar;

    private T jugador;

    public VerificarAvatarPF(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public T getData() {
        return jugador;
    }

    @Override
    public void setData(T jugador) {
        this.jugador = jugador;
    }

}
