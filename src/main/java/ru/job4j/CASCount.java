package ru.job4j;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;


@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();
    int value;


    public final void increment() {
        Integer ref;
        do {
            ref = count.get();
            Integer value = ref + 1;
        } while (count.compareAndSet(ref, value));
    }

    public int get() {
        return count.get();
    }
}
