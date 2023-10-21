/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_domino;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author IVAN
 */
public class Pozo {

    private List<FichaPozo> fichasPozo = new ArrayList<>();
    //  private Random random = new Random();

    public Pozo() {
        // Inicializa el pozo con 28 fichas

        for (int puntoAbajo = 0; puntoAbajo <= 6; puntoAbajo++) {
            for (int puntoArriba = 0; puntoArriba <= puntoAbajo; puntoArriba++) {
                String imagePath = "/img/Domino" + puntoAbajo + "_" + puntoArriba + ".png";
                
                Image domino = new ImageIcon(getClass().getResource(imagePath)).getImage();
                fichasPozo.add(new FichaPozo(domino, puntoAbajo, puntoArriba));
            }
        }
    }

    public List<FichaPozo> getFichasPozo() {
        return fichasPozo;
    }

    public void setFichasPozo(List<FichaPozo> fichasPozo) {
        this.fichasPozo = fichasPozo;
    }

    public void addFichasPozo(FichaPozo fichaP) {

        fichasPozo.add(fichaP);
    }

    public FichaPozo obtenerFichaAleatoria() {
        if (fichasPozo.isEmpty()) {
            return null; // No quedan fichas en el pozo
        }
        Random random = new Random();
        int indiceAleatorio = random.nextInt(fichasPozo.size());

        FichaPozo fichaAleatoria = fichasPozo.remove(indiceAleatorio); // Elimina la ficha del arreglo
        return fichaAleatoria;
    }

}
