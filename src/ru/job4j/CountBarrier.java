package ru.job4j;

public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        count++;
    }

    public void await() {
        if (count != total) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            monitor.notifyAll();
        }
    }

}
