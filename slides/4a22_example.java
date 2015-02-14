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
    List<String> results = 

            donuts.stream()
                 .filter(d -> d.getPrice() >= priceThreshold) // print "filter : price"
                 .map(Donut::getName)                         // print "map : name"
                 .limit(numDonuts)
                 .collect( toList() );

/*
                  lazyB filter : 10                    
                  lazyB filter : 20
                 
                  lazyB filter : 100
                  lazyB map : a
                 
                  lazyB filter : 200
                  lazyB map : b
                 
                  lazyB filter : 300
                  lazyB map : c
*/
}
