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
public class Studente extends Utente{
    /* Attributi */
    private ArrayList<Esame> esamiSuperati = new ArrayList<Esame>();
    
    /* Costruttore */
    public Studente()
    {
        super();
    }
            
    /* Metodi */
    /**
     * @return the esamiSuperati
     */
    public ArrayList<Esame> getEsamiSuperati() {
        return esamiSuperati;
    }

    /**
     * @param esamiSuperati the esamiSuperati to set
     */
    public void setEsamiSuperati(ArrayList<Esame> esamiSuperati) {
        this.esamiSuperati = esamiSuperati;
    }
}
