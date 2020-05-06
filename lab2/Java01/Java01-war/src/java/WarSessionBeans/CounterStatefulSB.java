package WarSessionBeans;

import java.io.Serializable;

public class CounterStatefulSB implements CounterStatefulSBLocal, Serializable {

    int data = 0;
    
    @Override
    public int increment() {
        return ++data;
    }

    @Override
    public int get() {
        return data;
    }
    
}
