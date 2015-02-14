package net.codetojoy;

// no one would sum integers this way.
// A SimpleAdder is only a setup for a LegacyAdder

public class Java8BusinessLogic {
    
    private BinaryOperator<Integer> adder = new SimpleAdder();
        
    public Integer sumPrice(List<Donut> donuts) {
        return donuts.stream()
                       .map(Donut::getPrice)
                       .reduce(0, adder);
    }    
}
