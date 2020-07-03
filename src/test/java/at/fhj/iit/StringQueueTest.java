package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

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
        queueObject = new StringQueue(2);
        queueObject.offer("Test 1");
        queueObject.offer("Test 2");
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
     */
    @Test
    @DisplayName("Testing default constructor")
    public void testDefaultConstructor(){
        assertEquals(5,emptyQueueObject.getMaxSize());
    }

    /**
     * Testing the constructor
     */
    @Test
    @DisplayName("Testing constructor")
    public void testStringQueueConstructor(){
        assertEquals(emptyQueueObject.getMaxSize(), 2);
        assertEquals(queueObject.getMaxSize(), 3);

    }

}