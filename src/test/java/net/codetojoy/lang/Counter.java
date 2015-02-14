package net.codetojoy.lang;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

// a simple class that increments an integer using threading
// constructs so that we know when it is done

class Counter {
    private AtomicInteger count = new AtomicInteger(0);
    private CountDownLatch latch = new CountDownLatch(1);
    
    public void increment() {
        count.getAndIncrement();
        latch.countDown();
    }
    
    public void await() throws Exception { latch.await(); }
    
    public int get() { return count.get(); }
}
