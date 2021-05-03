package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsolatedArea implements Subject{
    ArrayList<ArrayList<Observer>> areaComponents;

    public IsolatedArea() {
        areaComponents =  new ArrayList<ArrayList<Observer> >();
    }

    public void addFloor(){
        areaComponents.add(new ArrayList<Observer>());
    }
    @Override
    public void registerObserver(Observer o,int floor) {
        areaComponents.get(floor).add(o);
    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {
    }
    public void printArea(){
        for(int i=0;i<areaComponents.size();i++){
            for(int j=0;j<areaComponents.get(i).size();j++){
                System.out.println(areaComponents.get(i).get(j));
            }
            System.out.println();
        }
    }
    public boolean containsName(List<Observer> list, final String type){
        return list.stream().anyMatch(o -> o.getName().equals(type));
    }

    public Long countFreq( List<Observer> list,Observer observer){
        Map<String, Long> nameFrequency = list.stream().collect(
                Collectors.groupingBy(Observer::getName,
                        Collectors.counting()));
        return nameFrequency.get(observer.getName());
    }

    public Observer returnObserver(String type, int i){
        for(Observer o : areaComponents.get(i)){
            if(o.getType().equals(type)){
                return  o;
            }
        }
        return null;
    }


    public void arrange(){
        Observer o;
        List<Observer> observersList;
        for(int i=0;i<areaComponents.size();i++){
            for(int j=0;j<areaComponents.get(i).size();j++) {
                if(containsName(areaComponents.get(i), "elevator")){
                    o = returnObserver("elevator",i);
                    if(containsName(areaComponents.get(i+1),areaComponents.get(i).get(j).getName())){
                        areaComponents.get(i+1).add(areaComponents.get(i).get(j));
                        areaComponents.get(i).get(j).setFloor(i+2);
                        areaComponents.get(i).remove(areaComponents.get(i).get(j));
                        areaComponents.get(i+1).add(o);
                        areaComponents.get(i).remove(o);
                        o.setFloor(i+2);
                    }
                    else if(countFreq(areaComponents.get(i),areaComponents.get(i).get(j))==2){
                        areaComponents.get(i+1).add(areaComponents.get(i).get(j));
                        areaComponents.get(i).get(j).setFloor(i+2);
                        areaComponents.get(i).remove(areaComponents.get(i).get(j));
                        if(containsName(areaComponents.get(i+1),areaComponents.get(i).get(j).getName())){
                            areaComponents.get(i+1).add(areaComponents.get(i).get(j));
                            areaComponents.get(i).get(j).setFloor(i+2);
                            areaComponents.get(i).remove(areaComponents.get(i).get(j));
                            o.setFloor(i+2);
                        }
                    }
                }
            }
        }
    }
}
