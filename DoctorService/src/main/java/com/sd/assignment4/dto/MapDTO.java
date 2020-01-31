package com.sd.assignment4.dto;

import java.util.HashMap;

public class MapDTO {

    public HashMap<String, Long> activityMap;

    public MapDTO() {
        activityMap = new HashMap<>();
    }

    public MapDTO(HashMap<String, Long> activityMap) {
        this.activityMap = activityMap;
    }

    public HashMap<String, Long> getMap() {
        return activityMap;
    }

    public void setMap(HashMap<String, Long> activityMap) {
        this.activityMap = activityMap;
    }
}
