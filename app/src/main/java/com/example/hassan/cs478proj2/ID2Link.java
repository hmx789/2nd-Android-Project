package com.example.hassan.cs478proj2;

import android.content.res.Resources;

import java.util.HashMap;

public class ID2Link {

    private static HashMap<Integer, String> links = null;

    public static HashMap<Integer, String> getMap() {
        if (links == null) {
            links = new HashMap<>();
            links.put(2131165305,"https://www.toyota.com/camry/");
            links.put(2131165276,"https://www.bmwusa.com/vehicles/m-models/m5.html");
            links.put(2131165287,"https://www.jaguarusa.com/all-models/f-type/index.html");
            links.put(2131165288,"https://www.maseratiusa.com/maserati/us/en/models/ghibli");
            links.put(2131165286,"https://www.infinitiusa.com/vehicles/sedans/q50.html\"");
            links.put(2131165283,"https://automobiles.honda.com/accord-sedan");
        }
        return links;
    }


}