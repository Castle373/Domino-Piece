/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio_dominodto;

import java.util.List;

/**
 *
 * @author diego
 */
public class TableroDTO {
    private List<FichaTableroDTO> fichasTablero;

    public TableroDTO() {
    }

    public TableroDTO(List<FichaTableroDTO> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    public List<FichaTableroDTO> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(List<FichaTableroDTO> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }
    
}
