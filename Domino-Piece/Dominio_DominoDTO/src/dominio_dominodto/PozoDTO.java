/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diego
 */
public class PozoDTO implements Serializable{
    private List<FichaDTO> fichasPozo;

    public PozoDTO() {
    }

    public List<FichaDTO> getFichasPozo() {
        return fichasPozo;
    }

    public PozoDTO(List<FichaDTO> fichasPozo) {
        this.fichasPozo = fichasPozo;
    }

    public void setFichasPozo(List<FichaDTO> fichasPozo) {
        this.fichasPozo = fichasPozo;
    }
    
}
