package ru.job4j.producerConsumer;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
   private int capacity = 6;

    public Queue<T> getQueue() {
        return queue;
    }

    //блокирует продвижение до появления элемента в пустой очереди
    synchronized public void offer(T value) throws InterruptedException {

        while (queue.size() >= capacity) {
            wait();
        }

        queue.add(value);
        notify();
        Thread.sleep(1000);
    }

    //блокирует продвижение до тех пор, пока не освободится место в заполненной очереди
    synchronized public T poll() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
    
        notify();
        Thread.sleep(1000);
        return queue.poll();
    }


}


