package net.codetojoy;

// example of a parallel stream 
//
// By using this operator, the stream will invoke the fork-join threading framework from Java 7.
//
// Pros: that's insanely powerful
// Cons: you need to know what you're doing re: designing for concurrency

public class Java8BusinessLogic {
    
    private BinaryOperator<Integer> adder = new LegacyAdder();
            
    public Integer quickSumPrice(List<Donut> donuts) {
        return donuts.stream()
                       .map(Donut::getPrice)
                       .parallel()
                       .reduce(0, adder);
    }
}
