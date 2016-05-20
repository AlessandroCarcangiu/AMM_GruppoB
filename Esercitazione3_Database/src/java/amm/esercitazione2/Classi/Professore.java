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
    protected String orario_ricevimento;
    protected ArrayList<Materia> corsiAssegnati = new ArrayList<Materia>(); 
    
    /* Costruttore */
    public Professore()
    {
        super();
    }
    /* Metodi */

    /**
     * @return the orario_ricevimento
     */
    public String getOrario_ricevimento() {
        return orario_ricevimento;
    }

    /**
     * @param orario_ricevimento the orario_ricevimento to set
     */
    public void setOrario_ricevimento(String orario_ricevimento) {
        this.orario_ricevimento = orario_ricevimento;
    }

    /**
     * @return the corsiAssegnati
     */
    public ArrayList<Materia> getCorsiAssegnati() {
        return corsiAssegnati;
    }

    /**
     * @param corsiAssegnati the corsiAssegnati to set
     */
    public void setCorsiAssegnati(ArrayList<Materia> corsiAssegnati) {
        this.corsiAssegnati = corsiAssegnati;
    }
}
