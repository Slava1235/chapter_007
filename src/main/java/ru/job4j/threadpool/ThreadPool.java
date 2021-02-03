package ru.job4j.pool;

import ru.job4j.producerconsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private final int size = Runtime.getRuntime().availableProcessors();

    public void work(Runnable job) {
        for (int i = 0; i < size; i++) {
            Thread thread = new Thread((Runnable) tasks);
            thread.start();
        }
        tasks.offer(job);
        for (Thread t : threads) {
            t.interrupt();
        }
    }

    public void shutdown() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }
}