/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Gelato(g)
{
    var gusti = g;
    
    Gelato.prototype.numeroGusti = function()
    {
        return gusti.length;
    };
    
    Gelato.prototype.contieneCrudo = function()
    {
        for(var i = 0; i < gusti.length; i++)
        {
            if(gusti[i] === 'crudo di parma')
                return true;
        }
        
        return false;
    };
}
function verifica(event)
{
    var select = document.getElementById("select").options;
    var gusti = [];
    
    for(var i = 0; i < select.length; i++)
    {
        if(select[i].selected)
        {
            gusti.push(select[i].value);
        }
    }
    
    var gelato = new Gelato(gusti);
    
    // Controlli
    if(gelato.numeroGusti()>3 || gelato.numeroGusti()<1)
        document.getElementById("risultato").innerHTML=
            "Hai selezionato un numero non correto di gusti";
    else if(gelato.contieneCrudo() && gelato.numeroGusti()>1)
        document.getElementById("risultato").innerHTML=
            "Se selezioni il crudo di parma non puoi selezionare\n\
             altri gusti";
    else
        document.getElementById("risultato").innerHTML=
            "Ecco il tuo gelato!";
}

