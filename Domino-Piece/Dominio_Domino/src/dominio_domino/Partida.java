package dominio_domino;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class Partida {

    private int numeroFichas;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Pozo pozo;

    public Partida(int numeroFichas, Tablero tablero, Pozo pozo) {
        this.numeroFichas = numeroFichas;
        this.tablero = tablero;
        this.pozo = pozo;
        this.jugadores = new ArrayList<>();
    }

    public Partida() {
        this.jugadores = new ArrayList<>();
    }

    public Partida(int numeroFichas) {
        this.numeroFichas = numeroFichas;
        this.jugadores = new ArrayList<>();
        if (!validarPartida()) {
            throw new IllegalArgumentException("El número de fichas iniciales debe ser diferente de 0");
        }
    }

    public int getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(int numeroFichas) {
        this.numeroFichas = numeroFichas;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void addJugador(Jugador jugador) {

        jugadores.add(jugador);
    }

    private boolean validarPartida() {
        return getNumeroFichas() != 0;
    }
}
