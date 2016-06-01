/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#ricerca").keyup(function()
    {  
        // Preleva il valore
        var text = $("#ricerca").val();
       
        $.ajax(
        {
            url: "RegistraAjax",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaAlunni(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaAlunni(listaAlunni)
        {
            // Cancella la lista
            $("#listaAlunni").empty();
            // Per ogni alunno trovato dal database
            for(var alunno in listaAlunni)
            {
                // Crea un nuovo tag li
                var newli = document.createElement("li");
                newli.setAttribute("name", "alunno");
                // testo
                var text = document.createTextNode(listaAlunni[alunno].nome + 
                        " " + listaAlunni[alunno].cognome + " ");
                newli.appendChild(text);
                // Crea link
                var link = document.createElement("a");
                link.setAttribute("href", "Registra?alunnoId="+listaAlunni[alunno].id);
                var registraTxt = document.createTextNode("Registra esame");
                link.appendChild(registraTxt);
                newli.appendChild(link);
                
                // Aggiunge il tag li al tag ul
                $("#listaAlunni").append(newli);
            }
        }
    }); 
});