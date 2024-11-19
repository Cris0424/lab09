package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    public void setNextStringToPrint(String nextString);
    /*
     * Un metodo per impostare la prossima stringa da 
     * stampare. I valori nulli non sono accettabili e 
     * deve essere generata un'eccezione.
     */
    public String getNextStringToPrint();
    /*
     * Un metodo per ottenere la 
     * prossima stringa da stampare.
     */
    public List<String> getHistoryStringPrinted();
    /*
     * Un metodo per ottenere la cronologia delle stringhe 
     * stampate (sotto forma di una List di String).
     */
    public void printCurrentString();
    /*
     * Un metodo che stampa la stringa corrente. 
     * Se la stringa corrente non è impostata, 
     * deve essere generata una IllegalStateException.
     */
}   
