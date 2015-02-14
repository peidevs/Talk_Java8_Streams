package net.codetojoy;

import java.util.List;

interface BusinessLogic {
    
    // The pointy-haired boss requested a report such that:
    //     - filter donuts by priceThreshold
    //     - sort by calories (descending)
    //     - return top N donuts, by name
    //
    // (There's a lot wrong with this from a design standpoint, but we'll hold our noses for now.)

    List<String> uglyReport(List<Donut> donuts, int priceThreshold, int numDonuts);
    
};
