package at.fhj.iit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing the GenericQTest class with an Integer and Char class
 *
 * @author Tarik Avdibasic
 * @author Martin Feichtinger
 *
 * @version %I%, %G%
 */
@DisplayName("Testing GenericQTestIntChar")
class GenericQTestIntChar {
    private GenericQ<Integer> integerQ, emptyIntegerQ;
    private GenericQ<Character> charQ, emptyCharQ;


    /**
     * Inits the StringQueue object for tests
     * The setup phase
     */
    @BeforeEach
    public void setUp(){
        integerQ = new GenericQ<>(3);
        emptyIntegerQ= new GenericQ<>();
        charQ = new GenericQ<>(2);
        emptyCharQ = new GenericQ<>();
    }

    /**
     * Teardown method to reset/clear the values
     */
    @AfterEach
    public void tearDown(){
        integerQ = null;
        emptyIntegerQ = null;
        charQ = null;
        emptyCharQ = null;
    }

    /**
     * Testing default constructor
     * both by default constructor generated objects should return 0 as Size.
     */
    @Test
    @DisplayName("Testing default constructor")
    public void testDefaultConstructor(){
        assertEquals(0,emptyIntegerQ.getMaxSize());
        assertEquals(0,emptyCharQ.getMaxSize());
    }

    /**
     * Testing the constructor
     * Integer Object created with the size of 3 should have 3 as MaxSize and Char Object created
     * with the size of 2 should have 2 as MaxSize
     */
    @Test
    @DisplayName("Testing constructor")
    public void testStringQueueConstructor(){
        assertEquals(3,integerQ.getMaxSize());
        assertEquals(2, charQ.getMaxSize());

    }

    /**
     * Testing offer method
     * As long as maxSize isn't reached it should assertTrue, above it should assertFalse
     * our Maxsize at this test is 3 for the Integer Object and 2 for the Char Object
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOffer() {
        assertTrue(integerQ.offer(1));
        assertTrue(integerQ.offer(2));
        assertTrue(integerQ.offer(3));
        //Now we reached full capacity and next one should assertFalse
        assertFalse(integerQ.offer(4));

        assertTrue(charQ.offer('a'));
        assertTrue(charQ.offer('b'));
        //Now we reached full capacity and next one should assertFalse
        assertFalse(charQ.offer('c'));

    }

    /**
     * Testing poll method
     * Offering 2 char and integer Objects at the start and checking if we get the first
     * and the second char and integer returned after calling the poll method.
     */
    @Test
    @DisplayName("Testing 'poll' method")
    public void testPoll() {
        integerQ.offer(1);
        integerQ.offer(2);
        assertEquals(1,integerQ.poll());
        assertEquals(2,integerQ.poll());

        charQ.offer('a');
        charQ.offer('b');
        assertEquals('a',charQ.poll());
        assertEquals('b',charQ.poll());
    }

    /**
     * Tests remove method
     * Offering a int/char object and checking if my assertEquals returns the correct char/int after
     * using the remove method. Checking if the Exception is thrown by removing now another object.
     * After that I offer 2 more char/int and use the remove method which should
     * return the first char/int Object. After that I am checking with the poll Method if it returns
     * the last added char/int Object which is not removed yet.
     */
    @Test
    @DisplayName("Testing remove method")
    public void testRemove() {
        integerQ.offer(1);
        assertEquals(1, integerQ.remove());
        assertThrows(NoSuchElementException.class, ()-> {integerQ.remove();});
        integerQ.offer(2);
        integerQ.offer(3);
        assertEquals(2, integerQ.remove());
        assertEquals(3,integerQ.poll());

        charQ.offer('a');
        assertEquals('a', charQ.remove());
        assertThrows(NoSuchElementException.class, ()-> {charQ.remove();});
        charQ.offer('a');
        charQ.offer('b');
        assertEquals('a', charQ.remove());
        assertEquals('b',charQ.poll());
    }

    /**
     * Tests peek method.
     * Offering a int/char Object. Checking if assertEquals is returning the same char/int after
     * using the peek Method.
     */
    @Test
    @DisplayName("Testing 'peek' method")
    public void testPeek() {
        integerQ.offer(1);
        assertEquals(1, integerQ.peek());
        charQ.offer('a');
        assertEquals('a', charQ.peek());
    }

    /**
     * Tests element method
     * Offering a int/char Object. Checking if my assertEquals returns the char/int when calling the
     * element Method. Then checking if a NoSuchElementException is being thrown, when
     * removing the char/int Object
     */
    @Test
    @DisplayName("Testing element method")
    public void testElement() {
        integerQ.offer(1);
        assertEquals(1, integerQ.element());
        integerQ.remove();
        assertThrows(NoSuchElementException.class, ()-> {integerQ.element();});

        charQ.offer('a');
        assertEquals('a', charQ.element());
        charQ.remove();
        assertThrows(NoSuchElementException.class, ()-> {charQ.element();});
    }

    /**
     * Tests getMaxSize method
     * Checking if AssertEquals returns the correct Size when calling the getMaxSize Method with the
     * int/char Object
     */
    @Test
    @DisplayName("Testing getMaxSize method")
    public void testGetMaxSize() {
        assertEquals(3, integerQ.getMaxSize());
        assertEquals(2, charQ.getMaxSize());
    }

    /**
     * Tests isFull method
     * Checking if the charQ is full after offereing 2 objects. 2 = 2 should return true. Then checking
     * if after offering only 1 object in the integerQ if it's full. 1 != 2 so it should return false
     */
    @Test
    @DisplayName("Testing isFull method")
    public void testIsFull(){
        charQ.offer('a');
        charQ.offer('b');
        assertTrue(charQ.isFull());

        integerQ.offer(1);
        assertFalse(integerQ.isFull());
    }


}