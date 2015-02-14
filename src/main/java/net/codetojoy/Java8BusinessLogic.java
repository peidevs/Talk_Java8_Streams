package net.codetojoy;

import java.util.*;
import net.codetojoy.utils.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import java.util.stream.Collectors;
import java.util.Comparator;

import java.util.function.*;
import java.util.stream.Stream;

public class Java8BusinessLogic implements BusinessLogic {

    /* 
        tight
     */
    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                      .filter(d -> d.getPrice() >= priceThreshold)
                      .sorted(comparing(Donut::getPrice).reversed())
                      .map(Donut::getName)
                      .limit(numDonuts)
                      .collect(toList());
    }

    /* 
        expanded

    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter(new Predicate<Donut> () {
                                 public boolean test(Donut d) {
                                     return d.getPrice() >= priceThreshold;
                                 }
                             })
                     .sorted(Comparator.comparing(Donut::getPrice).reversed())
                     .map(new Function<Donut,String> () {
                                 public String apply(Donut d) {
                                     return d.getName();
                                 }
                          })
                     .limit(numDonuts)
                     .collect(Collectors.toList());
    }
    */

    private BinaryOperator<Integer> adder = new SimpleAdder();
        
    public Integer sumPrice(List<Donut> donuts) {
        return donuts.stream()
                       .map(Donut::getPrice)
                       .reduce(0, adder);
    }
    
    public Integer quickSumPrice(List<Donut> donuts) {
        return donuts.stream()
                       .map(Donut::getPrice)
                       .parallel()
                       .reduce(0, adder);
    }
}
