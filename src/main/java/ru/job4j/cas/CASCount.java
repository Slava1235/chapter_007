package ru.job4j.cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;


@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();


    public final void increment() {
        Integer ref;
        Integer value;
        do {
            ref = count.get();
            value = ref + 1;
        } while (!count.compareAndSet(ref, value));
    }

    public int get() {
        return count.get();
    }
}
