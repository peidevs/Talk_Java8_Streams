package net.codetojoy;

import java.util.*;
import net.codetojoy.utils.*;

class OldBusinessLogic implements BusinessLogic {
        
    // don't do this at home (or at work!)
    // ugly straw-man to serve as talking points 
    //
    // Notes: imperative, mixes "what" with "how", external iteration, legacy Collections.sort() method
    
    public List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts) {
        List<String> results = new ArrayList<>();
        
        // filter
        List<Donut> filtered = new ArrayList<>();
        
        for (Donut d : donuts) {
            if (d.getPrice() >= priceThreshold) {
                filtered.add(d);
            }
        }
        
        // sort
        Collections.sort(filtered, new Comparator<Donut> () {
            public int compare(Donut d1, Donut d2) {
                return Integer.compare(d2.getCalories(),d1.getCalories());
            }
        });
        
        // limit 
        int count = 0;
        for (Donut d : filtered) {
            results.add(d.getName());
            
            if (count == numDonuts) {
                break;
            }
            
            count++;
        }
        
        return results;
    }    
}
