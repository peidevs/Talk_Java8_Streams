package net.codetojoy;

// example of a parallel stream 

public class Java8BusinessLogic {
    
    private BinaryOperator<Integer> adder = new LegacyAdder();
            
    public Integer quickSumPrice(List<Donut> donuts) {
        return donuts.stream()
                       .map(Donut::getPrice)
                       .parallel()
                       .reduce(0, adder);
    }
}
