/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.io.Serializable;

/**
 *
 * @author IVAN
 */
public class RespuestaDTO implements Serializable{
    boolean respuestas;

    public RespuestaDTO(boolean respuestas) {
        this.respuestas = respuestas;
    }

    public RespuestaDTO() {
    }

    public boolean isRespuestas() {
        return respuestas;
    }

    public void setRespuestas(boolean respuestas) {
        this.respuestas = respuestas;
    }
    
}
