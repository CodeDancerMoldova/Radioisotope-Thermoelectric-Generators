package com.company;

import lombok.Data;


public class Microchip implements Observer{
    private String name;
    private final String type = "microchip";
    private int floor;

    public void setName(String name) {
        this.name = name;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Microchip{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", floor=" + floor +
                '}';
    }
}
