package ru.job4j.producerconsumer;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;


@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * This annotation do collection synchronized.
     *
     * @param queue collection for work producer and consumer
     */
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    /**
     * This annotation do int synchronized.
     *
     * @param capacity counter for line producer and consumer
     */
    @GuardedBy("this")
    private int capacity = 6;

    /**
     * blocks progress until an item appears in an empty queue.
     *
     * @param value SimpleBlockingQueue
     */
    public synchronized void offer(T value) {
        while (queue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(value);
        notify();
    }

    /**
     * blocks progress until space becomes free in a full queue.
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        notify();
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}


