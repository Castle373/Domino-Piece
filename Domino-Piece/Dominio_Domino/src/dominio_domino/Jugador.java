package dominio_domino;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author IVAN
 */
public class Jugador {

    private UUID id;
    private String nombre;
    private String avatar;
    private List<FichaJugador> fichasJugador;

    public Jugador(String nombre, String avatar) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {

        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        return Objects.equals(this.id, other.id);
    }

}
