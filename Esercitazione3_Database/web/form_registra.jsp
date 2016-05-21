<%-- 
    Document   : form_registra
    Created on : 20-apr-2016, 15.21.49
    Author     : Alessandro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>esAMMi - login</title>
        <meta name="keywords" content="AMM esami docente">
        <meta name="description" content="Una pagina per gestire le funzioni dei docenti">
        <link rel="shortcut icon" type="image/x-icon" href="http://spano.sc.unica.it/amm2014/davide/esami14/images/favicon.ico">
        <link href="css/responsive.css" rel="stylesheet" type="text/css" media="screen">
        <style type="text/css"></style>
    </head>    
    <body>
        <div id="page">
            <header>
                <div class="social">
                    <p>Accesso al sistema</p>
                    <ul>
                        <li id="facebook"><a href="http://www.facebook.com">facebook</a></li>
                        <li id="twitter"><a href="https://twitter.com/">twitter</a></li>
                        <li id="linkedin"><a href="http://www.linkedin.com/">linkedin</a></li>
                    </ul>
                </div>
                <!--  header -->
                <div id="header">
                    <div id="logo">
                        <h1>EsAMMi</h1>
                    </div>

                    <!-- select per la versione del menu mobile -->
                    <select class="menu">
                        <option>Menu</option>
                    </select>
                    <!-- tabs -->
                    <div id="menu">
                        <ul>
                            <li><a class="current_page_item" href="#">Home</a></li>
                        </ul>                   
                    </div>
                </div>
            </header>
            <!-- start page -->
            <!--  sidebar 1 -->
            <div id="sidebar1">
                <ul>
                    <li id="categories">
                        <h2 class="icon-title">Navigazione</h2>
                        <ul>
                            <li><a href="#˙">Home</a></li>
                        </ul>
                    </li>
                    <li id="external">
                        <h2 class="icon-title">Link esterni</h2>
                        <ul>
                            <li><a href="http://www.unica.it/">Università di Cagliari</a></li>
                            <li><a href="http://www.unica.it/">Facoltà</a></li>

                        </ul>
                    </li>

                </ul>
            </div>

            <div id="sidebar2">
                <h2 class="icon-title" id="help">Istruzioni</h2>
                <p>
                    Pagina per l'accesso al sistema.
                </p>
            </div>

            <!-- contenuto Form -->
            <div id="content">
                <div class="input-form">
                    <h3>Registra Esame</h3>
                    
                    <form action="Registra" method="GET">
            <!-- Nome, Cognome e Matricola Studente -->
            <div>
                ${alunno.nome} ${alunno.cognome}                 
                <input type="hidden" name="alunnoId" id="id" value="${alunno.id}"/>       
            </div>
            
            <!-- Lista esami e voto -->
            <div>
                <label for="ListaEsami">Lista Esami</label>
                <select name="listaEsami" id="ListaEsami">
                    <c:forEach var="materia" items="${professore.corsiAssegnati}">
                        <option value="${materia.id}">${materia.nome}</option>
                    </c:forEach>
                </select>
                
                <label for="voto">Voto</label>
                <input type="range" min="18" max="31"
                       name="voto" id="voto">
            </div>
            
            <!-- Descrizione -->
            <div>
                <label for="Descrizione">Descrizione</label>
                <textarea name="descrizione" id="Descrizione"
                          cols="40" rows="10" >Descrizione Esame</textarea>
            </div>
            
            <!-- Pulsanti submit e reset -->
            <div>
                <input type="submit" name="submit" value="Invia">
                <input type="reset" name="reset" value="Cancella">
            </div>
            
            
        </form>

                </div>
            </div>

            <div class="clear">
            </div>
            <!--  footer -->
            <footer>
                <div id="footer">
                    <p>
                        Applicazione d'esempio per l'esame di Amministrazione di Sistema
                    </p>


                </div>
                <div class="validator">
                    <p>
                        <a href="http://validator.w3.org/check/referer" class="xhtml" title="Questa pagina contiene HTML valido">
                            <abbr title="eXtensible HyperText Markup Language">HTML</abbr> Valido</a>
                        <a href="http://jigsaw.w3.org/css-validator/check/referer" class="css" title="Questa pagina ha CSS validi">
                            <abbr title="Cascading Style Sheets">CSS</abbr> Valido</a>
                    </p>
                </div>
            </footer>
        </div>
    </body>
</html>

