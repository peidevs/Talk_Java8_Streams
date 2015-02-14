package net.codetojoy;

public class Java8BusinessLogic implements BusinessLogic {

    // Notes:
    // declarative vs imperative
    // specifies "what" without "how"
    //     - we get optimizations (such as short-circuiting) for free
    //
    // new language features in their natural habitat: 
    //     - lambda expression (see filter)
    //     - method references (see map)
    //     - default methods on interfaces (see sorted / Comparator.comparing() )
    
    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        return donuts.stream()
                     .filter( d -> d.getPrice() >= priceThreshold )
                     .sorted( comparing(Donut::getCalories).reversed() )
                     .map(Donut::getName)
                     .limit(numDonuts)
                     .collect( toList() );
    }
}
