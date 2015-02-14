
class GroovyBusinessLogic {
    
    // Groovy implementation of the ugly report 
    
    public def uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        def results = donuts.findAll{ d -> d.getPrice() >= priceThreshold }
                            .sort{ d -> d.getCalories() }
                            .reverse()
                            .take(numDonuts)
                            .collect{ d -> d.getName() }
        
        return results;        
    }    
}
