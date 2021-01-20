package ru.job4j.synch;


import java.util.Iterator;


public class SingleLockList<T> implements Iterable<T> {
    private final DynamicContainer<T> dynamicContainer = new DynamicContainer<>();


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

    public Iterable<T> copy(DynamicContainer<T> dynamicContainer) {
       DynamicContainer<T> list = new DynamicContainer<>();
      dynamicContainer.iterator().forEachRemaining(list::add);
        return dynamicContainer;

    }
}
