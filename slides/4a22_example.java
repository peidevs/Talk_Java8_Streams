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

     // Q: if filter() and map() were to print, what would be the output ?
     //
     // A: See below.
     //    (a) We observe output because we have used a terminal operator to morph from a stream into a collection, which
     //        presses the computation into action.
     //    (b) Note the pipeline effect. Each value winds through the operators until it is either discarded or used.
     //        So, "100" goes through filter and then map, etc before "200" gets a turn.
     //    (c) At "300", the limit is satisfied so the computation is complete. This means that subsequent values are irrelevant.
     //        i.e. the sequence can be indefinitely long. This is a finite, rational computation on an infinite sequence! 

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
