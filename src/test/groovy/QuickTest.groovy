
import net.codetojoy.*
import static net.codetojoy.Donut.Type.*

class GroovyBusinessLogic {
    public def uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        def results = donuts.findAll{ d -> d.getPrice() >= priceThreshold }
                            .sort{ d -> d.getCalories() }
                            .reverse()
                            .take(numDonuts)
                            .collect{ d -> println "TRACER collect" ; d.getName() }
        
        return results;        
    }    
}

// test 

donuts = []
donuts << new Donut(100, 310, "a", TRADITIONAL)
donuts << new Donut(200, 320, "b", JELLY)
donuts << new Donut(300, 330, "c", JELLY)
donuts << new Donut(400, 340, "Chocolate Glaze", OTHER)
donuts << new Donut(500, 350, "Old Fashioned", OTHER)
donuts << new Donut(600, 360, "Boston Cream", OTHER)

donuts << new Donut(10, 110, "g", TRADITIONAL)
donuts << new Donut(20, 120, "h", JELLY)
donuts << new Donut(30, 130, "i", OTHER)

results = new GroovyBusinessLogic().uglyReport(donuts, 100, 3)
assert 3 == results.size()
assert "Boston Cream" == results[0]
assert "Old Fashioned" == results[1]
assert "Chocolate Glaze" == results[2]

println "Ready."

