package net.codetojoy.utils;

import java.util.function.BinaryOperator;

public class SimpleAdder implements BinaryOperator<Integer> {
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
