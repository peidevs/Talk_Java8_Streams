package net.codetojoy;

public class Java8BusinessLogic implements BusinessLogic {

    // Notes:
    // declarative vs imperative
    // specifies "what" without "how"
    // new language features! lambda expressions, method references, default methods on interfaces
    
    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter( d -> d.getPrice() >= priceThreshold )
                     .sorted( comparing(Donut::getCalories).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( toList() );
    }
}
