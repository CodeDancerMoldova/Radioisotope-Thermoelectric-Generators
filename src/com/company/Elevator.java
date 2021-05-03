package com.company;

public class Elevator implements Observer{

    private String name;
    private final String type =  "elevator";
    private int floor;

    @Override
    public String toString() {
        return "Elevator{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", floor=" + floor +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
