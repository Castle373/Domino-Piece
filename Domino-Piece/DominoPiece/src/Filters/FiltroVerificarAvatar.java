/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.JugadorPF;
import Evento.VerificarAvatarPF;
import Pipes.Pipe;
import Pipes.PipeFin;
import dominio_dominodto.JugadorDTO;
import java.util.UUID;

/**
 *
 * @author Marcos T.
 */
public class FiltroVerificarAvatar<T> implements Filtro<T> {

    @Override
    public void ejecutar(T avatar) {
        JugadorDTO j = new JugadorDTO();
        if (avatar instanceof VerificarAvatarPF) {
            VerificarAvatarPF vaf = (VerificarAvatarPF) avatar;
            j.setAvatar(vaf.getAvatar());
            ((VerificarAvatarPF) avatar).setData(j);
        }
        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(avatar);
    }

}
