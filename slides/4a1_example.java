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
                     .filter(d -> d.getPrice() >= priceThreshold) // print "filter : price"
                     .map(Donut::getName)                         // print "map : name"
                     .limit(numDonuts);

    // Q: if filter() and map() were to print, what would be the output ?
    //
    // A: Nothing. Here, we are using intermediate operators which are lazy (vs eager). So this stream is a
    //    configured "Rube Goldberg machine" that is ready to compute, but has not yet computed anything at all.
    //
    // [1] - http://en.wikipedia.org/wiki/Rube_Goldberg_machine
    
    assertNotNull(s);
}
