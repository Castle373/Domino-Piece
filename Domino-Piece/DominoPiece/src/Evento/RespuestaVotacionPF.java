/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Evento;

/**
 *
 * @author IVAN
 */
public class RespuestaVotacionPF<T> implements Evento<T> {

    private T respuesta;
    private boolean respuestaP;

    public RespuestaVotacionPF(boolean respuestaP) {
        this.respuestaP = respuestaP;
    }

    public boolean isRespuestaP() {
        return respuestaP;
    }

    public void setRespuestaP(boolean respuestaP) {
        this.respuestaP = respuestaP;
    }

    @Override
    public void setData(T respuesta) {
        
      this.respuesta=respuesta;
    }

    @Override
    public T getData() {
        return respuesta;
    }

}
