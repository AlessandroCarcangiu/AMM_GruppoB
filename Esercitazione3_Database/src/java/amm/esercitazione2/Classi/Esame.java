/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione2.Classi;

/**
 *
 * @author Alessandro
 */
public class Esame {
    /* Attributi */
    private int id;
    private Materia materia;
    private int voto;

    /* Metodi */
    /**
     * @return the materiaId
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materiaId to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
