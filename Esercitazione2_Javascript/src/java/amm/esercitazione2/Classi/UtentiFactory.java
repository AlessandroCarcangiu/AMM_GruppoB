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
    public Utente getUtente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager
                    .getConnection(connectionString, 
                            "alessandrocarcangiu",
                            "0000");
            // sql command
            String query = "select * from professore where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Professore professore = new Professore();
                professore.id = set.getInt("id");
                professore.nome = set.getString("nome");
                professore.cognome = set.getString("cognome");
                professore.username = set.getString("username");
                professore.password = set.getString("password");
                professore.orario_ricevimento = set.
                        getString("orario_ricevimento");
                // nuova query, corsiAssegnati
                query = "select materia.id, materia.nome from materia "
                        + "join materie_assegnate "
                        + "on materia.id = materie_assegnate.idMateria "
                        + "where materie_assegnate.idProfessore="+professore.id;
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Materia m = new Materia();
                    m.setId(res2.getInt("id"));
                    m.setNome(res2.getString("nome"));
                    professore.corsiAssegnati.add(m);
                }
                st.close();
                stmt.close();
                conn.close();
                
                return professore;
            }
            
            // Studente
            // sql command
            query = "select * from studente where "
                    + "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            if(set.next())
            {
                Studente studente = new Studente();
                studente.id = set.getInt("id");
                studente.nome = set.getString("nome");
                studente.cognome = set.getString("cognome");
                studente.username = set.getString("username");
                studente.password = set.getString("password");
                studente.matricola = set.
                        getInt("matricola");
                stmt.close();
                conn.close();
                return studente;
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            
        }
        return null;
    }
            
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
    // Restituisce la lista di tutti gli studenti il cui nome e cognome contiene la stringa in input
    public ArrayList<Studente> getStudenti(String text)
    {
        ArrayList<Studente> lista = new ArrayList<Studente>();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            String query = "select studente.nome, studente.cognome, studente.id " +
                           "from studente " + 
                           "where studente.nome LIKE ? OR studente.cognome LIKE ?";         
            PreparedStatement stmt = conn.prepareStatement(query);
            // Assegna dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            stmt.setString(2, text);
            ResultSet res = stmt.executeQuery();
            
            while(res.next())
            {
                Studente current = new Studente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                lista.add(current);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {}
        
        return lista;
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
    
    public void registrazioneEsame(int idStudente, int idMateria,
            int voto, String descrizione) throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                UtentiFactory.getInstance().getConnectionString(),
                "alessandrocarcangiu",
                "0000");
        
        PreparedStatement updatePianodiStudi = null;
        PreparedStatement updateEsami_superati = null;
        
        // Sql 
        String deletePianodiStudi = "delete from pianodistudi "
                + "where idMateria = ? "
                + "and idStudente = ?";
        String insertEsami_Superati = "insert into esami_superati "
                + "(idMateria, idStudente, voto, descrizione) "
                + "values (?,?,?,?)";
        
        try
        {
           conn.setAutoCommit(false);
           updatePianodiStudi = conn.
                   prepareStatement(deletePianodiStudi);
           updateEsami_superati = conn.
                   prepareStatement(insertEsami_Superati);
           
           // PianodiStudi
           updatePianodiStudi.setInt(1, idMateria);
           updatePianodiStudi.setInt(2, idStudente);
           // Esami_superati
           updateEsami_superati.setInt(1, idMateria);
           updateEsami_superati.setInt(2, idStudente);
           updateEsami_superati.setInt(3, voto);
           updateEsami_superati.setString(4, descrizione);
           
           int c1 = updatePianodiStudi.executeUpdate();
           int c2 = updateEsami_superati.executeUpdate();
           
           if(c1 != 1 || c2 != 1)
               conn.rollback();
           
           conn.commit();           
        }catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(updatePianodiStudi != null)
                updatePianodiStudi.close();
            if(updateEsami_superati != null)
                updateEsami_superati.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
