package net.codetojoy.utils;

import java.util.function.BinaryOperator;

// no one would do this. Just a setup for a LegacyAdder 

public class SimpleAdder implements BinaryOperator<Integer> {
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
