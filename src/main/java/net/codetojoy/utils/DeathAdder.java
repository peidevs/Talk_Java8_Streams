package net.codetojoy.utils;

import java.util.function.BinaryOperator;

// http://en.wikipedia.org/wiki/Acanthophis

public class DeathAdder implements BinaryOperator<Integer> {
    public Integer apply(Integer a, Integer b) {
        try { Thread.sleep(150); } catch (Exception ex) {}
        return a + b;
    }
}
