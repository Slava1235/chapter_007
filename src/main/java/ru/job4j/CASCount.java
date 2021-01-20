package ru.job4j;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;


@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();
    int value;
    Integer ref;

    public final void increment() {
        while (count.compareAndSet(ref, value)) {
            Integer ref = count.get();
            Integer value = ref + 1;
        }
    }

    public int get() {
        return count.get();
    }
}
