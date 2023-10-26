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
    private int turno;

    public Partida(int numeroFichas, Tablero tablero, Pozo pozo) {
        this.numeroFichas = numeroFichas;
        this.tablero = tablero;
        this.pozo = pozo;
        this.jugadores = new ArrayList<>();
        this.turno = 0;
    }

    public Partida() {
        this.turno = 0;
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> determinarTurnos() {
        FichaJugador mulaMasGrande = null;
        Jugador jugadorConMulaMasGrande = null;
        for (Jugador jugador : jugadores) {
            for (FichaJugador f : jugador.getFichasJugador()) {
                if (f.isMula()) {
                    if (mulaMasGrande == null || f.getPuntoArriba() > mulaMasGrande.getPuntoArriba()) {
                        mulaMasGrande = f;
                        jugadorConMulaMasGrande = jugador;
                    }
                }
            }
        }
        jugadores.remove(jugadorConMulaMasGrande);
        jugadores.add(0, jugadorConMulaMasGrande);
        return jugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void pasarTurno() {
        turno++;
        if (turno > (jugadores.size() - 1)) {
            turno = 0;
        }
    }

    public Jugador jugadorTurno() {
        return jugadores.get(turno);
    }

    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
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

    public void reparteFichas() {
        for (int i = 0; i < this.getNumeroFichas(); i++) {
            for (Jugador jugador : this.getJugadores()) {
                FichaPozo f = this.getPozo().obtenerFichaAleatoria();
                jugador.addFichasJugador(new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba()));
            }
        }
        while (!verificaFichas()) {
            reparteFichasExtras();
        }
    }

    public void reparteFichasExtras() {
        for (int i = 0; i < 1; i++) {
            for (Jugador jugador : this.getJugadores()) {
                FichaPozo f = this.getPozo().obtenerFichaAleatoria();
                jugador.addFichasJugador(new FichaJugador(f.getImagen(), f.getPuntoAbajo(), f.getPuntoArriba()));
            }
        }
    }

    public boolean verificaFichas() {
        for (Jugador jugador : this.getJugadores()) {
            for (FichaJugador f : jugador.getFichasJugador()) {
                if (f.isMula()) {
                    return true;
                }
            }
        }
        return false;
    }
}
