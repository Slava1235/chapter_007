package ru.job4j.pool;

import ru.job4j.producerconsumer.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;


public class ThreadPool {
    private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final List<Thread> pool = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);

    public ThreadPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(new Thread(
                    () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                tasks.poll().run();
                                System.out.println(Thread.currentThread().getName());
                            }
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        }
                    }
            ));
        }
        pool.forEach(Thread::start);
    }


    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        pool.forEach(Thread::interrupt);
    }

//    public static void main(String[] args) {
//      ThreadPool threadPool = new ThreadPool();
//        for (int i = 0; i < 4; i++) {
//            int count = i;
//            threadPool.work(() -> System.out.println("Task " + count));
//        }
//        threadPool.shutdown();
//    }
}