package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    List<String> historyList = new LinkedList<>();

    @Override
    public void setNextStringToPrint(String nextString) {
        this.nextString = nextString;
        if (nextString.equals(null)) {
            throw new NullPointerException("null values are not acceptable");
        }
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getHistoryStringPrinted() {
        for (String listHistoryString : historyList) {
            System.out.println(listHistoryString);
        }
        return historyList;
    }

    @Override
    public void printCurrentString() {
        if (this.nextString.equals(null)) {
            throw new IllegalStateException();
        } else {
            historyList.add(nextString);
            System.out.println(historyList);
        }
    }

}
