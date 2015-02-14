package net.codetojoy;

import java.util.stream.Collectors;
import java.util.Comparator;

// example of default methods (e.g. comparing) in Comparator interface
//
// Comparator is a legacy interface, but can now have new methods such as comparing(). This is in 
// stark contrast to awkward designs such as Collections.sort()

public class Java8BusinessLogic implements BusinessLogic {

    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter( d -> d.getPrice() >= priceThreshold )
                     .sorted( comparing(Donut::getPrice).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( toList() );
    }

    public List<String> uglyReport2(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter( d -> d.getPrice() >= priceThreshold )
                     .sorted( Comparator.comparing(Donut::getPrice).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( Collectors.toList() );
    }
}
