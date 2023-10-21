package dominio_domino;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class Jugador {

    private String nombre;
    private Image avatar;
    private List<FichaJugador> fichasJugador;

    public Jugador(String nombre, Image avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.fichasJugador = new ArrayList<>();
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public List<FichaJugador> getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(List<FichaJugador> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

    public void addFichasJugador(FichaJugador fichaJ) {

        fichasJugador.add(fichaJ);
    }

    public boolean removerFichaJugador(FichaJugador fichaJ) {

        return fichasJugador.remove(fichaJ);
    }
}
