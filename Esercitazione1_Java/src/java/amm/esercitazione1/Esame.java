/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione1;

/**
 *
 * @author Alessandro
 */
public class Esame {
    private String nomeStudente;
    private String cognomeStudente;
    private int matricola;
    private String nomeEsame;
    private int voto;
    private String nota;

    
    public Esame()
    {
        nomeStudente = "";
        cognomeStudente = "";
        matricola = 0;
        nomeEsame = "";
        voto = 0;
        nota = "";
    }
    
    /**
     * @return the nomeStudente
     */
    public String getNomeStudente() {
        return nomeStudente;
    }

    /**
     * @param nomeStudente the nomeStudente to set
     */
    public void setNomeStudente(String nomeStudente) {
        this.nomeStudente = nomeStudente;
    }

    /**
     * @return the cognomeStudente
     */
    public String getCognomeStudente() {
        return cognomeStudente;
    }

    /**
     * @param cognomeStudente the cognomeStudente to set
     */
    public void setCognomeStudente(String cognomeStudente) {
        this.cognomeStudente = cognomeStudente;
    }

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

    /**
     * @return the nomeEsame
     */
    public String getNomeEsame() {
        return nomeEsame;
    }

    /**
     * @param nomeEsame the nomeEsame to set
     */
    public void setNomeEsame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    /**
     * @return the voto
     */
    public int getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }
           
}
