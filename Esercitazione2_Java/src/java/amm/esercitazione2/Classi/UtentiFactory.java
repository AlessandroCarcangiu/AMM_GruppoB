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
public class UtentiFactory {

    private static UtentiFactory singleton;

    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private UtentiFactory() {

    }

    public ArrayList<Utente> getUserList() {
        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
        // Materie         
        Materia materia_1 = new Materia();
        materia_1.setNome("AMM");
        Materia materia_2 = new Materia();
        materia_2.setNome("IUM");
        Materia materia_3 = new Materia();
        materia_3.setNome("PR1");

        // Professore 1
        Professore prof_1 = new Professore();
        prof_1.setUsername("SpanoDavide");
        prof_1.setPassword("0");
        prof_1.setNome("Davide");
        prof_1.setCognome("Spano");
        prof_1.setId(0);
        ArrayList<Materia> arrayMaterieProf_1 = new ArrayList<Materia>();
        arrayMaterieProf_1.add(materia_1);
        arrayMaterieProf_1.add(materia_2);
        prof_1.setCorsiAssegnati(arrayMaterieProf_1);
        listaUtenti.add(prof_1);

        // Professore 2
        Professore prof_2 = new Professore();
        prof_2.setUsername("ScateniRiccardo");
        prof_2.setPassword("1");
        prof_2.setNome("Riccardo");
        prof_2.setCognome("Scateni");
        prof_2.setId(1);
        ArrayList<Materia> arrayMaterieProf_2 = new ArrayList<Materia>();
        arrayMaterieProf_2.add(materia_3);
        prof_2.setCorsiAssegnati(arrayMaterieProf_2);
        listaUtenti.add(prof_2);

        // Studente 1
        Studente studente_1 = new Studente();
        studente_1.setUsername("CarcangiuAlessandro");
        studente_1.setPassword("2");
        studente_1.setNome("Alessandro");
        studente_1.setCognome("Carcangiu");
        studente_1.setId(2);
        // Esami
        Esame esame_1 = new Esame();
        //esame_1.setMateriaId("AMM");
        esame_1.setVoto(28);
        Esame esame_2 = new Esame();
        //esame_2.setMateriaId("IUM");
        esame_2.setVoto(30);
        ArrayList<Esame> arrayEsamiStudente_1 = new ArrayList<Esame>();
        arrayEsamiStudente_1.add(esame_1);
        arrayEsamiStudente_1.add(esame_2);
        studente_1.setEsamiSuperati(arrayEsamiStudente_1);
        listaUtenti.add(studente_1);

        // Studente 2
        Studente studente_2 = new Studente();
        studente_2.setUsername("CherchiGianmarco");
        studente_2.setPassword("3");
        studente_2.setNome("Gianmarco");
        studente_2.setCognome("Cherchi");
        studente_2.setId(3);
        // Esami
        Esame esame_3 = new Esame();
        //esame_3.setMateriaId("PR1");
        esame_3.setVoto(30);
        Esame esame_4 = new Esame();
        //esame_4.setMateriaId("IUM");
        esame_4.setVoto(30);
        ArrayList<Esame> arrayEsamiStudente_2 = new ArrayList<Esame>();
        arrayEsamiStudente_2.add(esame_3);
        arrayEsamiStudente_2.add(esame_4);
        studente_2.setEsamiSuperati(arrayEsamiStudente_2);
        
        return listaUtenti;
    }
}
