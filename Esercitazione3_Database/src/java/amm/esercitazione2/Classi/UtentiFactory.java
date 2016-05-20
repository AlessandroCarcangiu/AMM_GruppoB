/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione2.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class UtentiFactory {
    // Attributi
    // Singleton
    private static UtentiFactory singleton;
    String connectionString; 
    
    // E' l'unico metodo che restituisce il singleton. Provvede a inizializzarlo alla prima chiamata.
    // Nelle successive chiamate lo restituisce e basta.
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    /* Costruttore */
    private UtentiFactory() {

    }
    
    /* Metodi */            
    // Professore
    // Dato un id restituisce il relativo professore (se esiste un professore con quell'id, altrimenti
    // restituisce null).
    public Utente getProfessore(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            // Query
            String query = "select * from professore "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Professore current = new Professore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setOrario_ricevimento(res.getString("orario_ricevimento"));
                // Corsi assegnati 
                query = "select materia.id, materia.nome from materia "
                        + "join materie_assegnate "
                        + "on materia.id = materie_assegnate.idMateria "
                        + "where materie_assegnate.idProfessore="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Materia m = new Materia();
                    m.setId(res2.getInt("id"));
                    m.setNome(res2.getString("nome"));
                    current.corsiAssegnati.add(m);
                }           
                
                st.close();
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // Restituisce la lista di tutti i professori
    public ArrayList<Professore> getProfessori()
    {
        ArrayList<Professore> listaProfessori = new ArrayList<Professore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "professore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Professore current = new Professore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setOrario_ricevimento(set.getString("orario_ricevimento"));
                listaProfessori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaProfessori;
    }
    
    // Studenti
    // Restituisce la lista di tutti gli studenti
    public ArrayList<Studente> getStudenti()
    {
        ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from studente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Studente current = new Studente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setMatricola(set.getInt("matricola"));
                listaStudenti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaStudenti;
    }
    
    // Dato un id restituisce il relativo studente (se esiste uno studente con quell'id, altrimenti
    // restituisce null).
    public Utente getStudente(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            String query = "select * from studente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Studente current = new Studente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setMatricola(res.getInt("matricola"));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    // Materia
    // Restituisce la lista di tutte le materie
    public ArrayList<Materia> getMaterie()
    {
        ArrayList<Materia> lista = new ArrayList<Materia>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "materia'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Materia current = new Materia();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                lista.add(current);
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
    }
    // Dato un id restituisce la relativa materia
    public Materia getMateria(String nome)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            String query = "select * from materia "
            + "where nome = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, nome);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Materia current = new Materia();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
   
                stmt.close();
                conn.close();
                return current;
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
