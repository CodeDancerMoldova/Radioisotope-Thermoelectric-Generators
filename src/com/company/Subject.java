package com.company;

public interface Subject {
    public  void registerObserver(Observer o,int floor);
    public  void removeObserver(Observer o);
    public  void notifyObservers();
}
