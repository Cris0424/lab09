package it.unibo.mvc;

import java.io.IOException;
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
    public void setNextStringToPrint(String nextString){
        if (nextString.equals(null)) {
            throw new NullPointerException("null values are not acceptable");
        } else {
            this.nextString = nextString;
        }
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getHistoryStringPrinted() {
        return List.copyOf(historyList);
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
