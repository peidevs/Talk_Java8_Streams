package net.codetojoy.stream;

import net.codetojoy.Donut;
import static net.codetojoy.Donut.Type.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
import java.util.function.*;
import java.util.stream.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ExploreTest {
    private List<Donut> donuts = new ArrayList<>();

    @Test
    public void testGroupByType() {        
        donuts = populateA();
        int priceThreshold = 100;
        
        // test
        Map<Donut.Type, List<Donut>> results = 
                                   donuts.stream()
                                         .filter(d -> d.getPrice() >= priceThreshold)
                                         .collect(groupingBy(Donut::getType));
        
        assertEquals(1, results.get(TRADITIONAL).size());
        assertEquals(2, results.get(JELLY).size());
        assertEquals(3, results.get(OTHER).size());
    }

    @Test
    public void testSum() {        
        donuts = populateA();
        
        // test
        int result = donuts.stream()
                           .mapToInt(Donut::getPrice)
                           .sum();

        assertEquals(2160, result);
    }

    @Test
    public void testLazyA_Tight() {        
                        // price, cal, name, type
        donuts.add( new Donut(10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut(20, 120, "h", JELLY) );
        
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "d", OTHER) );
        
        int priceThreshold = 100;
        int numDonuts = 3;
        
        // test
        Stream s = donuts.stream()
                         .filter(d -> d.getPrice() >= priceThreshold)
                         .map(Donut::getName)
                         .limit(numDonuts);

        assertNotNull(s);
    }

    @Test
    public void testLazyA() {        
                        // price, cal, name, type
        donuts.add( new Donut(10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut(20, 120, "h", JELLY) );
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "d", OTHER) );
        int priceThreshold = 100;
        int numDonuts = 3;
        
        // test
        Stream s = donuts
                     .stream()
                     .filter(new Predicate<Donut> () {
                                public boolean test(Donut d) {
                                    System.out.println("TRACER lazyA filter");
                                    return d.getPrice() >= priceThreshold;
                                }
                            })
                     .map(new Function<Donut,String> () {
                                public String apply(Donut d) {
                                    System.out.println("TRACER lazyA map");
                                    return d.getName();
                                }
                            })
                     .limit(numDonuts);

        assertNotNull(s);
    }

    @Test
    public void testLazyB_Tight() {
                        // price, cal, name, type
        donuts.add( new Donut( 10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut( 20, 120, "h", JELLY) );
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "d", OTHER) );
        
        int priceThreshold = 100;
        int numDonuts = 3;
        
        // test
        List<String> results = donuts
                                 .stream()
                                 .filter(d -> d.getPrice() >= priceThreshold)
                                 .map(Donut::getName)
                                 .limit(numDonuts)
                                 .collect( toList() );

        assertEquals(3, results.size());
    }

    @Test
    public void testLazyB() {
                        // price, cal, name, type
        donuts.add( new Donut( 10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut( 20, 120, "h", JELLY) );
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "d", OTHER) );
        
        int priceThreshold = 100;
        int numDonuts = 3;
        
        // test
        List<String> results = donuts
                                 .stream()
                                 .filter(new Predicate<Donut> () {
                                            public boolean test(Donut d) {
                                                System.out.println("TRACER lazyB filter : " + d.getPrice());
                                                return d.getPrice() >= priceThreshold;
                                            }
                                        })
                                 .map(new Function<Donut,String> () {
                                            public String apply(Donut d) {
                                                System.out.println("TRACER lazyB map : " + d.getName());
                                                return d.getName();
                                            }
                                        })
                                 .limit(numDonuts)
                                 .collect( toList() );

        assertEquals(3, results.size());
    }
        
    // ---------------------------------
    
    private List<Donut> populateA() {        
        List<Donut> donuts = new ArrayList<>();
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "d", OTHER) );
        donuts.add( new Donut(500, 350, "e", OTHER) );
        donuts.add( new Donut(600, 360, "f", OTHER) );
        
        donuts.add( new Donut(10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut(20, 120, "h", JELLY) );
        donuts.add( new Donut(30, 130, "i", OTHER) );
        return donuts;
    }    

    private List<Donut> populateB() {        
        List<Donut> donuts = new ArrayList<>();
        donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
        donuts.add( new Donut(200, 320, "b", JELLY) );
        donuts.add( new Donut(300, 330, "c", JELLY) );
        donuts.add( new Donut(400, 340, "Chocolate Glaze", OTHER) );
        donuts.add( new Donut(500, 350, "Old Fashioned", OTHER) );
        donuts.add( new Donut(600, 360, "Boston Cream", OTHER) );
        
        donuts.add( new Donut(10, 110, "g", TRADITIONAL) );
        donuts.add( new Donut(20, 120, "h", JELLY) );
        donuts.add( new Donut(30, 130, "i", OTHER) );
        return donuts;
    }            
    
    private List<Donut> populateC(int numDonuts) {        
        List<Donut> donuts = new ArrayList<>();
        
        for (int i = 0; i < numDonuts; i++) {
            donuts.add( new Donut(1, i, "donut" + i, JELLY) );            
        }
        
       return donuts;
    }    
}
