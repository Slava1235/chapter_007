package ru.job4j.cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;


@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<Integer>(0);


    public final void increment() {
        int ref;
        int value;
        do {
            ref = count.get();
            value = ref + 1;

        } while (!count.compareAndSet(ref, value));
    }

    public int get() {
        return count.get();
    }
}
