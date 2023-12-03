/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.JugadorPF;
import Evento.VerificarAvatarPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import dominio_dominodto.JugadorDTO;
import java.util.UUID;

/**
 *
 * @author Marcos T.
 */
public class FiltroVerificarAvatar<T> implements Filtro<T> {

    private Pipe pipe;

    @Override
    public void ejecutar(T avatar) {
        JugadorDTO j = new JugadorDTO();
        if (avatar instanceof VerificarAvatarPF) {
            VerificarAvatarPF vaf = (VerificarAvatarPF) avatar;
            j.setAvatar(vaf.getAvatar());
            ((VerificarAvatarPF) avatar).setData(j);
        }
       
        pipe.ejecutar(avatar);
    }

    @Override
    public Pipe getPipe() {
        return pipe;
    }

    @Override
    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }
}
