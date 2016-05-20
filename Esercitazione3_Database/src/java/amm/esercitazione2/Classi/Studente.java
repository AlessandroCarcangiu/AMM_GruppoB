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
    protected int matricola;
    
    /* Costruttore */
    public Studente()
    {
        super();
    }
            
    /* Metodi */

    /**
     * @return the matricola
     */
    public int getMatricola() {
        return matricola;
    }

    /**
     * @param matricola the matricola to set
     */
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
}
