package net.codetojoy;

import java.util.function.Function;

// expansion of method reference to old-style anonymous class
//
// Compare "map" in each method

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
                     .sorted( comparing(Donut::getPrice).reversed() )
                     .map(new Function<Donut,String> () {
                             public String apply(Donut d) {
                                 return d.getName();
                             }
                      })
                     .limit(numDonuts)
                     .collect( toList() );
    }
}
