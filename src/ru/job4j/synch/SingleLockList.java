package ru.job4j.synch;


import ru.job4j.DynamicContainer;

import java.util.Iterator;

public class SingleLockList<T> implements Iterable<T> {
     private  final DynamicContainer<T> dynamicContainer = null;



    public synchronized void add(T value) {
        dynamicContainer.add(value);
    }

    public synchronized T get(int index) {
      return dynamicContainer.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
      return copy(this.dynamicContainer).iterator();
    }

    private Iterable<T> copy(DynamicContainer<T> dynamicContainer) {
        DynamicContainer<T> list = new DynamicContainer<>();
        if(dynamicContainer != null) {
            list.iterator().forEachRemaining(dynamicContainer::add);
        }
            return list;

    }
}
