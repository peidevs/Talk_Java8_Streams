package net.codetojoy;

import java.util.function.Predicate;

// expanding lambdas into the old-style anon classes

public class Java8BusinessLogic implements BusinessLogic {

    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter( (Donut d) -> d.getPrice() >= priceThreshold )
                     .sorted( comparing(Donut::getPrice).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( toList() );
    }

    public List<String> uglyReport2(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter(new Predicate<Donut> () {
                                 public boolean test(Donut d) {
                                     return d.getPrice() >= priceThreshold;
                                 }
                             })
                     .sorted( comparing(Donut::getPrice).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( toList() );
    }
}
