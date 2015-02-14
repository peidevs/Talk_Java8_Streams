
@Test
public void testUglyReport() {
    List<Donut> donuts = new ArrayList<>();
    
                    // price,  cal, name, type
    donuts.add( new Donut(100, 310, "a", TRADITIONAL) );
    donuts.add( new Donut(200, 320, "b", JELLY) );
    donuts.add( new Donut(300, 330, "c", JELLY) );

    donuts.add( new Donut(400, 340, "Chocolate Glaze", TRADITIONAL) );
    donuts.add( new Donut(500, 350, "Old Fashioned", TRADITIONAL) );
    donuts.add( new Donut(600, 360, "Boston Cream", JELLY) );
    
    donuts.add( new Donut(10, 110, "g", TRADITIONAL) );
    donuts.add( new Donut(20, 120, "h", JELLY) );
    donuts.add( new Donut(30, 130, "i", OTHER) );
    
    // test
    List<String> results = businessLogic.uglyReport(donuts, 100, 3);
    
    assertEquals("Boston Cream",  results.get(0));
    assertEquals("Old Fashioned",  results.get(1));
    assertEquals("Chocolate Glaze",  results.get(2));
}
