package com.company;


public class Generator implements Observer{
    private String name;
    private final String type =  "generator";
    private int floor;

    @Override
    public String toString() {
        return "Generator{" +
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
