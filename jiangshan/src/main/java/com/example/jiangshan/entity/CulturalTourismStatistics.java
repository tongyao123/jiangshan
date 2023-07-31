package com.example.jiangshan.entity;

import java.util.HashMap;
import java.util.List;

public class CulturalTourismStatistics {
    private Integer attractionsNumber;
    private Integer homestayNumber;
    private Integer restaurantNumber;

    private List<HashMap> turnoverList;

    public Integer getAttractionsNumber() {
        return attractionsNumber;
    }

    public void setAttractionsNumber(Integer attractionsNumber) {
        this.attractionsNumber = attractionsNumber;
    }

    public Integer getHomestayNumber() {
        return homestayNumber;
    }

    public void setHomestayNumber(Integer homestayNumber) {
        this.homestayNumber = homestayNumber;
    }

    public Integer getRestaurantNumber() {
        return restaurantNumber;
    }

    public void setRestaurantNumber(Integer restaurantNumber) {
        this.restaurantNumber = restaurantNumber;
    }

    public List<HashMap> getTurnoverList() {
        return turnoverList;
    }

    public void setTurnoverList(List<HashMap> turnoverList) {
        this.turnoverList = turnoverList;
    }

}
