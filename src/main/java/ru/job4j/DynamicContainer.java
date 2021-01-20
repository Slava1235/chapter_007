package ru.job4j;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicContainer<E> implements Iterable<E> {

    private Object[] container;

    private int size = 0;

    private int modCount = 0;

    public DynamicContainer() {
        container = new Object[1];
    }

    public DynamicContainer(int initialCapacity) {
        container = new Object[initialCapacity];
    }

    public void add(E value) {
        modCount++;
        ensureCapacity();
        container[size++] = value;
    }

    private void ensureCapacity() {
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    public E get(int index) {
        return (E) container[index];
    }

    public int getLength() {
        return container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                checkModCount();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}