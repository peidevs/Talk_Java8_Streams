package net.codetojoy.lang;

import static org.junit.Assert.*;
import org.junit.*;

// some basic examples of using lambda expressions 

public class LambdaExampleTest {

    @Test
    public void testRunnable_Classic() throws Exception {
        final Counter counter = new Counter();
        
        Thread thread = new Thread(
            new Runnable () {
                @Override
                public void run () {
                    counter.increment();
                }        
            });
        
        // test
        thread.start();
        
        counter.await();
        assertEquals(1, counter.get());
    }

    @Test
    public void testRunnable_Lambda() throws Exception {
        final Counter counter = new Counter();
        
        Thread thread = new Thread( () -> counter.increment() );
        
        // test
        thread.start();
        
        counter.await();
        assertEquals(1, counter.get());
    }

}
