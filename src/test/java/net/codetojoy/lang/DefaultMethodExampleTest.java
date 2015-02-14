package net.codetojoy.lang;

import static org.junit.Assert.*;
import org.junit.*;

// in Java 8, interfaces can have default implementations !

interface Incrementer {
    default void increment(Counter counter) {
        counter.increment();
    }
}

public class DefaultMethodExampleTest {

    @Test
    public void testDefaultMethod() throws Exception {
        Counter counter = new Counter();
        Incrementer incrementer = new Incrementer () {};
        
        // test
        incrementer.increment(counter);
        
        assertEquals(1, counter.get());
    }
}
