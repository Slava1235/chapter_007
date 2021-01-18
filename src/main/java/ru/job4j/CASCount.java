package ru.job4j;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;


@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();
    int value;

    public final void increment() {
        Integer ref = count.get();
        do {
            value = count.get();
        }
        while (count.compareAndSet(ref, value));
        this.value++;
    }

    public int get() {
        Integer ref = count.get();
        do {
            value = count.get();
        }
        while (count.compareAndSet(ref, value));
        return value;
    }
}
