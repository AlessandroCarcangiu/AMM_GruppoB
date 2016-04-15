/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione2.Classi;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class Professore extends Utente {
    /* Attributi */
    private ArrayList<Materia> corsiAssegnati = new ArrayList<Materia>(); 
    
    /* Costruttore */
    public Professore()
    {
        super();
    }
    /* Metodi */

    /**
     * @return the materieInsegnate
     */
    public ArrayList<Materia> getCorsiAssegnati() {
        return corsiAssegnati;
    }

    /**
     * @param materieInsegnate the materieInsegnate to set
     */
    public void setCorsiAssegnati(ArrayList<Materia> materieInsegnate) {
        this.corsiAssegnati = materieInsegnate;
    }
}
