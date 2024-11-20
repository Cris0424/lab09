package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private final List<String> historyList = new LinkedList<>();

    @Override
    public void setNextStringToPrint(final String nextString) {
        if (nextString == null) {
            throw new IllegalArgumentException("null values are not acceptable");
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
        if (this.nextString == null) {
            throw new IllegalStateException();
        } else {
            historyList.add(nextString);
            System.out.println(historyList); // NOPMD
        }
    }

}
