package com.kalosha.lab.shapes.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}
