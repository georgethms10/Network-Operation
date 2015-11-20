package com.innowaves.networktest;

import java.util.List;

/**
 * Created by sics on 9/3/2015.
 */
public class StationListBackend {

    public boolean result;
    public List<Stations> station;
    public String error;

    public class Stations {

        public String id;
        public String station_name;
        public String stationImage;
    }
}
