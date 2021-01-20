package ru.job4j;

public class CountBarrier {
    private final Object monitor = this;

    private int total;

    private int count = 0;

    public CountBarrier(int total) {
        this.total = total;
    }

    public CountBarrier() {

    }


    public synchronized void count() {
        count++;
        monitor.notifyAll();
    }


    public synchronized void await() {
        try {
            while (count != total) {
                monitor.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier();
        Thread thread = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    countBarrier.await();
                    countBarrier.count();
                }
        );
        thread.start();
    }
}
