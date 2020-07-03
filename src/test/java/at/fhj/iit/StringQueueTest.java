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
    public void setup(){
        emptyQueueObject = new StringQueue();
        queueObject = new StringQueue(4);
    }

    /**
     * Teardown method to reset/clear the values
     */
    @AfterEach
    public void tearDown(){
        emptyQueueObject = null;
        queueObject = null;
    }




}