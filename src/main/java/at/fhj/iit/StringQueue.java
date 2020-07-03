package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

/**
 * this Class represents a Queue of Strings
 *
 * @author: Martin Feichtinger
 * @author: Tarik Avdibasic
 *
 * @version %I%, %G%
 */

public class StringQueue implements IQueue {

    private List<String> elements = new ArrayList<String>();
    //removed declaration for maxSize as it should not be preset and we are declaring the size in the normal constructor
    private int maxSize;

    //default constructor was missing
    public StringQueue() {
    }
    //maxSize = maxSize should be this.maxSize = maxsize; small (s) otherwise it doesn't change the maxSize variable
    public StringQueue(int maxsize) {
        this.maxSize = maxsize;
    }

    @Override
    public boolean offer(String obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }
    // the elements.size can never be 0 therefore we changed from == to >
    @Override
    public String poll() {
        String element = peek();

        if (elements.size() > 0) {
            elements.remove(0);
        }

        return element;
    }
    // String element is being declared to poll() and then immediately to "". Removed the second declaration as it makes no sense
    @Override
    public String remove() {
        String element = poll();
        // element = "";
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public String peek() {
        String element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    @Override
    public String element() {
        String element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    public int getMaxSize() {
        return maxSize;
    }
}