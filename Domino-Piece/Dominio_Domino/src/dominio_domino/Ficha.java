
package dominio_domino;



/**
 *
 * @author IVAN
 */
public class Ficha {
    protected String imagen;
    protected int puntoAbajo;
    protected int puntoArriba;
    protected boolean mula;
    public Ficha(){
        
    }

    public Ficha(String imagen, int puntoAbajo, int puntoArriba) {
        this.imagen = imagen;
        this.puntoAbajo = puntoAbajo;
        this.puntoArriba = puntoArriba;
        this.mula = (puntoAbajo == puntoArriba);
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPuntoAbajo() {
        return puntoAbajo;
    }

    public void setPuntoAbajo(int puntoAbajo) {
        this.puntoAbajo = puntoAbajo;
    }

    public int getPuntoArriba() {
        return puntoArriba;
    }

    public void setPuntoArriba(int puntoArriba) {
        this.puntoArriba = puntoArriba;
    }

    public boolean isMula() {
        return mula;
    }

    public void setMula(boolean mula) {
        this.mula = mula;
    }
    

    
    
}
