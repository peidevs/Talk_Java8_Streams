package net.codetojoy.utils;

import java.util.function.BinaryOperator;

public class LegacyAdder implements BinaryOperator<Integer> {
    public Integer apply(Integer a, Integer b) {
        // gah!!! 
        try { Thread.sleep(150); } catch (Exception ex) {}

        return a + b;
    }
}
