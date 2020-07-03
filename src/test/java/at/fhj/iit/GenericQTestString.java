package at.fhj.iit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing the GenericQTestString class with a String classes
 *
 * @author Tarik Avdibasic
 * @author Martin Feichtinger
 *
 * @version %I%, %G%
 */
@DisplayName("Testing GenericQTestString")
class GenericQTestString {
    private GenericQ<String> stringQ, emptyStringQ;



    /**
     * Inits the StringQueue object for tests
     * The setup phase
     */
    @BeforeEach
    public void setUp(){
        stringQ = new GenericQ<>(3);
        emptyStringQ = new GenericQ<>();

    }

    /**
     * Teardown method to reset/clear the values
     */
    @AfterEach
    public void tearDown(){
        stringQ = null;
        emptyStringQ = null;
    }

    /**
     * Testing default constructor
     * By default constructor generated object should return 0 as Size.
     */
    @Test
    @DisplayName("Testing default constructor")
    public void testDefaultConstructor(){
        assertEquals(0, emptyStringQ.getMaxSize());
    }

    /**
     * Testing the constructor
     * String Object created with the size of 3 should have 3 as MaxSize
     */
    @Test
    @DisplayName("Testing constructor")
    public void testStringQueueConstructor(){
        assertEquals(3, stringQ.getMaxSize());
    }

    /**
     * Testing offer method
     * As long as maxSize isn't reached it should assertTrue, above it should assertFalse
     * our Maxsize at this test is 3
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOffer() {
        assertTrue(stringQ.offer("testing1"));
        assertTrue(stringQ.offer("testing2"));
        assertTrue(stringQ.offer("testing3"));
        //Now we reached full capacity and next one should assertFalse
        assertFalse(stringQ.offer("I am over MaxSize"));


    }

    /**
     * Testing poll method
     * Offering 2 string Objects at the start and checking if we get the first
     * and the second string returned after calling the poll method.
     */
    @Test
    @DisplayName("Testing 'poll' method")
    public void testPoll() {
        stringQ.offer("testing1");
        stringQ.offer("testing2");
        assertEquals("testing1", stringQ.poll());
        assertEquals("testing2", stringQ.poll());
    }

    /**
     * Tests remove method
     * Offering a String object and checking if my assertEquals returns the correct string after
     * using the remove method. Checking if the Exception is thrown by removing now another object.
     * After that I offer 2 more string oobject and use the remove method which should
     * return the first char/int Object. After that I am checking with the poll Method if it returns
     * the last added char/int Object which is not removed yet.
     */
    @Test
    @DisplayName("Testing remove method")
    public void testRemove() {
        stringQ.offer("testing1");
        assertEquals("testing1", stringQ.remove());
        assertThrows(NoSuchElementException.class, ()-> {
            stringQ.remove();});
        stringQ.offer("testing2");
        stringQ.offer("testing3");
        assertEquals("testing2", stringQ.remove());
        assertEquals("testing3", stringQ.poll());
    }

    /**
     * Tests peek method.
     * Offering a string Object. Checking if assertEquals is returning the same string after
     * using the peek Method.
     */
    @Test
    @DisplayName("Testing 'peek' method")
    public void testPeek() {
        stringQ.offer("testing1");
        assertEquals("testing1", stringQ.peek());
    }

    /**
     * Tests element method
     * Offering a string Object. Checking if my assertEquals returns the string when calling the
     * element Method. Then checking if a NoSuchElementException is being thrown, when
     * removing the string Object
     */
    @Test
    @DisplayName("Testing element method")
    public void testElement() {
        stringQ.offer("testing1");
        assertEquals("testing1", stringQ.element());
        stringQ.remove();
        assertThrows(NoSuchElementException.class, ()-> {
            stringQ.element();});

    }

    /**
     * Tests getMaxSize method
     * Checking if AssertEquals returns the correct Size when calling the getMaxSize Method with the
     * string Object
     */
    @Test
    @DisplayName("Testing getMaxSize method")
    public void testGetMaxSize() {
        assertEquals(3, stringQ.getMaxSize());

    }

    /**
     * Tests isFull method
     * Checking if the stringQ is full after offereing 2 objects. 2 = 3 should return false.
     * Now adding one more object and checking again with the isFull Method 3 = 3 should return true
     */
    @Test
    @DisplayName("Testing isFull method")
    public void testIsFull(){
        stringQ.offer("testing1");
        stringQ.offer("testing1");
        assertFalse(stringQ.isFull());
        stringQ.offer("testing1");
        assertTrue(stringQ.isFull());
    }
}