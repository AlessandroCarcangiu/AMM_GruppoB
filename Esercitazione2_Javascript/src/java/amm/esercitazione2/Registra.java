/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione2;

import amm.esercitazione2.Classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alessandro
 */
@WebServlet(name = "Registra", urlPatterns = {"/Registra"})
public class Registra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("alunnoId"));
        request.setAttribute("alunno", UtentiFactory.getInstance().getStudente(id));
        request.setAttribute("professore", UtentiFactory.getInstance()
                .getProfessore((int)session.getAttribute("id")));
        
        // Registrazione esame (solo se l'utente ha premuto il tasto 'submit'
        if(request.getParameter("submit") != null)
        {
            // Preleva i dati da registrare
            int idStudente = Integer.parseInt(request.getParameter("alunnoId"));
            int idMateria = Integer.parseInt(request.getParameter("listaEsami"));
            int voto = Integer.parseInt(request.getParameter("voto"));;
            String descrizione = request.getParameter("descrizione");
            
            try
            {
                UtentiFactory.getInstance().registrazioneEsame(idStudente, idMateria, 
                        voto, descrizione);
            }catch(SQLException e)
            {}
        }              
        
        request.getRequestDispatcher("form_registra.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
