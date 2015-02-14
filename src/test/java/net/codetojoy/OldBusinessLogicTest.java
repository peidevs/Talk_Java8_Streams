package net.codetojoy;

import static net.codetojoy.Donut.Type.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class OldBusinessLogicTest {
    private BusinessLogic businessLogic = new OldBusinessLogic();
    private List<Donut> donuts;
    
    @Test
    public void testUglyReport() {
        donuts = populateB();
        
        // test
        List<String> results = businessLogic.uglyReport(donuts, 100, 3);
        
        assertEquals("Boston Cream",  results.get(0));
        assertEquals("Old Fashioned",  results.get(1));
        assertEquals("Chocolate Glaze",  results.get(2));
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
}
