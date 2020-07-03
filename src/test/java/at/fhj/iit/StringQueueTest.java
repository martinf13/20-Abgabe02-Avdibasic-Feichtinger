package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

/**
 * Testing the StringQueue class
 *
 * @author Tarik Avdibasic
 * @author Martin Feichtinger
 *
 * @version %I%, %G%
 */
@DisplayName("Testing StringQueue")
class StringQueueTest {
     private StringQueue emptyQueueObject,queueObject;

    /**
     * Inits the StringQueue object for tests
     * The setup phase
     */
    @BeforeEach
    public void setUp(){
        emptyQueueObject = new StringQueue();
        queueObject = new StringQueue(3);
    }

    /**
     * Teardown method to reset/clear the values
     */
    @AfterEach
    public void tearDown(){
        emptyQueueObject = null;
        queueObject = null;
    }

    /**
     * Testing default constructor
     * Object which was created via default constructor should have MaxSize at 0
     */
    @Test
    @DisplayName("Testing default constructor")
    public void testDefaultConstructor(){
        assertEquals(0,emptyQueueObject.getMaxSize());
    }

    /**
     * Testing the constructor
     * Object created with the size of 3 should have 3 as MaxSize
     */
    @Test
    @DisplayName("Testing constructor")
    public void testStringQueueConstructor(){
        assertEquals(3,queueObject.getMaxSize());

    }

    /**
     * Testing offer method
     * As long as maxSize isn't reached it should assertTrue, above it should assertFalse
     * our Maxsize at this test is 3
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOffer() {
        assertTrue(queueObject.offer("testing1"));
        assertTrue(queueObject.offer("testing2"));
        assertTrue(queueObject.offer("testing3"));
        //Now we reached full capacity and next one should assertFalse
        assertFalse(queueObject.offer("I am above max Size I should fail"));
    }


    /**
     * Testing poll method
     * Offering 2 String Objects at the start and checking if we get the first
     * and the second String returned after calling the poll method.
     */
    @Test
    @DisplayName("Testing 'poll' method")
    public void testPoll() {
        queueObject.offer("testing1");
        queueObject.offer("testing2");
        assertEquals("testing1",queueObject.poll());
        assertEquals("testing2",queueObject.poll());
    }

    /**
     * Tests remove method
     * Offering a String object and checking if my assertEquals returns the correct String after
     * using the remove method. Checking if the Exception is thrown by removing now another object.
     * After that I offer 2 more Strings and use the remove method which should
     * return the first String Object. After that I am checking with the poll Method if it returns
     * the last added String Object which is not removed yet.
     */
    @Test
    @DisplayName("Testing remove method")
    public void testRemove() {
        queueObject.offer("testing1");
        assertEquals("testing1", queueObject.remove());
        assertThrows(NoSuchElementException.class, ()-> {queueObject.remove();});
        queueObject.offer("testing2");
        queueObject.offer("testing3");
        assertEquals("testing2", queueObject.remove());
        assertEquals("testing3",queueObject.poll());
    }

    /**
     * Tests peek method.
     * Offering a String Object. Checking if assertEquals is returning the same String after
     * using the peek Method.
     */
    @Test
    @DisplayName("Testing 'peek' method")
    public void testPeek() {
        queueObject.offer("testing1");
        assertEquals("testing1", queueObject.peek());
    }

    /**
     * Tests element method
     * Offering a String Object. Checking if my assertEquals returns the String when calling the
     * element Method. Then checking if a NoSuchElementException is being thrown, when
     * removing the String Object
     */
    @Test
    @DisplayName("Testing element method")
    public void testElement() {
        queueObject.offer("testing1");
        assertEquals("testing1", queueObject.element());
        queueObject.remove();
        assertThrows(NoSuchElementException.class, ()-> {queueObject.element();});
    }

    /**
     * Tests getMaxSize method
     * Checking if AssertEquals returns 3 when calling the getMaxSize Method with the
     * queueObject which has a size of 3
     */
    @Test
    @DisplayName("Testing getMaxSize method")
    public void testGetMaxSize() {
        assertEquals(3, queueObject.getMaxSize());
    }


}