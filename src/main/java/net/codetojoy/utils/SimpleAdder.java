package net.codetojoy.utils;

import java.util.function.BinaryOperator;

// no-one would ever do this! Simply a set-up for a DeathAdder

public class SimpleAdder implements BinaryOperator<Integer> {
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
