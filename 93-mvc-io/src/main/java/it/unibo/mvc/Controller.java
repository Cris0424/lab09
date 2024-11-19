package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    public void setNextStringToPrint(String nextString);

    public String getNextStringToPrint();

    public List<String> getHistoryStringPrinted();

    public void printCurrentString();
}
