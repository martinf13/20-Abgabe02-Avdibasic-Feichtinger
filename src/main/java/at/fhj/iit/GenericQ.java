package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The class GenericQ is almost identical to StringQueue class, it just showing us the
 * other implementation. The StringQueue class works just with String objects, the
 * GenericQ class works with different objects types.
 *
 * @author Tarik Avdibasic
 * @author Martin Feichtinger
 * @version %I%, %G%
 *
 */
public class GenericQ<T> implements IQueue<T>{

    /**
     * List contains queue elements
     */
    private List<T> elements = new ArrayList<>();


    /**
     * maxSize(Integer value) defines the maximum size of elements
     */
    private int maxSize;

    /**
     * GenericQ default constructor
     *
     */
    public GenericQ() {
    }

    /**
     * GenericQ constructor
     *
     * @param maxSize parameter for setting the maximum size
     */
    public GenericQ(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * maxSize getter method
     *
     * @return returns back the maximum size
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * offer method is adding the objects to the queue
     * @param obj parameter value of boolean offer method
     * @return return false if object can not be added, true if the object can be added
     */
    @Override
    public boolean offer(T obj) {
        if (elements.size() < maxSize){
            elements.add(obj);
        } else {
            return false;
        }
        return true;

    }


    /**
     * Returns the head (first) element and also deletes it. That is, we cannot get it again.
     * If no element exists (when queue is empty), the method returns null.
     *
     * @return first element in queue if it exists otherwise the queue is empty
     */
    @Override
    public T poll() {
        T element = peek();
        if (element != null){
            elements.remove(0);
        }else {
            return null;
        }
        return element;
    }

    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     *
     * @return first element in queue if it exists, otherwise throws Exception
     * @throws NoSuchElementException if the element equal null is
     */
    @Override
    public T remove() {
        T element = poll();
        if (element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     *
     * @return first element in queue if it exists otherwise the queue is empty and null would be returned
     */
    @Override
    public T peek() {
        T element;
        if(elements.size() > 0){
            element = elements.get(0);
        }else {
            return null;
        }
        return element;
    }



    /**
     * It works similar to peek() but with a small difference (returns but does not delete the element).
     * It throws NoSuchElementException when the queue is empty.
     *
     * @return first element of queue if exists otherwise throws Exception if element equal null is
     * @throws NoSuchElementException if element equal null is
     */
    @Override
    public T element() {
        T element = peek();
        if(element == null){
            throw new NoSuchElementException("there's no element any more!");
        }
        return element;
    }

    public boolean isFull(){
        if(elements.size() == maxSize) return true;
        else return false;
    }


}
