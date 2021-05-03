package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Microchip hydrogenMicrochip = new Microchip();
        hydrogenMicrochip.setFloor(1);
        hydrogenMicrochip.setName("hydrogen");

        Microchip lithiumMicrochip = new Microchip();
        lithiumMicrochip.setFloor(1);
        lithiumMicrochip.setName("lithium");


        Generator hydrogenGenerator = new Generator();
        hydrogenGenerator.setFloor(2);
        hydrogenGenerator.setName("hydrogen");

        Generator lithiumGenerator = new Generator();
        lithiumGenerator.setName("lithium");
        lithiumGenerator.setFloor(3);


        Elevator elevator = new Elevator();
        elevator.setName("elevator");
        elevator.setFloor(1);
        IsolatedArea isolatedArea = new IsolatedArea();


        for(int i=0;i<4;i++){
            isolatedArea.addFloor();
        }
        isolatedArea.registerObserver(elevator,0);
        isolatedArea.registerObserver(hydrogenMicrochip,0);
        isolatedArea.registerObserver(lithiumMicrochip,0);
        isolatedArea.registerObserver(hydrogenGenerator,1);
        isolatedArea.registerObserver(lithiumGenerator,2);
        isolatedArea.arrange();
        isolatedArea.printArea();





    }
}
